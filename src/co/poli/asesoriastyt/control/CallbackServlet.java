package co.poli.asesoriastyt.control;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.http.NameValuePair;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import co.poli.asesoriastyt.dao.DAOPerfiles;
import co.poli.asesoriastyt.dao.DAOPersonas;
import co.poli.asesoriastyt.model.EstudianteAsesoria;
import co.poli.asesoriastyt.model.GooglePlusUser;
import co.poli.asesoriastyt.model.Persona;
import co.poli.asesoriastyt.negocio.NPerfiles;
import co.poli.asesoriastyt.negocio.NPersona;
import co.poli.asesoriastyt.util.Conexion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;


/**
 *  Class CallbackServlet.
 *  @author Natalia Díaz , Natalia Velez , Paola Vargas
 */
public class CallbackServlet extends HttpServlet {
	
	/**  Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/**  dao. */
	private NPerfiles dao;
	private NPersona daop;
	
	/**  c. */
	Connection c;

	/**
	 * Gets  web content from ur l_ post.
	 *
	 * @param httpURL  http url
	 * @param nvps  nvps
	 * @return  web content from ur l_ post
	 */
	public static JSONObject getWebContentFromURL_Post(String httpURL, List<NameValuePair> nvps) {

		HttpPost httpPost = null;
		JSONObject json = new JSONObject();

		try {
			httpPost = new HttpPost(httpURL);
			DefaultHttpClient httpclient = new DefaultHttpClient();
			UrlEncodedFormEntity url = new UrlEncodedFormEntity(nvps);
			httpPost.setEntity(new UrlEncodedFormEntity(nvps));
			HttpResponse response = httpclient.execute(httpPost);

			System.out.println(response.getStatusLine());
			System.out.println(response.toString());

			BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "UTF-8"));
			StringBuilder builder = new StringBuilder();
			for (String line = null; (line = reader.readLine()) != null;) {
				builder.append(line).append("\n");
			}

			System.out.println(builder.toString());

			json = (JSONObject) new JSONParser().parse(builder.toString());
			// System.out.println("name=" + json.get("name"));
			// System.out.println("width=" + json.get("width"));

			EntityUtils.consume(response.getEntity());
		} catch (Exception ex) {
			System.out.print(ex.getMessage());
		} finally {
			// httpPost.releaseConnection();

		}
		return json;
	}

	/**
	 * Gets  web content from ur l_ get.
	 *
	 * @param httpURL  http url
	 * @return  web content from ur l_ get
	 */
	private static JSONObject getWebContentFromURL_Get(String httpURL) {

		HttpGet httpGet = null;
		JSONObject json = new JSONObject();

		try {
			DefaultHttpClient httpclient = new DefaultHttpClient();
			httpGet = new HttpGet(httpURL);
			HttpResponse response = httpclient.execute(httpGet);

			System.out.println(response.getStatusLine());
			System.out.println(response.toString());

			BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "UTF-8"));
			StringBuilder builder = new StringBuilder();
			for (String line = null; (line = reader.readLine()) != null;) {
				builder.append(line).append("\n");
			}

			System.out.println(builder.toString());

			json = (JSONObject) new JSONParser().parse(builder.toString());
			// System.out.println("name=" + json.get("name"));
			// System.out.println("width=" + json.get("width"));

			EntityUtils.consume(response.getEntity());

		} catch (Exception ex) {
			System.out.print(ex.getMessage());
		} finally {
			// httpGet.releaseConnection();
		}
		return json;
	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code = null;
		String googlePlusClientId = getServletContext().getInitParameter("googlePlusClientId");
		String googlePlusClientSecret = getServletContext().getInitParameter("googlePlusClientSecret");
		String redirectURL = null;
		String accessURL = null;
		String apiURL = null;
		String accessToken = null;
		JSONObject webContent = null;
		JSONObject userJson = null;
		HttpPost httpPost = null;

		try {
			StringBuffer redirectURLbuffer = request.getRequestURL();
			int index = redirectURLbuffer.lastIndexOf("/");
			redirectURLbuffer.replace(index, redirectURLbuffer.length(), "").append("/callback");
			redirectURL = redirectURLbuffer.toString();
			// URLEncoder.encode(redirectURLbuffer.toString(), "UTF-8");

			code = request.getParameter("code");
			if (null != code) {
				System.out.println("Code: " + code);
				accessURL = "https://accounts.google.com/o/oauth2/token";

				List<NameValuePair> nvps = new ArrayList<NameValuePair>();
				nvps.add(new BasicNameValuePair("client_id", googlePlusClientId));
				nvps.add(new BasicNameValuePair("client_secret", googlePlusClientSecret));
				nvps.add(new BasicNameValuePair("grant_type", "authorization_code"));
				nvps.add(new BasicNameValuePair("redirect_uri", redirectURL));
				nvps.add(new BasicNameValuePair("code", code));

				System.out.println("accessURL: " + accessURL);

				webContent = getWebContentFromURL_Post(accessURL, nvps);
				accessToken = (String) webContent.get("access_token");
			} else {
				response.sendRedirect(request.getContextPath() + getServletContext().getInitParameter("loginErrorPage"));
				return;
			}

			if (null != accessToken) {
				System.out.println("accessToken: " + accessToken);
				apiURL = "https://www.googleapis.com/oauth2/v1/userinfo?access_token=" + accessToken;
				userJson = getWebContentFromURL_Get(apiURL);

				GooglePlusUser googlePlusUser = new GooglePlusUser(userJson.get("id").toString(), userJson.get("email").toString());
				request.getSession().setAttribute("googlePlusUser", googlePlusUser);
				request.getSession().setAttribute("emailUser", userJson.get("email"));
				
				daop= new NPersona();
				dao = new NPerfiles();
				
				String email = userJson.get("email").toString();
				int existe = 0;

				HttpSession session = request.getSession();
				session.setAttribute("emailUsuario", new String(email));
				String documento=daop.BuscarDocente(email);
				Persona persona=daop.Buscar(documento);
				existe = dao.consultarUsuario(email);
				
				if (existe > 0) {
					if (existe == 1) {
						response.sendRedirect(request.getContextPath() + getServletContext().getInitParameter("loginSuccessPage"));
						request.getSession().setAttribute("Perfil", "1");
					}
					if (existe == 2) {
						request.getSession().setAttribute("cli",persona);
						response.sendRedirect(request.getContextPath() + getServletContext().getInitParameter("loginSuccessPage2"));
						request.getSession().setAttribute("Perfil", "2");
						
					}
					if (existe == 3) {
						response.sendRedirect(request.getContextPath() + getServletContext().getInitParameter("loginSuccessPage3"));
						request.getSession().setAttribute("Perfil", "3");
					}
				} else {
					request.getSession().invalidate();
					response.sendRedirect(request.getContextPath() + getServletContext().getInitParameter("loginErrorPage"));
				}
			}

			if (null == accessToken)
				response.sendRedirect(request.getContextPath() + getServletContext().getInitParameter("loginErrorPage"));

		} catch (Exception e) {
			response.sendRedirect(request.getContextPath() + getServletContext().getInitParameter("loginErrorPage"));
			throw new ServletException(e);
		}
	}
}

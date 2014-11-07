package co.poli.asesoriastyt.control;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.expressme.openid.Association;
import org.expressme.openid.Authentication;
import org.expressme.openid.Endpoint;
import org.expressme.openid.OpenIdException;
import org.expressme.openid.OpenIdManager;

import co.poli.asesoriastyt.dao.DAOPerfiles;
import co.poli.asesoriastyt.model.GYUser;




public class GYLoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	static final long ONE_HOUR = 3600000L;
    static final long TWO_HOUR = ONE_HOUR * 2L;
    static final String ATTR_MAC = "openid_mac";
    static final String ATTR_ALIAS = "openid_alias";
    private OpenIdManager manager;
    private DAOPerfiles dao;

    @Override
    public void init() throws ServletException {
        super.init();
        manager = new OpenIdManager();
        String warFileName = getServletContext().getInitParameter("warFileName");
        String webDomainName = getServletContext().getInitParameter("webDomainName");
        if(!webDomainName.endsWith("/"))
        	webDomainName+="/";
        manager.setRealm(webDomainName+warFileName);
        manager.setReturnTo(webDomainName+warFileName+"/gylogin");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String op = request.getParameter("op");
        if (op==null) {
            try {
				// check sign on result from Google or Yahoo:
				checkNonce(request.getParameter("openid.response_nonce"));
				// get authentication:
				byte[] mac_key = (byte[]) request.getSession().getAttribute(ATTR_MAC);
				String alias = (String) request.getSession().getAttribute(ATTR_ALIAS);
				Authentication authentication = manager.getAuthentication(request, mac_key, alias);
				storeAuthenticationData(authentication, request.getSession(false));
				//dao=new PerfilesDAO();

				 String email= (String) request.getSession().getAttribute("email");
				 String correo = "elpoli.edu.co"; 
				 boolean existe=false;
				 
				 /*existe=dao.consultarUsuario(email);
				 

				 if (existe)
				 {
					 response.sendRedirect(request.getContextPath() + getServletContext().getInitParameter("loginSuccessPage"));
				 }
				 else 
				 {
					 request.getSession().invalidate();
					 response.sendRedirect(request.getContextPath() + getServletContext().getInitParameter("loginErrorPage"));
				 }*/
				 
				 
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
				response.sendRedirect(request.getContextPath() + getServletContext().getInitParameter("loginErrorPage"));
			}
        } 
        else if (op.equals("Google")) 
        {
            Endpoint endpoint = manager.lookupEndpoint(op);
            Association association = manager.lookupAssociation(endpoint);
            request.getSession().setAttribute(ATTR_MAC, association.getRawMacKey());
            request.getSession().setAttribute(ATTR_ALIAS, endpoint.getAlias());
           String url = manager.getAuthenticationUrl(endpoint, association);
            response.sendRedirect(url);
        } 
        else if (op.equals("logout")) 
        {
        	request.getSession().setAttribute("gyUser","");
			response.sendRedirect(request.getContextPath());
			//response.sendRedirect("https://www.google.com/accounts/Logout");
			String direccion = "https://www.google.com/accounts/Logout";
		
        } 
        else 
        {
        	System.out.println("Invalid Op received.");
			response.sendRedirect(request.getContextPath() + getServletContext().getInitParameter("loginErrorPage"));
        }
    }

    void storeAuthenticationData(Authentication auth, HttpSession session) {
    	//setting in session for front end use
    	GYUser gyUser = new GYUser(auth.getIdentity(),auth.getEmail(),auth.getFullname(),auth.getFirstname(),auth.getLastname(),auth.getGender(),auth.getLanguage());
    	session.setAttribute("gyUser", gyUser);
    	String email= gyUser.getFullname();
    	session.setAttribute("email", email);
    	
    }

    void checkNonce(String nonce) {
        // check response_nonce to prevent replay-attack:
        if (nonce==null || nonce.length()<20)
            throw new OpenIdException("Verify failed.");
        // make sure the time of server is correct:
        long nonceTime = getNonceTime(nonce);
        long diff = Math.abs(System.currentTimeMillis() - nonceTime);
        if (diff > ONE_HOUR)
            throw new OpenIdException("Bad nonce time.");
    	System.out.println(nonce);
    }

    long getNonceTime(String nonce) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                    .parse(nonce.substring(0, 19) + "+0000")
                    .getTime();
        }
        catch(ParseException e) {
            throw new OpenIdException("Bad nonce time.");
        }
    }
}

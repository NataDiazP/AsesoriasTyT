package co.poli.asesoriastyt.control;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;


/**
 *  Class LoginServlet.
 *  @author Natalia Díaz , Natalia Velez , Paola Vargas
 */
public class LoginServlet extends HttpServlet {
    
    /**  Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /* (non-Javadoc)
     * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String callbackURL = null;
    	String permissions = null;
        String permissionString = "";
        String permissionArray[];
        
        try {
            StringBuffer callbackURLbuffer = request.getRequestURL();
            int index = callbackURLbuffer.lastIndexOf("/");
            callbackURLbuffer.replace(index, callbackURLbuffer.length(), "").append("/callback");
            callbackURL = URLEncoder.encode(callbackURLbuffer.toString(), "UTF-8");
            
            String googlePlusClientId = getServletContext().getInitParameter("googlePlusClientId");
            
            permissions = getServletContext().getInitParameter("addtionalPermissions");
            permissionArray = permissions.split(",");
            for(String p: permissionArray) {
            	permissionString += URLEncoder.encode(p,"UTF-8") + "+";
            }
            
            System.out.println(permissions);
            
            String authURL = "https://accounts.google.com/o/oauth2/auth?scope=" + permissionString + "&state=profile" + 
            		"&redirect_uri=" + callbackURL + "&response_type=code" + "&client_id=" + googlePlusClientId;
            System.out.println("authURL: " + authURL);
            
            response.sendRedirect(authURL);

        } catch (Exception e) {
            throw new ServletException(e);
        }

    }
}

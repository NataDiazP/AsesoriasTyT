package co.poli.asesoriastyt.control;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;


/**
 *  Class LogoutServlet.
 *  @author Natalia Díaz , Natalia Velez , Paola Vargas
 */
public class LogoutServlet extends HttpServlet {
    
    /**  Constant serialVersionUID. */
    private static final long serialVersionUID = -4433102460849019660L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().invalidate();
        response.sendRedirect(request.getContextPath() + getServletContext().getInitParameter("login"));
    }
}

package servicios;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import modelo.entidades.dao.GestorUsuarios;

public class ServicioLogin extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setHeader("cache-control", "no-cache, no-store, must-revalidate");

        GestorUsuarios gUsuarios = new GestorUsuarios(
                getServletContext().getInitParameter("URL_servidor"));
        boolean usuarioValido = false;

        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");

        if (usuario != null && password != null) {
            usuarioValido = gUsuarios.verificarUsuario(
                    usuario, password);
        }

        if (usuarioValido) {

            HttpSession sesion = request.getSession(true);
            sesion.setAttribute("usuario", usuario);

            sesion.setMaxInactiveInterval(60 * 3);

            response.sendRedirect("datos.jsp");

        } else {

            response.sendRedirect("index.jsp?error=2");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods.">
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // No permite que los datos del usuario sean recibidos por
        // medio de GET.
        response.sendRedirect("index.jsp?error=0");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Servicio de ingreso de usuarios";
    }// </editor-fold>

}

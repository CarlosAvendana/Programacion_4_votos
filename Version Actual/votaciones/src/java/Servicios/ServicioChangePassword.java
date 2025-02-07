//  seirvicioChangePassword.java
//  EIF209 - Programacion 4 -Proeycto #1
//  Abril 2019
//
//  Autores:
//  Djenane Hernandez Rodriguez
//  Diego Monterrey Benavides
//Carlos Obando Avendaña
//esta se encarga de registrar las fechas de las nuevas votaciones
package Servicios;

import Gestores.GestorUsuario;
import Modelo.Usuario;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ServicioChangePassword", urlPatterns = {"/ServicioChangePassword"})
public class ServicioChangePassword extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            GestorUsuario gU = GestorUsuario.obtenerInstancia();

            String oldPassword = request.getParameter("oldPassword");
            String newPassword = request.getParameter("newPassword");

            if (oldPassword != null && newPassword != null) {
                if (!oldPassword.equals(newPassword)) {
                    Usuario e = gU.recuperar(oldPassword);
                    HttpSession sesion = request.getSession(true);
                    if (e != null) {
                        e.setClave(newPassword);
                        gU.actualizar(e);
                        sesion.setAttribute("oldPassword", e);

                        sesion.setMaxInactiveInterval(60 * 3);

                        response.sendRedirect("loginU.jsp");
                    }
                }
            } else {
                response.sendRedirect("loginError.jsp");
            }

        } catch (InstantiationException
                | ClassNotFoundException
                | IllegalAccessException ex) {
            System.err.printf("Error: %s", ex.getMessage());
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

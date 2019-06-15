package Servicios;

import Gestores.GestorPartido;
import Modelo.Partido;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.websocket.Decoder;

@WebServlet
@MultipartConfig()
public class ServicioCreaciondePartido extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, InstantiationException, ClassNotFoundException, IllegalAccessException {
        GestorPartido g1 = GestorPartido.obtenerInstancia();
        HttpSession sesion = request.getSession(true);
        try {

            String nombre = request.getParameter("nombre");
            String siglas = request.getParameter("siglas");
            String observaciones = request.getParameter("observaciones");

            Part part = request.getPart("archivo");

            String campo = part.getName();
            System.out.printf("Nombre del campo (formulario): '%s'%n", campo);

            String nombreArchivo = part.getSubmittedFileName();

            if (nombreArchivo.isEmpty()) {
                request.setAttribute("mensaje",
                        "Se omitió la selección del archivo.");
            }
            if (GestorPartido.validate(nombreArchivo)) {
                try {
                    g1.agregar(nombre, siglas, observaciones, part.getInputStream(), (int) part.getSize(), part.getContentType());
                } catch (Exception ex) {
                    response.sendRedirect("adminGeneral.jsp");
                    request.setAttribute("mensaje",
                            String.format("Excepción: '%s'", ex.getMessage()));
                }
            } else {
                response.sendRedirect("adminGeneral.jsp");
                request.setAttribute("mensaje",
                        "El formato del archivo es incorrecto.");
            }
        } catch (IOException | ServletException ex) {
            response.sendRedirect("adminGeneral.jsp");
            request.setAttribute("mensaje",
                    String.format("Ocurrió una excepción: '%s'", ex.getMessage()));
        }
        response.sendRedirect("adminGeneral.jsp");
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
        try {
            processRequest(request, response);
        } catch (InstantiationException ex) {
            Logger.getLogger(ServicioCreaciondePartido.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServicioCreaciondePartido.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ServicioCreaciondePartido.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (InstantiationException ex) {
            Logger.getLogger(ServicioCreaciondePartido.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServicioCreaciondePartido.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ServicioCreaciondePartido.class.getName()).log(Level.SEVERE, null, ex);
        }
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

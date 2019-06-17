/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Gestores.GestorPartido;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet
@MultipartConfig()
public class ServicioEditarPartido extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, InstantiationException, ClassNotFoundException, IllegalAccessException {
        GestorPartido g1 = GestorPartido.obtenerInstancia();
        try {
            String s = request.getParameter("s");
            String nombre = request.getParameter("nombre");
            String observaciones = request.getParameter("observaciones");

            Part part = request.getPart("archivo");

            String campo = part.getName();
            System.out.printf("Nombre del campo (formulario): '%s'%n", campo);

            String nombreArchivo = part.getSubmittedFileName();

            if (nombreArchivo.isEmpty()) {
                request.setAttribute("mensaje",
                        "Se omitió la selección del archivo.");
            }else{
                g1.actualizarB(s, part.getInputStream(), (int) part.getSize(), part.getContentType());
            }
            if (!"".equals(nombre)) {
                g1.actualizarN(nombre,s);
            }
            if (!"".equals(observaciones)) {
                g1.actualizarO(observaciones,s);
            }
        } catch (IOException | ServletException ex) {
            request.setAttribute("mensaje",
                    String.format("Ocurrió una excepción: '%s'", ex.getMessage()));
        }
        response.sendRedirect("admEditarPartido.jsp");
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
            Logger.getLogger(ServicioEditarPartido.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServicioEditarPartido.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ServicioEditarPartido.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ServicioEditarPartido.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServicioEditarPartido.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ServicioEditarPartido.class.getName()).log(Level.SEVERE, null, ex);
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

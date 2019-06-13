/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import javax.servlet.http.Part;
import javax.websocket.Decoder;

@WebServlet
@MultipartConfig()
public class ServicioCreaciondePartido extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            GestorPartido g1 = GestorPartido.obtenerInstancia();
            try {

                String nombre = request.getParameter("nombre");
                String siglas = request.getParameter("siglas");
                String observaciones = request.getParameter("observaciones");

                for (Part part : request.getParts()) {

                    String campo = part.getName();
                    System.out.printf("Nombre del campo (formulario): '%s'%n", campo);

                    String nombreArchivo = part.getSubmittedFileName();

                    if (nombreArchivo.isEmpty()) {
                        request.setAttribute("mensaje",
                                "Se omitió la selección del archivo.");
                        break;
                    }
                    if (GestorPartido.validate(nombreArchivo)) {
                        try {
                            g1.agregar(nombre, siglas, observaciones, part.getInputStream(), (int) part.getSize());
//                        g1.saveImage(nombreArchivo, part.getContentType(),
//                                part.getInputStream(), (int) part.getSize());
                        } catch (Exception ex) {
                            response.sendRedirect("adminGeneral.jsp");
                            request.setAttribute("mensaje",
                                    String.format("Excepción: '%s'", ex.getMessage()));
                        }
                    } else {
                        response.sendRedirect("adminGeneral.jsp");
                        request.setAttribute("mensaje",
                                "El formato del archivo es incorrecto.");
                        break;
                    }
                }
            } catch (IOException | ServletException ex) {
                response.sendRedirect("adminGeneral.jsp");
                request.setAttribute("mensaje",
                        String.format("Ocurrió una excepción: '%s'", ex.getMessage()));
            }

            getServletContext().getRequestDispatcher("admCrearPartido.jsp").forward(request, response);

        } catch (IOException | ServletException ex) {
            response.sendRedirect("adminGeneral.jsp");
            request.setAttribute("mensaje",
                    String.format("Ocurrió una excepción: '%s'", ex.getMessage()));
        } catch (InstantiationException
                | ClassNotFoundException
                | IllegalAccessException ex) {
            response.sendRedirect("adminGeneral.jsp");
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

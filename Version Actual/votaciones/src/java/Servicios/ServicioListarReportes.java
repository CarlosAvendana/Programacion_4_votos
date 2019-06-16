package Servicios;
//  ServicioListarReportes.java
//  EIF209 - Programacion 4 -Proeycto #2
//  Abril 2019
//
//  Autores:
//  Djenane Hernandez Rodriguez
//  Diego Monterrey Benavides
//  Carlos Obando Avendaña

import Gestores.GestorReportes;
import Gestores.GestorUsuario;
import Modelo.Reporte;
import Modelo.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONObject;

public class ServicioListarReportes extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            List<Reporte> _reportes = null;
            try {
                _reportes = GestorReportes.obtenerInstancia().listarTodos();
            } catch (InstantiationException | ClassNotFoundException | IllegalAccessException ex) {
                Logger.getLogger(ServicioListarUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println(_reportes);

            JSONObject _reportesFinal = new JSONObject();
            JSONArray arrayReportes = new JSONArray();

            for (Reporte p : _reportes) {
                JSONObject objReporte = new JSONObject();
                objReporte.put("votacion_id", p.getVotacion_id());
                objReporte.put("partido_siglas", p.getPartido_siglas());
                objReporte.put("cedula_candidato", p.getCedula_candidato());
                objReporte.put("votos_obtenidos", p.getVotos_obtenidos());
                arrayReportes.put(objReporte);
            }
            _reportesFinal.put("reportes", arrayReportes);
            out.print(_reportesFinal);
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

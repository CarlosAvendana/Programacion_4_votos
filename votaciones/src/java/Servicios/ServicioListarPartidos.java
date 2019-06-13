package Servicios;

import Gestores.GestorPartido;
import Modelo.Partido;
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

public class ServicioListarPartidos extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            List<Partido> _partidos = null;
            try {
                _partidos = GestorPartido.obtenerInstancia().listarTodos();
            } catch (InstantiationException | ClassNotFoundException | IllegalAccessException ex) {
                Logger.getLogger(ServicioListarPartidos.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println(_partidos);

            JSONObject _partidosFinal = new JSONObject();
            JSONArray arrayPartidos = new JSONArray();

            for (Partido p : _partidos) {
                JSONObject objPartido = new JSONObject();
                objPartido.put("siglas", p.getSiglas());
                objPartido.put("nombre", p.getNombre());
                objPartido.put("observaciones", p.getObservaciones());

                arrayPartidos.put(objPartido);
            }
            _partidosFinal.put("partidos", arrayPartidos);
            out.print(_partidosFinal);
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

package Servicios;

import Gestores.GestorVotacionPartido;
import Modelo.VotacionPartido;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONObject;

public class ServicioVotacionPartido extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         response.setContentType("application/json;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

               List<VotacionPartido> productos= null;
               try{
                    productos= GestorVotacionPartido.obtenerInstancia().listarTodo();
               }catch (InstantiationException | ClassNotFoundException | IllegalAccessException ex) {
                Logger.getLogger(ServicioListarPartidos.class.getName()).log(Level.SEVERE, null, ex);
            }
               System.out.println(productos);
            JSONObject r = new JSONObject();
            JSONArray a = new JSONArray();
            for (VotacionPartido p : productos) {
                JSONObject g = new JSONObject();
                g.put("Siglas", p.getPartSiglas().getSiglas());
                g.put("Nombre", p.getPartSiglas().getNombre());
                g.put("Candidato", p.getCedCandidato().getNombreCompleto());
                a.put(g);
            }
            r.put("votaciones", a);
            out.print(r);
     
    }}

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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

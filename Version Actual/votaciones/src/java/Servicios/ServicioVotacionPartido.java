package Servicios;

import Gestores.GestorVotacionPartido;
import Modelo.VotacionPartido;
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

public class ServicioVotacionPartido extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            List<VotacionPartido> listVP = null;
            try {
                listVP = GestorVotacionPartido.obtenerInstancia().listarTodo();
            } catch (InstantiationException | ClassNotFoundException | IllegalAccessException ex) {
                Logger.getLogger(ServicioVotacionPartido.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println(listVP);

            JSONObject r = new JSONObject();
            JSONArray a = new JSONArray();
//incluir código para cargar las imagenes, tanto de la bandera como del candidato
            for (VotacionPartido p : listVP) {
                JSONObject pj = new JSONObject();
                pj.put("Partido:", p.getPartSiglas().getNombre());
                pj.put("Siglas: ", p.getPartSiglas().getSiglas());
                pj.put("Candidato", p.getCedCandidato().obtenerNombreCompleto());
                a.put(pj);
            }
            r.put("listVP", a);
            out.print(r);
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

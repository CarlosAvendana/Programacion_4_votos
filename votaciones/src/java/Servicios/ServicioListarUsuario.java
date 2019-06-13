package Servicios;

import Gestores.GestorUsuario;
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

public class ServicioListarUsuario extends HttpServlet {
  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       response.setContentType("application/json;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            List<Usuario> _usuarios = null;
            try {
                _usuarios = GestorUsuario.obtenerInstancia().listarTodos();
            } catch (InstantiationException | ClassNotFoundException | IllegalAccessException ex) {
                Logger.getLogger(ServicioListarUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println(_usuarios);

            JSONObject _usuariosFinal = new JSONObject();
            JSONArray arrayUsuarios = new JSONArray();

            for (Usuario p : _usuarios) {
                JSONObject objUsuario = new JSONObject();
                objUsuario.put("cedula", p.getCedula());
                objUsuario.put("apellido1", p.getApellido1());
                objUsuario.put("apellido2", p.getApellido2());
                objUsuario.put("nombre", p.getNombre());
                arrayUsuarios.put(objUsuario);
            }
            _usuariosFinal.put("usuarios", arrayUsuarios);
            out.print(_usuariosFinal);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if arrayUsuarios servlet-specific error occurs
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
     * @throws ServletException if arrayUsuarios servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns arrayUsuarios short description of the servlet.
     *
     * @return arrayUsuarios String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

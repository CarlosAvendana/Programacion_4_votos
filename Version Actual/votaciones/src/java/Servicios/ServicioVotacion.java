package Servicios;

import Gestores.GestorVotacion;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ServicioVotacion extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws InstantiationException, ClassNotFoundException, IllegalAccessException, IOException {

        GestorVotacion GVotacion = GestorVotacion.obtenerInstancia();
        HttpSession sesion = request.getSession(true);

        String dateI = request.getParameter("FInicio");
        String dateA = request.getParameter("FApertura");
        String dateF = request.getParameter("FFinal");
        String dateC = request.getParameter("FCierre");

        try {
            GVotacion.agregar(dateI, dateA, dateF, dateC, 0);
        } catch (Exception ex) {
            Logger.getLogger(ServicioVotacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.sendRedirect("adminGestionVotacion.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (InstantiationException | ClassNotFoundException | IllegalAccessException ex) {
            Logger.getLogger(ServicioVotacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (InstantiationException | ClassNotFoundException | IllegalAccessException ex) {
            Logger.getLogger(ServicioVotacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}

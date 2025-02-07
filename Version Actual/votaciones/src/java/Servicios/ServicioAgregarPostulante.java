package Servicios;

import Gestores.GestorPartido;
import Gestores.GestorUsuario;
import Gestores.GestorVotacion;
import Gestores.GestorVotacionPartido;
import java.io.IOException;
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

@WebServlet
@MultipartConfig()
public class ServicioAgregarPostulante extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, InstantiationException, ClassNotFoundException, IllegalAccessException {
        GestorVotacionPartido gP = GestorVotacionPartido.obtenerInstancia();
        GestorVotacion gV = GestorVotacion.obtenerInstancia();
        GestorUsuario gU = GestorUsuario.obtenerInstancia();
        GestorPartido gPa = GestorPartido.obtenerInstancia();
        HttpSession sesion = request.getSession(true);
        try {
            String id = request.getParameter("campo2");
            String cedula = request.getParameter("campo1");
            String siglas = request.getParameter("campo3");
            int idI = Integer.parseInt(id);
            int votosObt = 0;
            Part part = request.getPart("fotoUsuario");

            String campo = part.getName();
            System.out.printf("Nombre del campo (formulario): '%s'%n", campo);

            String nombreArchivo = part.getSubmittedFileName();

            if (nombreArchivo.isEmpty()) {
                request.setAttribute("mensaje",
                        "Se omitió la selección del archivo.");
            }
            if (!(gV.verificarVotacion(idI))) {//verificar fecha
                response.sendRedirect("adminAsignaUsuarioAPartido.jsp?mensaje=1");
            } else if (!(gU.verificarUsuario1(cedula))) {//verificar usuario
                response.sendRedirect("adminAsignaUsuarioAPartido.jsp?mensaje=2");
            } else if (!(gPa.verificarPartido1(siglas))) {//verificar partido
                response.sendRedirect("adminAsignaUsuarioAPartido.jsp?mensaje=3");
            } else {
                if (GestorVotacionPartido.validate(nombreArchivo)) {
                    try {
                        gP.agregar(idI, cedula, siglas, part.getInputStream(), (int) part.getSize(), part.getContentType(), votosObt);
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
                response.sendRedirect("adminAsignaUsuarioAPartido.jsp?mensaje=0");
            }
        } catch (IOException | ServletException ex) {
            response.sendRedirect("adminGeneral.jsp");
            request.setAttribute("mensaje",
                    String.format("Ocurrió una excepción: '%s'", ex.getMessage()));
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
        try {
            processRequest(request, response);
        } catch (InstantiationException ex) {
            Logger.getLogger(ServicioAgregarPostulante.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServicioAgregarPostulante.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ServicioAgregarPostulante.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ServicioAgregarPostulante.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServicioAgregarPostulante.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ServicioAgregarPostulante.class.getName()).log(Level.SEVERE, null, ex);
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

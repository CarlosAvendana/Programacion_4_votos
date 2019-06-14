package servicios;

import ejemplo.entidades.ListaUsuarios;
import ejemplo.entidades.dao.IGestorUsuarios;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.xml.bind.JAXBException;

@WebServlet
@MultipartConfig
public class ServicioCarga extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String msj = "ok";
            for (Part parte : request.getParts()) {
                String fn = parte.getSubmittedFileName();
                if ((fn != null) && (!fn.isEmpty())) {
                    System.out.printf("Archivo enviado: '%s'%n", fn);

                    try {
                        ListaUsuarios usuarios = ListaUsuarios.deserializar(parte.getInputStream());
                        System.out.println(usuarios);
                        IGestorUsuarios g = AdministradorGestor.obtenerInstancia().obtenerGestor();
                        g.agregar(usuarios);

                    } catch (IOException | JAXBException ex) {
                        System.out.printf("Excepción: '%s'%n", ex.getMessage());
                    }
                }
            }
            out.printf("{\"mensaje\": \"%s\"}", msj);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods.">
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    // </editor-fold>

}

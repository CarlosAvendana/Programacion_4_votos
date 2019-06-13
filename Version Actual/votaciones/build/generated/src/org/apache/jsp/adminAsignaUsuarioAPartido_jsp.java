package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class adminAsignaUsuarioAPartido_jsp extends org.apache.jasper.runtime.HttpJspBase
        implements org.apache.jasper.runtime.JspSourceDependent {

    private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

    private static java.util.List<String> _jspx_dependants;

    private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

    public java.util.List<String> getDependants() {
        return _jspx_dependants;
    }

    public void _jspService(HttpServletRequest request, HttpServletResponse response)
            throws java.io.IOException, ServletException {

        PageContext pageContext = null;
        HttpSession session = null;
        ServletContext application = null;
        ServletConfig config = null;
        JspWriter out = null;
        Object page = this;
        JspWriter _jspx_out = null;
        PageContext _jspx_page_context = null;

        try {
            response.setContentType("text/html;charset=UTF-8");
            pageContext = _jspxFactory.getPageContext(this, request, response,
                    null, true, 8192, true);
            _jspx_page_context = pageContext;
            application = pageContext.getServletContext();
            config = pageContext.getServletConfig();
            session = pageContext.getSession();
            out = pageContext.getOut();
            _jspx_out = out;
            _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

            out.write("\n");
            out.write("\n");
            out.write("\n");
            out.write("<!DOCTYPE html>\n");
            out.write("<html>\n");
            out.write("    <head>\n");
            out.write("        <link href=\"css/Color.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
            out.write("        <link rel=\"shortcut icon\" href=\"politics.ico\" type=\"image/x-icon\" />\n");
            out.write("        <script src=\"scripts/script.js\" type=\"text/javascript\"></script>\n");
            out.write("        <title>Asigna Usuario a Partido</title>\n");
            out.write("    </head>\n");
            out.write("    <body  onload=\"asignaUsuariosAPartido();\">\n");
            out.write("        <div id=\"wrapper\">\n");
            out.write("            <div id=\"contents\">\n");
            out.write("                <section id=\"botones\">\n");
            out.write("                    <table id=\"tablaButton\">\n");
            out.write("                        <thead>\n");
            out.write("                            <tr>\n");
            out.write("                                <td>\n");
            out.write("                                    <button class=\"bnt\"  role=\"link\" onclick=\"window.location = 'adminGeneral.jsp'\">Principal</button>   \n");
            out.write("                                </td>\n");
            out.write("                                <td>\n");
            out.write("                                    <button class=\"bnt\"  role=\"link\" onclick=\"window.location = 'adminGestionVotacion.jsp'\">Gestionar Dias Votacion</button>   \n");
            out.write("                                </td>\n");
            out.write("\n");
            out.write("                                <td>\n");
            out.write("                                    <button class=\"bnt\"  role=\"link\" onclick=\"window.location = 'adminReporte.jsp'\">Reportes</button>   \n");
            out.write("                                </td>\n");
            out.write("                                <td>\n");
            out.write("                                    <button class='bnt' role=\"link\" onclick=\"window.location = 'admCrearPartido.jsp'\">Crear Partido</button>\n");
            out.write("                                </td>\n");
            out.write("                                <td>\n");
            out.write("                                    <form name='formxml' action=\"servicioXML\" method='POST'>\n");
            out.write("                                        <input class='bnt' type=\"submit\" value='Cargar Usuarios' name='Cargar Usuarios'/>\n");
            out.write("                                    </form>  \n");
            out.write("                                </td>\n");
            out.write("                                <td>\n");
            out.write("                                    <form name='formOut' action=\"ServicioLogout\" method='POST'>\n");
            out.write("                                        <input class='btn' type=\"submit\" value='LogOut' name='cerrar' />\n");
            out.write("                                    </form>\n");
            out.write("                                </td>\n");
            out.write("                            </tr>\n");
            out.write("                        </thead>\n");
            out.write("                    </table>\n");
            out.write("                </section>\n");
            out.write("                <section id=\"secAF\">\n");
            out.write("                    <form id=\"formP\">\n");
            out.write("                        <table class=\"tablaDatos\">\n");
            out.write("                            <caption>\n");
            out.write("                                <strong>\n");
            out.write("                                    Asignar un Usuario Al Partido\n");
            out.write("                                </strong>\n");
            out.write("                            </caption>\n");
            out.write("                            <tbody id=\"cuerpoForm\">\n");
            out.write("                                <tr>\n");
            out.write("                                    <td>\n");
            out.write("                                        <strong>\n");
            out.write("                                            Cedula del usuario\n");
            out.write("                                        </strong>\n");
            out.write("                                        :&nbsp;             \n");
            out.write("                                        <input type=\"text\" id=\"campo1\" name=\"campo1\" \n");
            out.write("                                               size=\"15\" autocomplete=\"off\"/>\n");
            out.write("                                    </td>\n");
            out.write("                                </tr>\n");
            out.write("\n");
            out.write("                                <tr>\n");
            out.write("                                    <td>\n");
            out.write("                                        <strong>\n");
            out.write("                                            Siglas del Partido\n");
            out.write("                                        </strong>\n");
            out.write("                                        :&nbsp;\n");
            out.write("                                        <input type=\"text\" id=\"campo3\" name=\"campo3\" \n");
            out.write("                                               size=\"15\" autocomplete=\"off\"/>\n");
            out.write("                                    </td>\n");
            out.write("                                </tr>\n");
            out.write("\n");
            out.write("                                <tr>\n");
            out.write("                                    <td>\n");
            out.write("                                        <strong>\n");
            out.write("                                            Foto del Usuario\n");
            out.write("                                        </strong>\n");
            out.write("                                        :&nbsp;                                \n");
            out.write("                                        <input type=\"file\" id=\"fotoUsuario\" name=\"fotoUsuario\" />\n");
            out.write("                                    </td>\n");
            out.write("                                </tr>\n");
            out.write("\n");
            out.write("                                <tr>\n");
            out.write("                                    <td>\n");
            out.write("                                        <button type=\"button\">\n");
            out.write("                                            Agregar\n");
            out.write("                                        </button>\n");
            out.write("                                    </td>\n");
            out.write("                                </tr>\n");
            out.write("\n");
            out.write("                            </tbody>\n");
            out.write("                        </table>\n");
            out.write("                    </form>\n");
            out.write("                </section>\n");
            out.write("                <section id=\"secTU\">                    \n");
            out.write("                    <table id=\"tablaUsuarios\" class=\"tablaDatos\">\n");
            out.write("                        <thead>\n");
            out.write("                        <caption style='color: white; background-color: lightseagreen;'>\n");
            out.write("                            Tabla de usuarios\n");
            out.write("                        </caption>\n");
            out.write("                        <tr>\n");
            out.write("                            <th>Cedula</th>\n");
            out.write("                            <th>Apellido 1</th>\n");
            out.write("                            <th>Apellido 2</th>\n");
            out.write("                            <th>Nombre</th>\n");
            out.write("                        </tr>\n");
            out.write("                        </thead>\n");
            out.write("\n");
            out.write("                    </table>              \n");
            out.write("                </section>\n");
            out.write("                <section id=\"secTP\">                    \n");
            out.write("                    <table id=\"tablaPartidos\" class=\"tablaDatos\">\n");
            out.write("                    </table>              \n");
            out.write("                </section>\n");
            out.write("            </div>\n");
            out.write("        </div>\n");
            out.write("    </body>\n");
            out.write("</html>\n");
        } catch (Throwable t) {
            if (!(t instanceof SkipPageException)) {
                out = _jspx_out;
                if (out != null && out.getBufferSize() != 0) {
                    out.clearBuffer();
                }
                if (_jspx_page_context != null) {
                    _jspx_page_context.handlePageException(t);
                } else {
                    throw new ServletException(t);
                }
            }
        } finally {
            _jspxFactory.releasePageContext(_jspx_page_context);
        }
    }
}

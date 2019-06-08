<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.entidades.dao.GestorEstudiante" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <link rel="shortcut icon" href="flecha.ico" type="image/x-icon" />
        <link href="css/colors.css" rel="stylesheet" type="text/css"/>
        <link href="css/default.css" rel="stylesheet" type="text/css"/>
        <title>Datos Personales</title>
    </head>
    <body>
        <div>
            <%@include file="header.jsp" %>
            <section>
                <table id="tablaButton">
                    <thead>
                        <tr>
                            <td>
                                <form name="logout" action="ServicioLogout"
                                      method="POST">
                                    <button type="submit">Salir </button>
                                </form>
                            </td>
                            <td>
                                <button  disable="true">Datos Personales </button> 
                            </td>
                            <td>
                            <th><input type="button" onclick=" location.href = 'matricula.jsp'" value="Matricular" name="boton" /></th>
                            </td>
                        </tr>
                    </thead>
                </table>
            </section>
            <div id="contents">
                <h1>Datos Personales</h1>
                <section>
                    <table id="tabla3" class="tablaDatos">
                        <%=GestorEstudiante.obtenerInstancia().obtenerDatosHTML(request.getSession(true).getAttribute("usuario"))%>
                    </table>
                </section>
            </div>
            <%@include file="footer.jsp" %>
        </div>
    </body>
</html>

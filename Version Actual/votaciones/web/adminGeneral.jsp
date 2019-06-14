
<%-- 
//  adminGeneral.jsp
//  EIF209 - Programacion 4 -Proeycto #2
//  Abril 2019
//
//  Autores:
//  Djenane Hernandez Rodriguez
//  Diego Monterrey Benavides
//  Carlos Obando Avendaña
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Gestores.GAdmi2" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <link href="css/Color.css" rel="stylesheet" type="text/css"/>
        <link rel="shortcut icon" href="politics.ico" type="image/x-icon" />
        <title>General Administrator</title>
    </head>
    <body>
        <div id="wrapper">
            <div id="contents">
                <section id="botones">
                    <table id="tablaButton">
                        <thead>
                            <tr>
                                <td>
                                    <button class="bnt"  role="link" onclick="window.location = 'adminGestionVotacion.jsp'">Gestionar Dias Votacion</button>   
                                </td>
                                <td>
                                    <button class="bnt"  role="link" onclick="window.location = 'adminAsignaUsuarioAPartido.jsp'">Crear Postulante</button>   
                                </td>
                                <td>
                                    <button class="bnt"  role="link" onclick="window.location = 'adminReporte.jsp'">Reportes</button>   
                                </td>
                                <td>
                                    <button class='bnt' role="link" onclick="window.location = 'admCrearPartido.jsp'">Crear Partido</button>
                                </td>
                                <td>
                                <td >
                                    <form name='formOut' action="ServicioLogout" method='POST'>
                                        <input  class='bnt' type="submit" value='LogOut' name='cerrar'/>
                                    </form>
                                </td>
                                </td>

                            </tr>
                        </thead>
                    </table>
                </section>
                <section>
                    <table id="tabla3" class="tablaDatos">
                        <%=GAdmi2.obtenerInstancia().obtenerDatosHTML(request.getSession(true).getAttribute("usuario"))%>
                    </table>
                </section>
            </div>
        </div>
    </body>
</html>



<%@page import="Modelo.Validacion"%>
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
                    <table id="tablaButton" style="margin: 0 auto; padding: 15px;">
                        <thead>
                            <tr>
                                <td>
                                    <button class="bnt"  role="link" onclick="window.location = 'admEditarAsignacionUsuario.jsp'">Editar Usuario Partido</button>   
                                </td>
                                <td>
                                    <button class="bnt"  role="link" onclick="window.location = 'admActivarFechaVotacion.jsp'">Activar Fecha</button>   
                                </td>
                                <td>
                                    <button class="bnt"  role="link" onclick="window.location = 'admEditarPartido.jsp'">Editar Partido</button>   
                                </td>
                                <td>
                                    <button class="bnt"  role="link" onclick="window.location = 'adminGeneral.jsp'">Principal</button>   
                                </td>
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
                                    <button class='bnt' role="link" onclick="window.location = 'XMLDatos.jsp'">Cargar Usuarios XML</button>
                                </td>
                                <td >
                                    <form name='formOut' action="ServicioLogout" method='POST'>
                                        <input  class='bnt' type="submit" value='LogOut' name='cerrar'/>
                                    </form>
                                </td>
                            </tr>
                        </thead>
                    </table>
                </section>
                <section>
                    <table id="tabla3" class="tablaDatos" style="margin: 0 auto; padding: 75px;">
                        <thead>
                            <tr>
                                <td align='center' style='color: white; background-color: lightseagreen;' colspan="2" >
                                    <strong>Usuario</strong>
                                </td>
                            </tr>
                        </thead>
                        <%=GAdmi2.obtenerInstancia().obtenerDatosHTML(request.getSession(true).getAttribute("usuario"))%>
                    </table>
                </section>
            </div>
        </div>
    </body>
</html>


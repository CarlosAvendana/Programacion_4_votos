<%-- 
//  adminGestionVotacion.jsp
//  EIF209 - Programacion 4 -Proeycto #2
//  Abril 2019
//
//  Autores:
//  Djenane Hernandez Rodriguez
//  Diego Monterrey Benavides
//  Carlos Obando Avendaña
--%>

<%@page import="Modelo.Validacion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <link href="css/Color.css" rel="stylesheet" type="text/css"/>
        <link rel="shortcut icon" href="politics.ico" type="image/x-icon" />
        <title>Cargar Usuarios</title>
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
                <section id="secGestionVotacion">
                    <form id="formNuevaVotacion" action="ServicioVotacion" method="POST">
                        <table  class="tablaDatos" style="margin: 0 auto; padding: 15px;">
                            <thead>
                                <tr>
                                    <td align='center' style='color: white; background-color: lightseagreen;' colspan="2" >
                                        <strong>Crear Nueva Votacion</strong>
                                    </td>
                                </tr>
                            </thead>
                            <tbody id="cuerpoForm">
                                <tr>
                                    <td>
                                        <strong>
                                            Fecha de Inicio
                                        </strong>
                                    </td>
                                    <td>
                                        <input id='FechaInicio' type='date' name="FInicio"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <strong>
                                            Fecha de apertura
                                        </strong>
                                    </td>
                                    <td>         
                                        <input id='FechaApertura' type='date' name="FApertura"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <strong>
                                            Fecha de Cierre
                                        </strong>
                                    </td>
                                    <td>         
                                        <input id='FechaFinal' type='date' name="FFinal"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <strong>
                                            Fecha Final
                                        </strong>
                                    </td>
                                    <td>         
                                        <input id='FechaCierre' type='date' name="FCierre"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td colspan="2"  align='center'>
                                        <input class='bnt' type="submit" value='Crear' name='Crear'/>
                                </tr>
                            </tbody>
                        </table>
                    </form>
                </section>
                <section  >

                    <p>
                        <%String codigo = request.getParameter("mensaje");
                            if (codigo != null) {
                                if (codigo.equals("1")) {
                                    out.println("<p align='center' style='color : red; margin: 0 auto; padding: 15 px;'>Se registraron las fechas de votacion </p>");
                                }
                                if (codigo.equals("0")) {
                                    out.println("<p align='center' style='color : green; margin: 0 auto; padding: 15 px;'>No se agregaron las fechas de votacion!</p>");
                                }
                            }
                        %>
                    </p>

                </section>
            </div>
        </div>
    </body>
</html>

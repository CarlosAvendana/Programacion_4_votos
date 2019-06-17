<%@page import="Modelo.Validacion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>XML</title>
        <meta charset="UTF-8" />
        <link href="css/Color.css" rel="stylesheet" type="text/css"/>
        <script src="scripts/script.js" type="text/javascript"></script>
    </head>
    <body onload="init0();">
        <div id="wrapper">
            <header></header>
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
                    <table class="tablaUsuarios">
                        <caption>Listado de usuarios</caption>
                        <thead>
                            <tr>
                                <th>Cédula</th>
                                <th colspan="2">Apellidos</th>
                                <th>Nombre</th>
                                <th>Clave</th>
                                <th>Activo</th>
                            </tr>
                        </thead>
                        <tbody id="datosUsuarios">
                        </tbody>
                    </table>
                </section>
                <section>
                    <input type="file" id="archivo" name="ar"/>
                    <button onclick="cargarArchivo();">Cargar usuarios</button>
                </section>
            </div>
            <footer></footer>
        </div>
    </body>
</html>
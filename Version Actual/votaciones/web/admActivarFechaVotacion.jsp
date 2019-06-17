<%@page import="Modelo.Validacion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/Color.css" rel="stylesheet" type="text/css"/>
        <script src="scripts/script.js" type="text/javascript"></script>
        <title>JSP Page</title>
    </head>
    <body onload="init1();">
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
                    <form id="activarFecha" action="ServicioTablaVotacion2" method="POST">
                        <table id="tablaFechas" class="tablaDatos" style="margin: 0 auto; padding: 15px;">
                            <thead>
                                <tr>
                                    <td align='center' style='color: white; background-color: lightseagreen;' colspan="4" >
                                        <strong>
                                            Tabla de Fechas  
                                        </strong>    
                                    </td>
                                </tr>
                                <tr>
                                    <th>id</th>
                                    <th>Fecha Inicial</th>
                                    <th>Fecha Final</th>
                                    <th>Activo</th>
                                </tr>
                            </thead>
                        </table>
                    </form>
                </section>
                <section>
                    <form id="activarFecha" action="ServicioTablaVotacion3" method="POST">
                        <table id="tablaFormulario" class="tablaDatos" style="margin: 0 auto; padding: 45px;">
                            <thead>
                                <tr>
                                    <td align='center' style='color: white; background-color: lightseagreen;' colspan="2" >
                                        <strong>Crear Partido</strong>
                                    </td>
                                </tr>
                            </thead>                   
                            <tbody id="cuerpoForm">
                                <tr>
                                    <td>
                                        <strong>
                                            Id para eliminar el activo
                                        </strong>
                                        :&nbsp;
                                    </td>
                                    <td >
                                        <input type="text" id="campo1" name="actA" 
                                               size="30" autocomplete="off"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <strong>
                                            Activa una fecha nueva de votacion
                                        </strong>
                                        :&nbsp;
                                    </td>
                                    <td >
                                        <input type="text" id="campo1" name="vot" 
                                               size="30" autocomplete="off"/>
                                    </td>
                                </tr>
                                <tr>                               
                                    <td  colspan="2" align='center'>
                                        <input class='bnt' type="submit" value='Actualizar' name='Crear'/>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </form>
                </section>
            </div>
        </div>
    </body>
</html>

<%-- 
//  adminReporte.jsp
//  EIF209 - Programacion 4 -Proeycto #2
//  Abril 2019
//
//  Autores:
//  Djenane Hernandez Rodriguez
//  Diego Monterrey Benavides
//  Carlos Obando Avendaña
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <link href="css/Color.css" rel="stylesheet" type="text/css"/>
        <link rel="shortcut icon" href="politics.ico" type="image/x-icon" />
        <script src="scripts/script.js" type="text/javascript"></script>
        <title>Reportes</title>
    </head>
    <body onload='initReporte();'>
        <div id="wrapper">
            <div id="contents">
                <section id="botones">
                    <table id="tablaButton" style="margin: 0 auto; padding: 15px;">
                        <thead>
                            <tr>
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
                    <form>
                        <table class="tablaDatos" style="margin: 0 auto; padding: 15px;">
                            <thead>
                                <tr>
                                    <td align='center' style='color: white; background-color: lightseagreen;' colspan="2">
                                        Consulta
                                    </td>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>
                                        <strong>
                                            Digite el Id de la votacion
                                        </strong>
                                        :&nbsp;
                                    </td>
                                    <td >
                                        <input type="text" id="idvotacion" name="id" 
                                               size="15" autocomplete="off"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td colspan="2" align='center'>
                                        <input class='bnt' type="submit" value='RealizarConsulta' name='RealizarConsulta'/>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </form>
                </section>

                <section>
                    <table id="votoEfectuadoTabla" class="tablaDatos" style="margin: 0 auto; padding: 15px;">
                        <thead>
                            <tr>
                                <td align='center' style='color: white; background-color: lightseagreen;' colspan="4" >
                                    <strong>Voto Efectivo</strong>
                                </td>
                            </tr>
                            <tr>
                                <th>Numero Votos</th>
                                <th>Porcentaje</th>
                            </tr>
                        </thead>
                    </table>
                </section>
                <section>
                    <table id="votoNOEfectuados" class="tablaDatos" style="margin: 0 auto; padding: 15px;">
                        <thead>
                            <tr>
                                <td align='center' style='color: white; background-color: lightseagreen;' colspan="4" >
                                    <strong>Voto NO Efectivo</strong>
                                </td>
                            </tr>
                            <tr>
                                <th>Numero Votos</th>
                                <th>Porcentaje</th>
                            </tr>
                        </thead>
                    </table>
                </section>
                <section>
                    <table id="TC" class="tablaDatos" style="margin: 0 auto; padding: 15px;">
                        <thead>
                            <tr>
                                <td " align='center' style='color: white; background-color: lightseagreen;' colspan="4" >
                                    <strong>Votos</strong>
                                </td>
                            </tr>
                            <tr>
                                <th>Numero Votos</th>
                                <th>Porcentaje</th>
                                <th>Nombre Partido</th>
                                <th>Candidato</th>
                            </tr>
                        </thead>
                    </table>
                </section>



                <section>
                    <table id="TablaReportes" class="tablaDatos" style="margin: 0 auto; padding: 15px;">
                        <thead>                       
                            <tr>
                                <td align='center' style='color: white; background-color: lightseagreen;' colspan="4" >
                                    <strong>Tabla de Reportes</strong>
                                </td>
                            </tr>
                            <tr>
                                <th>voto Id</th>
                                <th>Siglas</th>
                                <th>cedula Candidato</th>.
                                <th>votos Obtenidos</th>
                            </tr>
                        </thead>
                    </table>   
                </section>


                <%-- 
                
                    <section>
                    <table id='tablaBotantesRegistrados'class="tablaDatos" style="margin: 0 auto; padding: 15px;">
                        <thead>
                            <tr>
                                <td align='center' style='color: white; background-color: lightseagreen;' colspan="4" >
                                    <strong>Votantes Registrados</strong>
                                </td>
                            </tr>
                            <tr>
                                <th>
                                    Numero 
                                </th>
                            </tr>
                        </thead>
                    </table>
                </section>
   <section>
                    <table class="tablaDatos" style="margin: 0 auto; padding: 15px;">
                        <thead>
                            <tr>
                                <td align='center' style='color: white; background-color: lightseagreen;' colspan="1" >
                                    <strong>Ganador</strong>
                                </td>
                            </tr>
                            <tr>
                                <th>Nombre</th>

                            </tr>
                        </thead>
                    </table>
                </section>
                --%>

            </div>
        </div>
    </body>
</html>

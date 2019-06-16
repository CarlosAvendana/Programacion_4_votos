<%-- 
//  crearPartido.jsp
//  EIF209 - Programacion 4 -Proeycto #2
//  Junio 2019
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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/Color.css" rel="stylesheet" type="text/css"/>
        <link rel="shortcut icon" href="politics.ico" type="image/x-icon" />
        <script src="scripts/script.js" type="text/javascript"></script>
        <title>Creando partido político</title>
    </head>
    <body onload="init5()">
        <%
            Validacion.validacion(request, response);
        %>
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
                <section id="crearP">
                    <form id="formP"action="ServicioEditarPartido" method="POST" enctype="multipart/form-data">
                        <table id="tablaFormulario" class="tablaDatos" style="margin: 0 auto; padding: 45px;">
                            <thead>
                                <tr>
                                    <td align='center' style='color: white; background-color: lightseagreen;' colspan="2" >
                                        <strong>Editar Partido</strong>
                                    </td>
                                </tr>
                            </thead>                   
                            <tbody id="cuerpoForm">
                                <tr>
                                    <td>
                                        <strong>
                                            Siglas del Partido a Editar
                                        </strong>
                                        :&nbsp;
                                    </td>
                                    <td >
                                        <input type="text" id="campo1" name="s" 
                                               size="30" autocomplete="off"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <strong>
                                            Nuevo nombre del Partido
                                        </strong>
                                        :&nbsp;
                                    </td>
                                    <td >
                                        <input type="text" id="campo1" name="nombre" 
                                               size="30" autocomplete="off"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <strong>
                                            Observaciones
                                        </strong>
                                        :&nbsp;
                                    </td>
                                    <td>
                                        <textarea type="text"  name="observaciones"  style="resize: none; width: 90%; height: 60px;" rows="5" cols="40"></textarea>
                                    </td>
                                </tr>
                                <tr>
                                    <td >
                                        <strong>
                                            Bandera
                                        </strong>
                                        :&nbsp;
                                    </td>
                                    <td >
                                        <input type="file" id="archivo" name="archivo"/>
                                    </td>
                                </tr>
                                <tr>                               
                                    <td  colspan="2" align='center'>
                                        <input class='bnt' type="submit" value='Crear' name='Crear'/>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </form>
                </section>
                <section id="secTP">                    
                    <table id="tablaPartidos" class="tablaDatos">
                        <thead>                       
                            <tr>
                                <td align='center' style='color: white; background-color: lightseagreen;' colspan="4" >
                                    Tabla Partidos      
                                </td>
                            </tr>
                            <tr>
                                <th>Siglas</th>
                                <th>Nombre</th>
                                <th>Comentarios</th>
                            </tr>
                        </thead>
                    </table>              
                </section>
                <section style="margin: 0 auto;">
                    <%String codigo = request.getParameter("mensaje");
                                if (codigo != null) {
                                    if (codigo.equals("1")) {
                                        out.println("<p style='color : red;'>no se pudo editar </p>");
                                    }
                                    if (codigo.equals("0")) {
                                        out.println("<p style='color : green;'>Se edito con exito</p>");
                                    }
                                }
                            %>
                </section>
            </div>
        </div>
    </body>
</html>

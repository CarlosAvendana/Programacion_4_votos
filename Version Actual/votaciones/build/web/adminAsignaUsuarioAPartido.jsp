<%-- 
   //  adminAsignaUsuarioAPartido.jsp
//  EIF209 - Programacion 4 -Proeycto #2
//  Abril 2019
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
        <link href="css/Color.css" rel="stylesheet" type="text/css"/>
        <link rel="shortcut icon" href="politics.ico" type="image/x-icon" />
        <script src="scripts/script.js" type="text/javascript"></script>
        <title>Asigna Usuario a Partido</title>
    </head>
    <body  onload="asignaUsuariosAPartido();">
       
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
                <section id="secAF">
                    <form id="formP"action="ServicioAgregarPostulante" method="POST" enctype="multipart/form-data" >
                        <table class="tablaDatos" style="margin: 0 auto; padding: 15px;">
                            <thead>
                                <tr>
                                    <td align='center' style='color: white; background-color: lightseagreen;' colspan="2" >
                                        Asignar un Usuario Al Partido
                                    </td>
                                </tr>
                            </thead>
                            <tbody id="cuerpoForm">
                                <tr>
                                    <td>
                                        <strong>
                                            ID de Fecha
                                        </strong>
                                        :&nbsp;             
                                        <input type="text" id="campo2" name="campo2" 
                                               size="5" autocomplete="off"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <strong>
                                            Cedula del usuario
                                        </strong>
                                        :&nbsp;             
                                        <input type="text" id="campo1" name="campo1" 
                                               size="15" autocomplete="off"/>
                                    </td>
                                </tr>

                                <tr>
                                    <td>
                                        <strong>
                                            Siglas del Partido
                                        </strong>
                                        :&nbsp;
                                        <input type="text" id="campo3" name="campo3" 
                                               size="15" autocomplete="off"/>
                                    </td>
                                </tr>

                                <tr>
                                    <td>
                                        <strong>
                                            Foto del Usuario
                                        </strong>
                                        :&nbsp;                                
                                        <input type="file" id="fotoUsuario" name="fotoUsuario" />
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
                <section id="secTF"  align='center'style="margin: 0 auto; padding: 15px;">                    
                    <table id="tablaFechas" class="tablaDatos"style='margin: 0 auto; padding: 15px;' >
                        <thead>                       
                            <tr>
                                <td  align='center' style='color: white; background-color: lightseagreen;' colspan="4" >
                                    Tabla Fechas      
                                </td>
                            </tr>
                            <tr>
                                <th>Id</th>
                                <th>Fecha Inicial</th>
                                <th>Fecha Final</th>
                            </tr>
                        </thead>
                    </table>              
                </section>
                <section id="secTU">                    
                    <table id="tablaUsuarios" class="tablaDatos" style='margin: 0 auto; padding: 15px;'>
                        <thead>   
                            <tr>
                                <td align='center' style='color: white; background-color: lightseagreen;' colspan="4" >
                                    <strong>
                                        Tabla de usuarios  
                                    </strong>    
                                </td>
                            </tr>
                            <tr>
                                <th>Cedula</th>
                                <th>Apellido 1</th>
                                <th>Apellido 2</th>
                                <th>Nombre</th>
                            </tr>
                        </thead>
                    </table> 
                </section>
                <section id="secTP">                    
                    <table id="tablaPartidos" class="tablaDatos" style="margin: 0 auto; padding: 15px;">
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
                <%String codigo = request.getParameter("mensaje");
                    if (codigo != null) {
                        if (codigo.equals("1")) {
                            out.println("<p style='color : red;'>Votacion </p>");
                        }
                        if (codigo.equals("0")) {
                            out.println("<p style='color : green;'>Se agrego con exito</p>");
                        }
                    }
                %>
            </div>
        </div>
    </body>
</html>

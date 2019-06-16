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

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/Color.css" rel="stylesheet" type="text/css"/>
        <link rel="shortcut icon" href="politics.ico" type="image/x-icon" />
        <title>Creando partido político</title>
    </head>
    <body>
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
                    <form id="formP"action="ServicioCreaciondePartido" method="POST" enctype="multipart/form-data">
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
                                            Nombre del Partido
                                        </strong>
                                        :&nbsp;
                                    </td>
                                    <td >
                                        <input type="text" id="campo1" name="nombre" 
                                               size="30" autocomplete="off"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td >
                                        <strong>
                                            Siglas del Partido
                                        </strong>
                                        :&nbsp;
                                    </td>
                                    <td >
                                        <input type="text" id="campo1" name="siglas" 
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
                                        <input type="file" id="archivo" name="archivo" />
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
            </div>
        </div>
    </body>
</html>

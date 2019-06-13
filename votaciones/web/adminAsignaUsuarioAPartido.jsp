<%-- 
   //  adminAsignaUsuarioAPartido.jsp
//  EIF209 - Programacion 4 -Proeycto #2
//  Abril 2019
//  Autores:
//  Djenane Hernandez Rodriguez
//  Diego Monterrey Benavides
//  Carlos Obando Avendaña
--%>

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
                    <table id="tablaButton">
                        <thead>
                            <tr>
                                <td>
                                    <button class="bnt">Generar Reportes</button>   
                                </td>
                                <td>
                                    <button class="bnt">Cargar Usuario</button>   
                                </td>
                                <td>
                                    <button class="bnt">Gestionar Dias Votacion</button>   
                                </td>
                                <td>
                                    <form name='formOut' action='ServicioLogout'method='POST'>
                                        <input class='btn' type='submit' value='LogOut' name='cerrar' >
                                    </form>
                                </td>
                            </tr>
                        </thead>
                    </table>
                </section>
                <section id="secTablaAgregarFuncionario">
                    <form id="formP">
                        <table class="tablaDatos">
                            <caption>
                                <strong>
                                    Asignar un Usuario Al Partido
                                </strong>
                            </caption>
                            <tbody id="cuerpoForm">
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
                                    <td>
                                        <button type="button">
                                            Agregar
                                        </button>
                                        </td>
                                </tr>
                                
                            </tbody>
                        </table>
                    </form>
                </section>
                <section>                    
                    <table id="tablaUsuarios" class="tablaDatos">
                        <thead>
                        <caption style='color: white; background-color: lightseagreen;'>
                            Tabla de usuarios
                        </caption>
                        <tr>
                            <th>Cedula</th>
                            <th>Apellido 1</th>
                            <th>Apellido 2</th>
                            <th>Nombre</th>
                        </tr>
                        </thead>

                    </table>              
                </section>

                <section>                    
                    <table id="tablaPartidos" class="tablaDatos">

                    </table>              
                </section>
            </div>
        </div>
    </body>
</html>

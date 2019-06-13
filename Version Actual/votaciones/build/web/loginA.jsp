<%-- 
//  index.jsp
//  EIF209 - Programacion 4 -Proeycto #2
//  Abril 2019
//
//  Autores:
//  Djenane Hernandez Rodriguez
//  Diego Monterrey Benavides
//Carlos Obando Avendaña
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <link href="css/Color.css" rel="stylesheet" type="text/css"/>
        <link rel="shortcut icon" href="politics.ico" type="image/x-icon" />
        <title>Login</title>
    </head>
    <body>
        <div id="wrapper">

            <section class ="container">
                <section class="comentario"> 
                    <h1> Bienvenido al Sistema de votacion</h1>
                    <p>Sistema en el cual usted va a poder hacer votaciones si es un usuario del sistema y realizar reporte si es un investigador</p>
                    <p>EIF209  Programación 4  Proyecto #2</p>
                    <p>1er ciclo 2019</p>
                    <p>Estudiantes: <br>
                        Djenane Hernandez Rodriguez<br>
                        Diego Monterrey Benavides<br>
                        Carlos Obando Avendaña
                    </p>
                </section>

                <section class ="loging">
                    <form name="form" action="SLA" 
                          method="POST">
                        <h1>Iniciar Sesión</h1>
                        <table width="65%" cellpadding="8">
                            <tr>
                                <td>
                                    <input type="text" autocomplete="off" size="30" id="usuario" 
                                           name="usuario" placeholder="Nombre de Usuario"/>
                                </td>
                            </tr><tr>
                                <td>
                                    <input type="password"  size="30" id="password" name="password"  
                                           placeholder="Clave"/>
                                </td>
                            </tr><tr>
                                <td align="center" colspan="2">
                                    <button type="submit">Ingresar</button>
                                </td>
                            </tr>
                        </table>
                    </form>   
                </section>
                <button class='bnt' role="link" onclick="window.location = 'index.jsp'">Regresar</button>   
            </section>
        </div>
    </body>
</html>

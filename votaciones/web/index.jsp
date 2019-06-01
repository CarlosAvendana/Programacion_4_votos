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
        <link rel="shortcut icon" href="iconG.ico" type="image/x-icon" />
        <title>Login</title>
    </head>
    <body>
        <div id="wrapper">
            <section class ="container">
                <section class="comentario"> 
                    <h1> Bienvenido al Sistema de grupos de trabajo</h1>
                    <p>Aquí usted podrá formar grupos de trabajo, para realizar tareas y proyectos de el curso de Programación.</p>
                    <p>EIF209  Programación 4  Proyecto #1</p>
                    <p>1er ciclo 2019</p>
                    <p>Estudiantes: <br>
                        Djenane Hernandez Rodriguez<br>
                        Diego Monterrey Benavides<br>
                        Carlos Obando Avendaña
                    </p>
                </section>
                <section class ="loging">
                    <form name="form" action="ServicioLogin" method="POST">
                        <h1>Iniciar Sesión</h1>
                        <table width="65%" cellpadding="8">
                            <tr>
                                <td>
                                    <input type="text" autocomplete="off" size="30" id="usuario" name="usuario" placeholder="Usuario"/>
                                </td>
                            </tr><tr>
                                <td>
                                    <input type="password"  size="30" id="password" name="password"  placeholder="Clave"/>
                                </td>
                            </tr><tr>
                                <td align="center" colspan="2">
                                    <button type="submit">Ingresar</button>
                                </td>
                            </tr>
                        </table>
                    </form>
                </section>
            </section>
        </div>
    </body>
</html>

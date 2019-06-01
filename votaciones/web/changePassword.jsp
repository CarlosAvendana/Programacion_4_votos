<%-- 
//  changePassword.jsp
//  EIF209 - Programacion 4 -Proeycto #1
//  Abril 2019
//
//  Autores:
//  Djenane Hernandez Rodriguez
//  Diego Monterrey Benavides
//  Carlos Obando Avendaña
--%>

<%@page import="Modelos.Validacion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Change Password</title>
        <meta charset="UTF-8" />
        <link href="css/varios.css" rel="stylesheet" type="text/css"/>
        <link href="css/Color.css" rel="stylesheet" type="text/css"/>
        <link rel="shortcut icon" href="iconG.ico" type="image/x-icon" />
        <% response.setHeader("cache-control", "no-cache, no-store, must-revalidate"); %>
    </head>
    <body>
        <div id ="wrapper">
            <%
                //Validacion.validacion(request, response);
            %>
            <form name="form" action="ServicioChangePassword" method="POST">
                <section class="container">
                    <h1 style="text-align: center">Cambio de Contraseña</h1>
                    <p style="text-align: center">
                        Al ser este  primer ingreso se requiere un cambio de contraseña
                    </p>
                    <table class="changePassword" style="text-align: center">
                        <tr>          
                            <td style="text-align: center"><input type="password" size="30" id="oldPassword" 
                                                                  name="oldPassword" placeholder=" Ingrese su conraseña anterior" /></td>
                        </tr>
                        <tr>  
                            <td style="text-align: center"><input type="password" size="30" id="newPassword" 
                                                                  name="newPassword" placeholder="Ingrese su nueva contraseña" /></td>
                        </tr>
                        <td align="center" colspan="2">
                            <button type="submit">Ingresar</button>
                        </td>
                    </table>
                </section>
            </form>
        </div>
    </section>
</body>
</html>

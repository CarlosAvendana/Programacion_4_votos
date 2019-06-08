<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Examen Carlos Obando</title>
        <meta charset="UTF-8" />
        <link rel="shortcut icon" href="flecha.ico" type="image/x-icon" />
        <link href="css/default.css" rel="stylesheet" type="text/css"/>
        <link href="css/colors.css" rel="stylesheet" type="text/css"/>
        <script src="js/scripts.js" type="text/javascript"></script>
    </head>
    <body onload="init();">
        <div id="wrapper">
            <%@include file="header.jsp" %>
            <div id="contents">
                <h2 style="text-align: left">Ingreso</h2>
                <p>
                    <%
                        HttpSession sesionActual;
                        sesionActual = request.getSession(true);
                        sesionActual.invalidate();
                        sesionActual = request.getSession(true);
                    %>
                </p>

                <form name="loginForm" action="ServicioLogin"
                      method="POST">
                    <table width="65%" cellpadding="8">
                        <tr>
                            <td align="right">
                                Usuario:&nbsp;
                            </td><td>
                                <input type="text" size="30"
                                       id="usuario" name="usuario" autocomplete="off" />
                            </td>
                        </tr><tr>
                            <td align="right">
                                Clave:&nbsp;
                            </td><td>
                                <input type="password" size="30"
                                       id=password" name="password" />
                            </td>
                        </tr><tr>
                            <td align="center" colspan="2">
                                <button type="submit">Ingresar</button>
                            </td>
                        </tr>
                    </table>
                </form>
            </div>
            <%@include file="footer.jsp" %>
        </div>
    </body>
</html>

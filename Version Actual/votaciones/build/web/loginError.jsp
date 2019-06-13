

<%-- 
//  loginError.jsp
//  EIF209 - Programacion 4 -Proeycto #1
//  Abril 2019

//  Autores:
//  Djenane Hernandez Rodriguez
//  Diego Monterrey Benavides
//Carlos Obando Avendaña
--%>
<!DOCTYPE HTML>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <link rel="shortcut icon" href="iconG.ico" type="image/x-icon" />
        <title>Error de ingreso</title>
        <meta charset="UTF-8" />
        <link rel="shortcut icon" href="politics.ico" type="image/x-icon" />
        <script src="js/scripts.js" type="text/javascript"></script>
    </head>
    <body>
        <div id="wrapper">
            <section class="container">
                <section class="section10" style="padding: auto">
                    <h2>
                        <span style="color: red; font-weight: bold; text-align: center;">Error de ingreso</span>
                    </h2>
                    <p><strong>No ha iniciado la sesión.</strong><br />
                        Esto puede deberse a que la sesión ha expirado
                        o que los datos
                        de ingreso son incorrectos.</p>
                    <p>
                        <span style="color:red">
                            <%
                                int codError = 0;
                                String mensaje = "(Error sin determinar)";
                                try {
                                    codError = Integer.parseInt(request.getParameter("error"));
                                } catch (Exception e) {
                                }
                                switch (codError) {
                                    case 1:
                                        mensaje = "La sesión ha expirado.";
                                        break;
                                    case 2:
                                        mensaje = "El nombre de usuario o la clave son incorrectos.";
                                        break;
                                    default:
                                                ;
                                }
                                out.println(mensaje);
                            %>
                        </span>
                    </p>
                    <button role="link" onclick="window.location = 'index.jsp'">Regresar</button>
                    </p>
                </section>
            </section>
        </div>
    </body>
</html>


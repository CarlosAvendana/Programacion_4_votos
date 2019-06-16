<%@page import="Modelo.Validacion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>XML</title>
        <meta charset="UTF-8" />
        <script src="scripts/script.js" type="text/javascript"></script>
    </head>
    <body onload="init0();">
        <%
            Validacion.validacion(request, response);
        %>
        <div id="wrapper">
            <header></header>
            <div id="contents">
                <section>
                    <table class="tablaUsuarios">
                        <caption>Listado de usuarios</caption>
                        <thead>
                            <tr>
                                <th>Cédula</th>
                                <th colspan="2">Apellidos</th>
                                <th>Nombre</th>
                                <th>Clave</th>
                                <th>Activo</th>
                            </tr>
                        </thead>
                        <tbody id="datosUsuarios">
                        </tbody>
                    </table>
                </section>
                <section>
                    <input type="file" id="archivo" name="ar"/>
                    <button onclick="cargarArchivo();">Cargar usuarios</button>
                </section>
            </div>
            <footer></footer>
        </div>
    </body>
</html>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Ejemplo (usuarios)</title>
        <meta charset="UTF-8" />
        <link rel="stylesheet" 
              href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" 
              crossorigin="anonymous" />
        <link href="default.css" rel="stylesheet" type="text/css"/>
        <script src="scripts.js" type="text/javascript"></script>
    </head>
    <body onload="init();">
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
                    <input type="file" id="archivo" />
                    <button onclick="cargarArchivo();">Cargar usuarios</button>
                    <p style="font-size: 9pt;">
                        Utilizando:&nbsp;
                        <strong><%= servicios.AdministradorGestor.obtenerInstancia().obtenerGestor().obtenerDescripcion()%></strong>
                    </p>
                </section>
            </div>
            <footer></footer>
        </div>
    </body>
</html>

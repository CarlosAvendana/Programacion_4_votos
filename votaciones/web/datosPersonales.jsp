<%-- 
    Document   : datosPersonales
    Created on : 08/06/2019, 05:24:20 PM
    Author     : djnane
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Gestores.GestorUsuario" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" href="politics.ico" type="image/x-icon" />
        <link href="css/Color.css" rel="stylesheet" type="text/css"/>       
        <title>Votaciones</title>
    </head>
    <body>
        <div id = "wrapper">            
        <h1>Bienvenido al sistema de Votaciones</h1>
               <div id="contents">
                <h1>Datos Personales</h1>
                <section>
                    <table id="tabla3" class="tablaDatos">
                        <%=GestorUsuario.obtenerInstancia().obtenerDatosHTML(request.getSession(true).getAttribute("usuario"))%>
                    </table>
                </section>
            </div>
            
        </div>
        
    </body>
</html>

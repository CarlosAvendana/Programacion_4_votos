<%-- 
//  votacion.jsp
//  EIF209 - Programacion 4 -Proeycto #2
//  Abril 2019
//
//  Autores:
//  Djenane Hernandez Rodriguez
//  Diego Monterrey Benavides
//Carlos Obando Avendaña
// es la mesa para votar 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="scripts/script.js" type="text/javascript"></script>
        <link href="css/Color.css" rel="stylesheet" type="text/css"/>
        <title>Votacion</title>
    </head>
<<<<<<< HEAD
    <body onload="init2()">
          <div id="wrapper">
=======
    <body>
        <div id="wrapper">
>>>>>>> 45e02dddf225f92d95fb9a6a3fce98274f23ed51
            <section class="datos">
                <h1>Datos Personales</h1>
                <p>Cédula: <strong>${usuario.cedula}</strong></p>
                <p>Nombre: <strong>${usuario.nombre}</strong></p>
                <p>Primer apellido: <strong>${usuario.apellido1}</strong></p>
                <p>Segundo apellido: <strong>${usuario.apellido2}</strong></p>
            </section>
            <section id  = "votacion">
                <table id ="tablaVotacion">
<<<<<<< HEAD
                    <tbody id="datosVotacion"></tbody>
                                 </table>   
                
=======

                </table>
>>>>>>> 45e02dddf225f92d95fb9a6a3fce98274f23ed51
            </section>

        </div>


    </body>
</html>

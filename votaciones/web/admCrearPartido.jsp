<%-- 
//  crearPartido.jsp
//  EIF209 - Programacion 4 -Proeycto #2
//  Junio 2019
//
//  Autores:
//  Djenane Hernandez Rodriguez
//  Diego Monterrey Benavides
//  Carlos Obando Avendaña
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/Color.css" rel="stylesheet" type="text/css"/>
        <link rel="shortcut icon" href="politics.ico" type="image/x-icon" />
        <title>Creando partido político</title>
    </head>
    <body>
        <div id="wrapper">
            <div id="contents">
                <section id="crearP">
                    <form id="formP"action="ServicioCreaciondePartido" method="POST" enctype="multipart/form-data">
                        <table id="tablaFormulario" >
                            <caption style="font-size: 20pt"><strong>Creación del Partido</strong></caption>
                            <tbody id="cuerpoForm">
                                <tr class="r" style="padding-bottom: 10%;">
                                    <td class="c1"><strong>Bandera</strong>:&nbsp;</td>
                                    <td class="c2">
                                        <input type="file" id="archivo" name="archivo" />
                                    </td>
                                </tr>
                                <tr class="r" style="border: 3px solid black; border-collapse: collapse">
                                    <td class="c1"><strong>Nombre del Partido</strong>:&nbsp;</td>
                                    <td class="c2">
                                        <input type="text" id="campo1" name="nombre" 
                                               size="30" autocomplete="off"/>
                                    </td>
                                </tr>
                                <tr class="r" style="border: 3px solid black;">
                                    <td class="c1"><strong>Siglas del Partido</strong>:&nbsp;</td>
                                    <td class="c2">
                                        <input type="text" id="campo1" name="siglas" 
                                               size="10" autocomplete="off"/>
                                    </td>
                                </tr>
                                <tr class="r" style="border: 3px solid black">
                                    <td class="c1"><strong>Observaciones</strong>:&nbsp;</td>
                                    <td class="c2">
                                        <textarea  name="observaciones"  style="resize: none" rows="5" cols="40"></textarea>
                                    </td>
                                </tr>
                                <tr>                               
                                    <td td alinf="center" >
                                        <button type="submit">Crear</button>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </form>
                </section>
            </div>
        </div>
    </body>
</html>

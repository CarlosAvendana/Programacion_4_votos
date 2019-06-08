<%-- 
//  adminGeneral.jsp
//  EIF209 - Programacion 4 -Proeycto #2
//  Abril 2019
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
        <meta charset="UTF-8" />
        <link href="css/Color.css" rel="stylesheet" type="text/css"/>
        <link rel="shortcut icon" href="politics.ico" type="image/x-icon" />
        <title>General Administrator</title>
    </head>
    <body>
        <div id="wrapper">
            <div id="contents">
                <section id="botones">
                    <table id="tablaButton">
                        <thead>
                            <tr>
                                <td>
                                    <button class="bnt">Generar Reportes</button>   
                                </td>
                                <td>
                                    <button class="bnt">Cargar Usuario</button>   
                                </td>
                                <td>
                                    <button class="bnt">Gestionar Dias Votacion</button>   
                                </td>
                                <td>
                                    <form name='formOut' action='ServicioLogout'method='POST'>
                                        <input class='btn' type='submit' value='LogOut' name='cerrar' >
                                    </form>
                                </td>
                            </tr>
                        </thead>
                    </table>
                </section>
                <section>
                    
                </section>
            </div>
        </div>
    </body>
</html>

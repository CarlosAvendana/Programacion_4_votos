<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="cr.ac.database.managers.DBManager" %>
<%@page import="modelo.entidades.dao.GestorCursos"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>Matricula Cursos</title>
        <link href="css/colors.css" rel="stylesheet" type="text/css"/>
        <link href="css/default.css" rel="stylesheet" type="text/css"/>
        <script src="js/scripts.js" type="text/javascript"></script>
    </head>
    <body>
        <div>
            <%@include file="header.jsp" %>
            <section id="wrapper">
                <section id="contents">
                    <h2 style="text-align: center">Matricula</h2>
                    <section id="cuerpo">
                        <section >
                            <table id="tablaButton">
                                <thead>
                                    <tr>
                                        <td>
                                            <form name="logout" action="ServicioLogout"
                                                  method="POST">
                                                <button type="submit">Salir </button>
                                            </form>
                                        </td>
                                        <td>
                                            <button  disable="true">Matricular </button> 
                                        </td>
                                        <td>
                                        <th><input type="button" onclick=" location.href = 'datos.jsp'" value="Datos Personales" name="boton" /></th>
                                        </td>
                                    </tr>
                                </thead>
                            </table>
                        </section>
                        <section id="secTablaCursos"> 
                            <div id="DivTablaCursos">
                                <table id="tablaCursos" class="tablaDatos">
                                    <caption style="text-align: center"><strong>Cursos</strong></caption>
                                    <thead>
                                        <tr>
                                            <th style="text-align: center">Codigo</th>
                                            <th style="text-align: center">Nombre</th>
                                            <th style="text-align: center">Creditos</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <jsp:useBean id="cursos" class="modelo.entidades.dao.GestorCursos" ></jsp:useBean>
                                        ${cursos.tablaHTML}
                                    </tbody>
                                </table>
                            </div>
                        </section>
                        <section>
                            <section id="SecTablaCurMa">
                                <table id="tablaMatriculados" class="tablaDatos">
                                    <caption style="text-align: center"><strong>Matriculados</strong></caption>
                                    <thead>
                                        <tr>
                                            <th style="text-align: center">Codigo</th>
                                            <th style="text-align: center">Nombre</th>
                                            <th style="text-align: center">Creditos</th>
                                        </tr>
                                    </thead>
                                    <tbody>

                                    </tbody>
                                </table>
                            </section>
                        </section>
                        <section id="forms">
                            <form name="matriculaform" action="ServicioMatricula"
                                  method="POST">
                                <table width="65%" cellpadding="4">
                                    <tr>
                                        <td align="right">
                                            Codigo Curso Matricular:&nbsp;

                                            <input type="text" size="15"
                                                   id="idcurso" name="curso" autocomplete="off" />
                                        </td>

                                        <td align="center" colspan="2">
                                            <button type="submit">Matricular</button>
                                        </td>
                                    </tr>
                                </table>
                            </form>
                            <form name="matriculaform" action="ServicioDesmatricular"
                                  method="POST">
                                <table width="65%" cellpadding="4">
                                    <tr>
                                        <td align="right">
                                            Codigo Curso DesMatricular&nbsp;
                                            <input type="text" size="15"
                                                   id="idcurso" name="curso" autocomplete="off" />
                                        </td>
                                        <td align="center" colspan="2">
                                            <button type="submit">Desmatricular</button>
                                        </td>
                                    </tr>
                                </table>
                            </form>
                        </section>
                    </section>
                </section>
            </section>
            <%@include file="footer.jsp" %>
        </div>
    </body>
</html>

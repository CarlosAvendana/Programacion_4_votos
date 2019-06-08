<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>

<footer id="piez">
    <link href="css/colors.css" rel="stylesheet" type="text/css"/>
    <link href="css/default.css" rel="stylesheet" type="text/css"/>
    <p><%= new SimpleDateFormat("yyyy/MM/dd hh:mm").format(Calendar.getInstance().getTime())%></p>
    <p>&COPY; 2019. Carlos Alberto Obando Avendaña</p>
</footer>
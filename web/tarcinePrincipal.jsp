<%-- 
    Document   : tarcinePrincipal
    Created on : 29/09/2021, 3:53:00 p. m.
    Author     : Cristian Castro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/estilosTarcine.css" type="text/css" media="all">
        <%
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
            if (session.getAttribute("nombre") == null && session.getAttribute("txtcorreo") == null) {
                response.sendRedirect("index.html");
            }
        %>
    </head>
    <body>
        <div class="ContenidoInicio">
            <h1>Bienvenido usuario : <%= request.getSession().getAttribute("nombre")%></h1>
            <p><a href="https://www.google.com">Crear Trajeta Tarcine</a></p>
            <p>su correo es ${txtcorreo}</p>
            <form action="CerrarSesion">
                <input type="submit" value="Cerrar session" class="btn">
            </form>
        </div>
    </body>
</html>

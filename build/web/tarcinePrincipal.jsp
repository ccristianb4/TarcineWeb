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
        <%
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        if(session.getAttribute("nombre") == null && session.getAttribute("txtcorreo") == null){
            response.sendRedirect("index.html");
        }
        %>
    </head>
    <body>
        <h1>Bienvenido usuario : <%= request.getSession().getAttribute("nombre")%></h1>
        <p><a href="https://www.google.com">ir a google</a></p>
        <p>su correo es ${txtcorreo}</p>
        <form action="CerrarSesion">
            <input type="submit" value="Cerrar session">
        </form>
    </body>
</html>

<%-- 
    Document   : opcionesPeli
    Created on : 4/10/2021, 8:13:52 a. m.
    Author     : Cristian Castro
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
            //response.setHeader("Pragma", "no-cache");
            //response.setDateHeader("Expires", 0);
            List<String> nomb = (List<String>)session.getAttribute("nom");
        %>
    </head>
    <body>
        <div>
            <form action="infomacionPeli" method="post">
                <p>Opciones de peliculas</p>
                <select name="listemails[]">
                    <%
                        for (int i = 0; i < nomb.size(); i++) {
                    %>
                    <option value="<%=nomb.get(i) %>" ><%=nomb.get(i)%></option>
                    <%}%>
                </select>
                <input type="submit" name="Reservar" value="Reservar">
            </form>
        </div>
    </body>
</html>

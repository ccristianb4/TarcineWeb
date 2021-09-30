<%-- 
    Document   : tarjetaTarcine
    Created on : 30/09/2021, 8:34:52 a. m.
    Author     : Cristian Castro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tarjeta</title>
        <%
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        %>
    </head>
    <body>
        <div>
        <h1>Hello World! <p>su id es ${txtId}</p></h1>
        <h1>Hello World! <p>su codigo es ${txtCod}</p></h1>
        <h1>Hello World! <p>su saldo es ${txtSaldo}</p></h1>
        </div>
    </body>
</html>

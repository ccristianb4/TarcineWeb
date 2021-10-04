<%-- 
    Document   : Recarga
    Created on : 3/10/2021, 5:12:30 p. m.
    Author     : Cristian Castro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/estiloTarjeta.css" type="text/css"/>
    </head>
    <body>
        <div class="cuerpo">
            <form class="contenedor" action="Recarga" method="post">
                <p>Digite el valor a recargar </p>
                <input type="number" class="txt" id="txtValor" required="" name="txtValor">
                <input type="submit" value="Recargar" class="btn" name="Recargar">
            </form>
        </div>
    </body>
</html>

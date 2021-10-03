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
        <link rel="stylesheet" href="css/estiloTarjeta.css" type="text/css"/>
        <%
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
            //response.setHeader("Pragma", "no-cache");
            //response.setDateHeader("Expires", 0);
        %>
    </head>
    <body>
        <div class="tarjeta">
        <p>su id es ${txtId2}</p>
        <p>su codigo es ${txtCod2}</p>
        <p>su saldo es ${txtSaldo2}</p>
        <nav class="menu" id="menu">
            <ul>
                <li><a href="#" onclick="cargarRecarga()">Regargar Tarjeta</a></li>
                <li><a href="#" onclick="cargarRegister()">Registro de Usuario</a></li>
            </ul>
            
        </nav>
        </div>
        <section class="ContedidoDinamico" id="ContedidoDinamico">
            
        </section>
    </body>
    <script src="js/funcionesTarjeta.js"></script>
</html>

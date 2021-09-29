<%-- 
    Document   : login
    Created on : 28/09/2021, 1:40:41 p. m.
    Author     : Cristian Castro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalide");
            response.setHeader("Pragma", "no-cache");
            response.setDateHeader("Expires", 0);
        %>
    </head>
    <body>
        <div class="cuerpoFormulario" id="cuerpoFormulario">
            <form class="formulario" id="formulario">
                <h1> INICIE SESION </h1>
                <p>Usuario:</p>
                <div class="texto">
                    <input type="text" class="txt" id="txtUsuario" required="">
                </div>
                <p>Contraseña:</p>
                <div class="texto">
                    <input type="password" class="txt" id="txtContraseña" required="">
                </div>
                <br>
                <input type="submit" value="Iniciar Sesion" class="btn">
                <input type="button" value="Borrar Datos" class="btn" onclick="resetearLogin()">
            </form>
        </div>
    </body>
    <script src="js/funcionesLogin.js"></script>
</html>

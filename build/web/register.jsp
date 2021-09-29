<%-- 
    Document   : register
    Created on : 28/09/2021, 1:40:55 p. m.
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
            <form class="formularioAlta" id="formularioAlta" method="post" action="registrando">
                <<h1>REGISTRO DE USUARIOS</h1>
                <label>Nombre Completo:</label> <input type="text" class="txt" id="txtNombre" required="" name="txtNombre">
                <br>
                <br>
                <label>UserName:</label> <input type="text" class="txt" id="txtUserName" required="" name="txtUserName">
                <br>
                <br>
                <label>Correo electronico:</label> <input type="email" class="txt" id="txtCorreo" required="" onkeyup="validarEmail()" name="txtCorreo"><span class="labelError" id="emailOK"></span>
                <br>
                <br>
                <label>Contraseña:</label> <input type="password" class="txt" id="txtContrasena" required="" onkeyup="validarContrasena()" name="txtContrasena">
                <label>Repetir Contraseña:</label> <input type="password" class="txt" id="txtContrasena2" required="" onkeyup="validarContrasena()">
                <br>
                <br>
                <label class="aviso" id="aviso">--------</label>
                <br>
                <br>
                <input type="submit" value="Registrar" class="btn" id="btnRegistrar" name="btnRegistrar">
                <input type="button" value="Borrar Datos" class="btn" id="btnBorrar" onclick="borrarDatosRegistro()">
            </form>
        </div>
    </body>
    <script src="js/funcionesRegistro.js"></script>
</html>

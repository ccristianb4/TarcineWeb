<%-- 
    Document   : actualizarDatos
    Created on : 5/10/2021, 4:25:42 p. m.
    Author     : Cristian Castro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/estiloActualizarDatos.css" type="text/css">
        <title>Actualizacion de Datos</title>
        <%
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
            //response.setHeader("Pragma", "no-cache");
            //response.setDateHeader("Expires", 0);
        %>
    </head>
    <body>
        <div class="cuerpoFormulario">
            <form class="formulario" action="Actualizacion" method="post">
                <h1>Datos de Usuario</h1>
                <p>ID:</p>
                <div class="texto">
                    <input type="text" class="txt" id="txtid"  name="txtid" disabled value="${txtId2}">
                </div>
                <p>Nombre Completo</p>
                <div class="texto">
                    <input type="text" class="txt" id="txtNombreA" required="" name="txtNombreA" value="${txtNombreC}">
                </div>
                <p>UserName</p>
                <div class="texto">
                    <input type="text" class="txt" id="txtUserNameA" required="" name="txtUserNameA" value="${nombre}">
                </div>
                <p>Correo Electronio</p>
                <div class="texto">
                    <input type="text" class="txt" id="txtCorreoA" required="" name="txtCorreoA" value="${txtcorreo}">
                </div>
                <p>Contraseña</p>
                <div class="texto">
                    <input type="password" class="txt" id="txtContrasenaA" required="" name="txtContrasenaA" value="${txtPass}">
                </div>
                <input type="submit" class="btn" name="Actualizar" value="Actualizar">
                <input type="button" class="btn" name="volver" value="volver" onclick="sendPrincipal1()">
            </form>
        </div>
    </body>
    <script src="js/prueba1.js" type="text/javascript"></script>
</html>

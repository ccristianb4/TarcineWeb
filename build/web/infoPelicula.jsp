<%-- 
    Document   : infoPelicula
    Created on : 4/10/2021, 7:34:46 a. m.
    Author     : Cristian Castro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Informacion de la pelicula</title>
        <link rel="stylesheet" href="css/estiloInfoPelicula.css" type="text/css" media="all">

        <%
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
            //response.setHeader("Pragma", "no-cache");
            //response.setDateHeader("Expires", 0);
        %>
    </head>
    <body>
        <div class="contenidoPeli">
            <img src="${txtfoto}" width="200" height="300"/>
            <p><b>Codigo : </b>${txtCodPeli}<br>
                <b>Nombre : </b>${txtNombrePeli}<br>
                <b>Duracion : </b>${txtDuracion}<br>
                <b>Genero : </b>${txtGenero}<br>
                <b>Clasificacion : </b>${txtClasificacion}
            </p>
            <nav class="menu" id="menu">
                <input type="button" name="ReservarBoletas" value="Reservar Boletas" class="btn" onclick="cargarAnuncio()">
                <input type="button" name="volver" value="volver" class="btn" onclick="sendPrincipal1()">

        </nav>
        </div>
        <section class="ContedidoDinamico" id="ContedidoDinamico">

        </section>
    </body>
    <script src="js/funcionesInfoPelicula.js"></script>
    <script src="js/prueba1.js" type="text/javascript"></script>
</html>

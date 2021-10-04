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
        <title>JSP Page</title>
        
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
        </div>
    </body>
</html>

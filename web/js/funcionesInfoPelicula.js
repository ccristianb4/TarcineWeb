/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */
function cargarElementoDinamicamente(url,elemento){
    var request = new XMLHttpRequest();
    request.open("GET",url,false);
    request.send(null);
    elemento.innerHTML = request.responseText;
}
function cargarFormulario(){
    cargarElementoDinamicamente("actualizarDatos.jsp",document.getElementById("ContedidoDinamico"));
}
function cargarAnuncio(){
    cargarElementoDinamicamente("anuncio.jsp",document.getElementById("ContedidoDinamico"));
}


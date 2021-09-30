/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */
function borrarDatosRegistro(){
    document.getElementById("formularioAlta").reset();
    var boton = document.getElementById("btnRegistrar");
    var aviso = document.getElementById("aviso");
    boton.disabled = true;
    aviso.innerHTML = " ";
}


function validarEmail(){
    campo = event.target;
    valido = document.getElementById('emailOK');
        
    emailRegex = /^[-\w.%+]{1,64}@(?:[A-Z0-9-]{1,63}\.){1,125}[A-Z]{2,63}$/i;
    //Se muestra un texto a modo de ejemplo, luego va a ser un icono
    if (emailRegex.test(campo.value)) {
      valido.innerText = "válido";
    } else {
      valido.innerText = "incorrecto";
    }
    valido.style.color = "blue";
}

function validarContrasena(){
    var txtcontrasena = document.getElementById("txtContrasena");
    var txtcontrasena2 = document.getElementById("txtContrasena2");
    var aviso = document.getElementById("aviso");
    var boton = document.getElementById("btnRegistrar");
    boton.disabled = true;
    if(txtcontrasena.value.length == 0 || txtcontrasena2.value.length == 0){
        aviso.innerHTML = "Ningun campo de contraseñas debe quedar vacio";
        aviso.style.color = "blue";
    }else if(txtcontrasena.value != txtcontrasena2.value){
        aviso.innerHTML = "Las contraseña son diferentes";
        aviso.style.color = "blue";
    }else{
        aviso.innerHTML = " ";
        boton.disabled = false;
    }
}


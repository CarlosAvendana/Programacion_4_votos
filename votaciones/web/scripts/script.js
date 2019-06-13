function init() {
    console.log("Aplicación inicializada..");
}
<<<<<<< HEAD

function init2(){
    console.log("Mostrando datos para votacion")
    solicitarDatosVotacionPartido("ServicioVotacionPartido","datosVotacion");
}

function solicitarDatosVotacionPartido(origen, tabla){
        fetch(origen).then(
=======
function asignaUsuariosAPartido() {
    solicitarDatosListarUsuarios("ServicioListarUsuario", "tablaUsuarios");
    solicitarDatosListarPartidos("ServicioListarPartidos", "tablaPartidos");
}
function solicitarDatosListarUsuarios(origen, tabla) {
    fetch(origen).then(
>>>>>>> 45e02dddf225f92d95fb9a6a3fce98274f23ed51
            (resultados) => {
        return resultados.json();
    }
    ).then(
            (datosJSON) => {
<<<<<<< HEAD
        cargarTablaVotacion(tabla, datosJSON);
    }
    );
    
}

function cargarTablaVotacion(tabla, datos){
        var refTabla = document.getElementById(tabla);
    if (refTabla) {
        for (var i = 0; i < datos.listVP.length; i++) {
            var nuevaFila = refTabla.insertRow(-1);
            var nuevaCelda;
            nuevaCelda = nuevaFila.insertCell(-1);
            nuevaCelda.innerText = datos.listVP[i].Partido;
            nuevaCelda = nuevaFila.insertCell(-1);
            nuevaCelda.innerText = datos.listVP[i].Siglas;
            nuevaCelda = nuevaFila.insertCell(-1);
            nuevaCelda.innerText = datos.listVP[i].Cadidato;
            nuevaCelda = nuevaFila.insertCell(-1);
        }
    }
    
}

=======
        cargarTablaUsuarios(tabla, datosJSON);
        console.log(datosJSON);
    }
    );
}
function cargarTablaUsuarios(tabla, datos) {
    var refTabla = document.getElementById(tabla);
    if (refTabla) {
        for (var i = 0; i < datos.usuarios.length; i++) {
            var nuevaFila = refTabla.insertRow(-1);
            var nuevaCelda;

            nuevaCelda = nuevaFila.insertCell(-1);
            nuevaCelda.innerText = datos.usuarios[i].cedula;
            nuevaCelda = nuevaFila.insertCell(-1);
            nuevaCelda.innerText = datos.usuarios[i].apellido1;
            nuevaCelda = nuevaFila.insertCell(-1);
            nuevaCelda.innerText = datos.usuarios[i].apellido2;
            nuevaCelda = nuevaFila.insertCell(-1);
            nuevaCelda.innerText = datos.usuarios[i].nombre;
        }
    }
}

function solicitarDatosListarPartidos(origen, tabla) {
    fetch(origen).then(
            (resultados) => {
        return resultados.json();
    }
    ).then(
            (datosJSON) => {
        cargarTablaPartidos(tabla, datosJSON);
        console.log(datosJSON);
    }
    );
}

function cargarTablaPartidos(tabla, datos) {
    var refTabla = document.getElementById(tabla);
    if (refTabla) {
        for (var i = 0; i < datos.partidos.length; i++) {
            var nuevaFila = refTabla.insertRow(-1);
            var nuevaCelda;

            nuevaCelda = nuevaFila.insertCell(-1);
            nuevaCelda.innerText = datos.partidos[i].siglas;
            nuevaCelda = nuevaFila.insertCell(-1);
            nuevaCelda.innerText = datos.partidos[i].nombre;
            nuevaCelda = nuevaFila.insertCell(-1);
            nuevaCelda.innerText = datos.partidos[i].observaciones;

        }
    }
}
>>>>>>> 45e02dddf225f92d95fb9a6a3fce98274f23ed51

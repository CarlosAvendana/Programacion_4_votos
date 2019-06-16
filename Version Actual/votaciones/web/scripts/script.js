function init() {
    console.log("Aplicación inicializada..");
}
function asignaUsuariosAPartido() {
    solicitarDatosListarUsuarios("ServicioListarUsuario", "tablaUsuarios");
    solicitarDatosListarPartidos("ServicioListarPartidos", "tablaPartidos");
    solicitarDatosListarFechas("ServicioTablaVotacion", "tablaFechas");
}

function init1(){
    solicitarDatosListarFechas1("ServicioTablaVotacion2", "tablaFechas");
}
function init5(){
    solicitarDatosListarPartidos("ServicioListarPartidos", "tablaPartidos");
}

function cargarTablaFechas1(tabla, datos) {
    var refTabla = document.getElementById(tabla);
    if (refTabla) {
        for (var i = 0; i < datos.fechas.length; i++) {
            var nuevaFila = refTabla.insertRow(-1);
            var nuevaCelda;
            nuevaCelda = nuevaFila.insertCell(-1);
            nuevaCelda.innerText = datos.fechas[i].id;
            nuevaCelda = nuevaFila.insertCell(-1);
            nuevaCelda.innerText = datos.fechas[i].fecha_inicio;
            nuevaCelda = nuevaFila.insertCell(-1);
            nuevaCelda.innerText = datos.fechas[i].fecha_final;
            var b = datos.fechas[i].estado;
            nuevaCelda = nuevaFila.insertCell(-1);
            nuevaCelda.setAttribute("class", b === 1 ? "especial" : "especial1");
            nuevaCelda.innerHTML = b ? "&#10004;" : "&#10006;";
        }
    }
}


function solicitarDatosListarFechas1(origen, tabla) {
    fetch(origen).then(
            (resultados) => {
        return resultados.json();
    }
    ).then(
            (datosJSON) => {
        cargarTablaFechas1(tabla, datosJSON);
        console.log(datosJSON);
    }
    );
}


function cargarTablaFechas(tabla, datos) {
    var refTabla = document.getElementById(tabla);
    if (refTabla) {
        for (var i = 0; i < datos.fechas.length; i++) {
            var nuevaFila = refTabla.insertRow(-1);
            var nuevaCelda;
            nuevaCelda = nuevaFila.insertCell(-1);
            nuevaCelda.innerText = datos.fechas[i].id;
            nuevaCelda = nuevaFila.insertCell(-1);
            nuevaCelda.innerText = datos.fechas[i].fecha_inicio;
            nuevaCelda = nuevaFila.insertCell(-1);
            nuevaCelda.innerText = datos.fechas[i].fecha_final;
        }
    }
}

function solicitarDatosListarFechas(origen, tabla) {
    fetch(origen).then(
            (resultados) => {
        return resultados.json();
    }
    ).then(
            (datosJSON) => {
        cargarTablaFechas(tabla, datosJSON);
        console.log(datosJSON);
    }
    );
}

function solicitarDatosListarUsuarios(origen, tabla) {
    fetch(origen).then(
            (resultados) => {
        return resultados.json();
    }
    ).then(
            (datosJSON) => {
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

function init2() {
    console.log("Mostrando datos para votacion")
    solicitarDatosVotacionPartido("ServicioVotacionPartido", "datosVotacion");
}

function solicitarDatosVotacionPartido(origen, tabla) {
    fetch(origen).then(
            (resultados) => {
        return resultados.json();
    }
    ).then(
            (datosJSON) => {
        cargarTablaVotacionPartido(tabla, datosJSON);
        console.log(datosJSON);
    }
    );
}


function cargarTablaVotacionPartido(tabla, datos) {
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



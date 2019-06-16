function init() {
    console.log("Aplicación inicializada..");
}
function asignaUsuariosAPartido() {
    solicitarDatosListarUsuarios("ServicioListarUsuario", "tablaUsuarios");
    solicitarDatosListarPartidos("ServicioListarPartidos", "tablaPartidos");
    solicitarDatosListarFechas("ServicioTablaVotacion", "tablaFechas");
}
function init1() {
    solicitarDatosListarFechas1("ServicioTablaVotacion2", "tablaFechas");
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
            nuevaCelda = nuevaFila.insertCell(-1);
            nuevaCelda.innerText = datos.fechas[i].estado;
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

function initReporte() {
    solicitarDartosReporte1("ServicioListarReportes", "TablaReportes");
    solicitarDartosReporte2("ServicioListarRepoVotantesRegistrados", "tablaBotantesRegistrados");
    solicitarDartosReporte3("ServicioListarRepoVotosEfectivos", "votoEfectuadoTabla");
    solicitarDartosReporte4("ServicioListarRepoVotosNOEfectivos", "votoNOEfectuados");
    solicitarDartosReporte5("ServicioListarRepoCandidatos", "TC");
}

function solicitarDartosReporte1(origen, tabla) {
    fetch(origen).then(
            (resultados) => {
        return resultados.json();
    }
    ).then(
            (datosJSON) => {
        cargarTablaReporte1(tabla, datosJSON);
        console.log(datosJSON);
    }
    );
}

function cargarTablaReporte1(tabla, datos) {
    var refTabla = document.getElementById(tabla);
    if (refTabla) {
        for (var i = 0; i < datos.reportes.length; i++) {
            var nuevaFila = refTabla.insertRow(-1);
            var nuevaCelda;
            nuevaCelda = nuevaFila.insertCell(-1);
            nuevaCelda.innerText = datos.reportes[i].votacion_id;
            nuevaCelda = nuevaFila.insertCell(-1);
            nuevaCelda.innerText = datos.reportes[i].partido_siglas;
            nuevaCelda = nuevaFila.insertCell(-1);
            nuevaCelda.innerText = datos.reportes[i].cedula_candidato;
            nuevaCelda = nuevaFila.insertCell(-1);
            nuevaCelda.innerText = datos.reportes[i].votos_obtenidos;

        }
    }

}

function solicitarDartosReporte2(origen, tabla) {
    fetch(origen).then(
            (resultados) => {
        return resultados.json();
    }
    ).then(
            (datosJSON) => {
        cargarTablaReporte2(tabla, datosJSON);
        console.log(datosJSON);
    }
    );
}

function cargarTablaReporte2(tabla, datos) {
    var refTabla = document.getElementById(tabla);
    if (refTabla) {
        for (var i = 0; i < datos.votantes_registradosR.length; i++) {
            var nuevaFila = refTabla.insertRow(-1);
            var nuevaCelda;
            nuevaCelda = nuevaFila.insertCell(-1);
            nuevaCelda.innerText = datos.votantes_registradosR[i].vt;

        }
    }

}

function solicitarDartosReporte3(origen, tabla) {
    fetch(origen).then(
            (resultados) => {
        return resultados.json();
    }
    ).then(
            (datosJSON) => {
        cargarTablaReporte3(tabla, datosJSON);
        console.log(datosJSON);
    }
    );
}

function cargarTablaReporte3(tabla, datos) {
    var refTabla = document.getElementById(tabla);
    if (refTabla) {
        for (var i = 0; i < datos.votos_efectuados.length; i++) {
            var nuevaFila = refTabla.insertRow(-1);
            var nuevaCelda;
            nuevaCelda = nuevaFila.insertCell(-1);
            nuevaCelda.innerText = datos.votos_efectuados[i].voto_efectivo;
            nuevaCelda = nuevaFila.insertCell(-1);
            nuevaCelda.innerText = datos.votos_efectuados[i].pocertanje;
        }
    }

}

function solicitarDartosReporte4(origen, tabla) {
    fetch(origen).then(
            (resultados) => {
        return resultados.json();
    }
    ).then(
            (datosJSON) => {
        cargarTablaReporte4(tabla, datosJSON);
        console.log(datosJSON);
    }
    );
}

function cargarTablaReporte4(tabla, datos) {
    var refTabla = document.getElementById(tabla);
    if (refTabla) {
        for (var i = 0; i < datos.votos_NOefectuados.length; i++) {
            var nuevaFila = refTabla.insertRow(-1);
            var nuevaCelda;
            nuevaCelda = nuevaFila.insertCell(-1);
            nuevaCelda.innerText = datos.votos_NOefectuados[i].voto_NOefectivo;
            nuevaCelda = nuevaFila.insertCell(-1);
            nuevaCelda.innerText = datos.votos_NOefectuados[i].pocertanje;


        }
    }

}


function solicitarDartosReporte5(origen, tabla) {
    fetch(origen).then(
            (resultados) => {
        return resultados.json();
    }
    ).then(
            (datosJSON) => {
        cargarTablaReporte5(tabla, datosJSON);
        console.log(datosJSON);
    }
    );
}

function cargarTablaReporte5(tabla, datos) {
    var refTabla = document.getElementById(tabla);
    if (refTabla) {
        for (var i = 0; i < datos.FINAL.length; i++) {
            var nuevaFila = refTabla.insertRow(-1);
            var nuevaCelda;
            nuevaCelda = nuevaFila.insertCell(-1);
            nuevaCelda.innerText = datos.FINAL[i].v1;
            nuevaCelda = nuevaFila.insertCell(-1);
            nuevaCelda.innerText = datos.FINAL[i].v2;
            nuevaCelda = nuevaFila.insertCell(-1);
            nuevaCelda.innerText = datos.FINAL[i].v3;
            nuevaCelda = nuevaFila.insertCell(-1);
            nuevaCelda.innerText = datos.FINAL[i].v4;
        }
    }

}

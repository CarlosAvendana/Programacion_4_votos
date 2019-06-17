function init() {
    console.log("Aplicación inicializada..");
}
//llamada para cargas las tablas en admCrearPostulante
function asignaUsuariosAPartido() {
    solicitarDatosListarUsuarios("ServicioListarUsuario", "tablaUsuarios");
    solicitarDatosListarPartidos("ServicioListarPartidos", "tablaPartidos");
    solicitarDatosListarFechas("ServicioTablaVotacion", "tablaFechas");
}

function init1() {
    solicitarDatosListarFechas1("ServicioTablaVotacion2", "tablaFechas");
}

//llamada para la tbla de fechas
function init1(){
    solicitarDatosListarFechas1("ServicioTablaVotacion2", "tablaFechas");
}
//llamada para la tabla de partidos
function init5(){
    solicitarDatosListarPartidos("ServicioListarPartidos", "tablaPartidos");
}
//cargar las tablas de fechas

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


//solocitar los datos de fechas

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


//cargar las tablas de fechas

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

//solicitar la lista de fechas

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

//solicitar lista de usuarios

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
//cargar tabla de usuarios
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

//lista de partidos

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

//cargar partidos

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

//dtos votacion partido

function init2() {
    console.log("Mostrando datos para votacion")
    solicitarDatosVotacionPartido("ServicioVP", "votaciones");
}

//solicitar datos votacion partido

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

//tabla votacion partido

function cargarTablaVotacionPartido(tabla, datos) {
    var refTabla = document.getElementById(tabla);
    if (refTabla) {
        for (var i = 0; i < datos.votaciones.length; i++) {
            var nuevaFila = refTabla.insertRow(-1);
            var nuevaCelda;
            nuevaCelda = nuevaFila.insertCell(-1);
            nuevaCelda.innerText = datos.listVP[i].Siglas;
            nuevaCelda = nuevaFila.insertCell(-1);
            nuevaCelda.innerText = datos.listVP[i].Nombre;
            nuevaCelda = nuevaFila.insertCell(-1);
            nuevaCelda.innerText = datos.listVP[i].Candidato;
            nuevaCelda = nuevaFila.insertCell(-1);
        }
    }

}
//a paertir de aqui son los metodos para el XML, del ejemplo compartido por el profe
function init0() {
    actualizarTabla();
}
//carga archivo
function cargarArchivo() {
    var ref = document.getElementById('archivo');
    if (ref) {
        var formData = new FormData();
        formData.append('archivo', ref.files[0]);
        fetch("ServicioCargar", {
            method: 'POST',
            body: formData
        }).then((r) => {
            return r.json;
        }).then((r) => {
            console.log(r);
            actualizarTabla();
        });
    }
}
//actualiza tabla
function actualizarTabla() {
    fetch("ServicioConsulta1").then((r) => {
        return r.json();
    }).then((r) => {
        console.log(r);
        cargarDatos(r);
    });
}
//cargaDatos
function cargarDatos(datos) {
    var ref = document.getElementById('datosUsuarios');
    if (ref) {
        while (ref.rows.length > 0) {
            ref.deleteRow(0);
        }
        datos.forEach(function (valor, indice, arreglo) {
            var nuevaFila = ref.insertRow(-1);
            var nuevaCelda;

            nuevaCelda = nuevaFila.insertCell(-1);
            nuevaCelda.textContent = valor.cedula;
            nuevaCelda = nuevaFila.insertCell(-1);
            nuevaCelda.textContent = valor.apellido1;
            nuevaCelda = nuevaFila.insertCell(-1);
            nuevaCelda.textContent = valor.apellido2;
            nuevaCelda = nuevaFila.insertCell(-1);
            nuevaCelda.textContent = valor.nombre;
            nuevaCelda = nuevaFila.insertCell(-1);
            nuevaCelda.textContent = valor.clave;

            nuevaCelda = nuevaFila.insertCell(-1);
            var chk = '<i class="fas ' + ((valor.activo) ? 'fa-check' : 'fa-ban') + '"></i>';
            nuevaCelda.innerHTML = chk;
            var cls = (valor.activo) ? 'activo' : 'inactivo';
            nuevaCelda.className = cls;
        });
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

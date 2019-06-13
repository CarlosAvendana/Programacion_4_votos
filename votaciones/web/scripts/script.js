function init() {
    console.log("Aplicación inicializada..");
}

function init2(){
    console.log("Mostrando datos para votacion")
    solicitarDatosVotacionPartido("ServicioVotacionPartido","datosVotacion");
}

function solicitarDatosVotacionPartido(origen, tabla){
        fetch(origen).then(
            (resultados) => {
        return resultados.json();
    }
    ).then(
            (datosJSON) => {
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


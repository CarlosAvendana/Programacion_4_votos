
function init() {
    actualizarTabla();
}

function cargarArchivo() {
    var ref = document.getElementById('archivo');
    if (ref) {
        var formData = new FormData();
        formData.append('archivo', ref.files[0]);

        fetch('ServicioCarga', {
            method: 'POST',
            body: formData
        }).then((r) => {
            return r.json();
        }).then((r) => {
            console.log(r);
            actualizarTabla();
        });
    }
}

function actualizarTabla() {
    fetch('ServicioConsulta').then((r) => {
        return r.json();
    }).then((r) => {
        console.log(r);
        cargarDatos(r);
    });
}

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
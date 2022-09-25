//Eliminar//
function eliminarregis(){
Swal
.fire({
        title: "Elimiar Registro",
        text: "¿Estas seguro de eliminar este registro?",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonText: "Sí, eliminar",
        cancelButtonText: "Cancelar",
    })

    .then(resultado => {
        if (resultado.value) {
            // Hicieron click en "Sí"
            title: "Eliminar Registro";
            text: "Se ha eliminado el registro correctamente";
            icon: 'success';
            console.log("*se elimina la venta*");
        } else {
            // Dijeron que no
            console.log("*NO se elimina la venta*");
        }
    });
}

//Editar//
function editarregis(){

Swal
    .fire({
        title: "Actualizar Registro",
        text: "¿Estas seguro de actualizar este registro?",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonText: "Sí, actualizar",
        cancelButtonText: "Cancelar",
    })
    .then(resultado => {
        if (resultado.value) {
            // Hicieron click en "Sí"
            title: "Actualizar Registro";
            text: "Se ha actualizado el registro correctamente";
            icon: 'success';
            console.log("*se elimina la venta*");
        } else {
            // Dijeron que no
            console.log("*NO se elimina la venta*");
        }
    });
}
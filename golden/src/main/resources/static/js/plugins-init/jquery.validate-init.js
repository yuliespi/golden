jQuery(".form-valide", ".login").validate({
    rules: {
        //ACTIVIDAD VALIDACIONES
        "tipoactividad": {
            required: !0,
            minlength: 5
        },
        "fechaactividad": {
            required: !0
        },
        "descripactividad": {
            required: !0,
            minlength: 8
        },

        //BITACORA VALIDACIONES
        "observabita": {
            required: !0,
            minlength: 8
        },
        "cantibita": {
            required: !0,
            minlength: 1
        },
        "fechabita": {
            required: !0
        },
        "selectactiv": {
            required: !0
        },
        "selectimple": {
            required: !0
        },
        "estadobita": {
            required: !0
        },

        //CARGO VALIDACIONES
        "nombrecargo": {
            required: !0,
            minlength: 5
        },
        "descrpcargo": {
            required: !0,
            minlength: 8
        },
        "estadocargo": {
            required: !0
        },

        //CATEGORIA VALIDACIONES
        "ecate": {
            required: !0,
            minlength: 1
        },
        "ccate": {
            required: !0,
            minlength: 1
        },
        "dcate": {
            required: !0,
            minlength: 8
        },
        "escate": {
            required: !0
        },

        //EMPLEADO VALIDACIONES
        "nempleado":{
            required: !0,
            minlength: 5
        },
        "aempleado":{
            required: !0,
            minlength: 5
        },
        "dempleado":{
            required: !0,
            minlength: 5
        },
        "templeado":{
            required: !0,
            minlength: 7
        },
        "selectcargo":{
            required: !0
        },
        "corrempleado":{
            required: !0,
            minlength: 5
        },
        "contraempleado":{
            required: !0,
            minlength: 8
        },
        "esempleado":{
            required: !0
        },

        //IMPLEMENTO VALIDACIONES
        "tiimple":{
            required: !0,
            minlength: 5
        },
        "nimple":{
            required: !0,
            minlength: 5
        },
        "timple":{
            required: !0,
            minlength: 1
        },
        "pimple":{
            required: !0,
            minlength: 1
        },
        "cimple":{
            required: !0,
            minlength: 1
        },
        "fimple":{
            required: !0,
            minlength: 5
        },
        "oimple":{
            required: !0,
            minlength: 8
        },
        "selectcate":{
            required: !0
        },
        "esimple":{
            required: !0
        },

        //VALIDACIONES LOGIN
        "correouser":{
            required: !0
        },
        "tipouser":{
            required: !0
        },
        "contrase??auser":{
            required: !0
        }
    },
    messages: {
        //ACTIVIDAD MENSAJES
        "tipoactividad": {
            required: "Por favor ingrese el tipo de actividad a registrar",
            minlength: "El tipo de actividad debe tener como m??nimo 5 caracteres"
        },
        "fechaactividad": {
            required: "Por favor selecione una fecha no mayor a un mes",
        },
        "descripactividad": {
            required: "Por favor ingrese el la descripci??n de la actividad a registrar",
            minlength: "La descripci??n de la actividad debe tener como m??nimo 8 caracteres"
        },
        
        //BITACORA MENSAJES
        "observabita": {
            required: "Por favor ingrese las observaciones de la bit??cora a registrar",
            minlength: "Las observaciones de la bit??cora debe tener como m??nimo 8 caracteres"
        },
        "cantibita": {
            required: "Por favor ingrese las cantidad de implementos usados para el registro de la bit??cora"
        },
        "fechabita": {
            required: "Por favor seleccione una fecha para el registro de la bit??cora"
        },
        "selectactiv": {
            required: "Por favor seleccione una actividad para el registro de la bit??cora"
        },
        "selectimple": {
            required: "Por favor seleccione uno o m??s tipos de implementos para el registro de la bit??cora"
        },
        "estadobita": {
            required: "Por favor seleccione el estado en el que se encuentra la bit??cora para su registro"
        },

        //CARGO MENSAJES
        "nombrecargo": {
            required: "Por ingrese el nombre del cargo para su registro",
            minlength: "El nombre del cargo debe ser de min??mo 5 caracteres"
        },
        "descrpcargo": {
            required: "Por favor ingrese la descripci??n del cargo para su registro",
            minlength: "La descripci??n del cargo debe ser de min??mo 8 caracteres"
        },
        "estadocargo": {
            required: "Por favor seleccione el estado en el que se encuentra el cargo para su registro"
        },

        //CATEGORIA MENSAJES
        "ecate": {
            required: "Por favor ingrese la edad que se registrara por cat??goria"
        },
        "ccate": {
            required: "Por favor ingrese la cantidad de personas por cat??goria para su registro"
        },
        "dcate": {
            required: "Por favor ingrese la descripci??n de la cat??goria para su registro",
            minlength: "La descripci??n de la cat??goria debe ser de min??mo 8 caracteres"
        },
        "escate": {
            required: "Por favor seleccione el estado en el que se encuentra la cat??goria para su registro"
        },

        //EMPLEADO MENSAJES
        "nempleado":{
            required: "Por favor ingrese el nombre del empleado para su registro",
            minlength: "El nombre del empleado debe ser de min??mo 5 carecteres"
        },
        "aempleado":{
            required: "Por favor ingrese el apellido del empleado para su registro",
            minlength: "El apellido del empleado debe ser de min??mo 5 carecteres"
        },
        "dempleado":{
            required: "Por favor ingrese la direcci??n del emplado para su registro",
            minlength: "La direcci??n del empleado debe ser de min??mo 5 carecteres"
        },
        "templeado":{
            required: "Por favor ingrese el tel??fono del empleado para su registro",
            minlength: "El tel??fono del empleado debe ser de min??mo 7 n??meros"
        },
        "selectcargo":{
            required: "Por favor seleccione el cargo el cual se le asignara al empleado"
        },
        "corrempleado":{
            required: "Por favor ingrese el correo del empleado para su registro",
            minlength: "El correo del empleado debe ser de min??mo 5 caracteres"
        },
        "contraempleado":{
            required: "Por favor ingrese la contrase??a del empleado para su registro",
            minlength: "La contrase??a del empleado debe ser de min??mo 8 caracteres"
        },
        "esempleado":{
            required: "Por favor seleccione el estado en el que se encuentra el empleado para su registro"
        },

        //IMPLEMENTO MENSAJES
        "tiimple":{
            required: "Por favor ingrese el tipo de implemento para su registro",
            minlength: "El tipo de implemento debe ser de min??mo 5 carecteres"
        },
        "nimple":{
            required: "Por favor ingrese el nombre de implemento para su registro",
            minlength: "El nombre del implemento debe ser de min??mo 5 carecteres"
        },
        "timple":{
            required: "Por favor ingrese el tama??o de implemento para su registro"
        },
        "pimple":{
            required: "Por favor ingrese el peso de implemento para su registro"
        },
        "cimple":{
            required: "Por favor ingrese ela cantidad de implementos para su registro"
        },
        "fimple":{
            required: "Por favor ingrese la funci??n del implemento para su registro",
            minlength: "La funci??n del implemento debe ser de min??mo 5 carecteres"
        },
        "oimple":{
            required: "Por favor ingrese las observaciones del implemento para su registro",
            minlength: "Las observaciones del implemento debe ser de min??mo 8 carecteres"
        },
        "selectcate":{
            required: "Por favor seleccione el la descripci??n de la cat??goria para el registro del implemento"
        },
        "esimple":{
            required: "Por favor seleccione el estado en el que se encuentra el implemento para su registro"
        },
        
        //MENSAJES LOGIN
        "correouser":{
            required: "Por favor digite su correo electron??co para el logueo"
        },
        "tipouser":{
            required: "Por favor seleccione un tipo de rol para el logueo"
        },
        "contrase??auser":{
            required: "Por favor digite su contrae??a para el logueo"
        }
    },

    ignore: [],
    errorClass: "invalid-feedback animated fadeInUp",
    errorElement: "div",
    errorPlacement: function(e, a) {
        jQuery(a).parents(".form-group > div").append(e)
    },
    highlight: function(e) {
        jQuery(e).closest(".form-group").removeClass("is-invalid").addClass("is-invalid")
    },
    success: function(e) {
        jQuery(e).closest(".form-group").removeClass("is-invalid"), jQuery(e).remove()
    },
});


jQuery(".form-valide-with-icon").validate({
    rules: {
        //ACTIVIDAD VALIDACIONES
        "tipoactividad": {
            required: !0,
            minlength: 5
        },
        "fechaactividad": {
            required: !0
        },
        "descripactividad": {
            required: !0,
            minlength: 8
        },

        //BITACORA VALIDACIONES
        "observabita": {
            required: !0,
            minlength: 8
        },
        "cantibita": {
            required: !0,
            minlength: 1
        },
        "fechabita": {
            required: !0
        },
        "selectactiv": {
            required: !0
        },
        "selectimple": {
            required: !0
        },
        "estadobita": {
            required: !0
        },

        //CARGO VALIDACIONES
        "nombrecargo": {
            required: !0,
            minlength: 5
        },
        "descrpcargo": {
            required: !0,
            minlength: 8
        },
        "estadocargo": {
            required: !0
        },

        //CATEGORIA VALIDACIONES
        "ecate": {
            required: !0,
            minlength: 1
        },
        "ccate": {
            required: !0,
            minlength: 1
        },
        "dcate": {
            required: !0,
            minlength: 8
        },
        "escate": {
            required: !0
        },

        //EMPLEADO VALIDACIONES
        "nempleado":{
            required: !0,
            minlength: 5
        },
        "aempleado":{
            required: !0,
            minlength: 5
        },
        "dempleado":{
            required: !0,
            minlength: 5
        },
        "templeado":{
            required: !0,
            minlength: 7
        },
        "corrempleado":{
            required: !0,
            minlength: 5
        },
        "contraempleado":{
            required: !0,
            minlength: 8
        },
        "selectcargo":{
            required: !0
        },
        "esempleado":{
            required: !0
        },

        //IMPLEMENTO VALIDACIONES
        "tiimple":{
            required: !0,
            minlength: 5
        },
        "nimple":{
            required: !0,
            minlength: 5
        },
        "timple":{
            required: !0,
            minlength: 1
        },
        "pimple":{
            required: !0,
            minlength: 1
        },
        "cimple":{
            required: !0,
            minlength: 1
        },
        "fimple":{
            required: !0,
            minlength: 5
        },
        "oimple":{
            required: !0,
            minlength: 8
        },
        "selectcate":{
            required: !0
        },
        "esimple":{
            required: !0
        },

        //VALIDACIONES LOGIN
        "correouser":{
            required: !0
        },
        "tipouser":{
            required: !0
        },
        "contrase??auser":{
            required: !0
        }
    },
    messages: {
        //ACTIVIDAD MENSAJES
        "tipoactividad": {
            required: "Por favor ingrese el tipo de actividad a registrar",
            minlength: "El tipo de actividad debe tener como m??nimo 5 caracteres"
        },
        "fechaactividad": {
            required: "Por favor selecione una fecha no mayor a un mes",
        },
        "descripactividad": {
            required: "Por favor ingrese el la descripci??n de la actividad a registrar",
            minlength: "La descripci??n de la actividad debe tener como m??nimo 8 caracteres"
        },
        
        //BITACORA MENSAJES
        "observabita": {
            required: "Por favor ingrese las observaciones de la bit??cora a registrar",
            minlength: "Las observaciones de la bit??cora debe tener como m??nimo 8 caracteres"
        },
        "cantibita": {
            required: "Por favor ingrese las cantidad de implementos usados para el registro de la bit??cora"
        },
        "fechabita": {
            required: "Por favor seleccione una fecha para el registro de la bit??cora"
        },
        "selectactiv": {
            required: "Por favor seleccione una actividad para el registro de la bit??cora"
        },
        "selectimple": {
            required: "Por favor seleccione uno o m??s tipos de implementos para el registro de la bit??cora"
        },
        "estadobita": {
            required: "Por favor seleccione el estado en el que se encuentra la bit??cora para su registro"
        },

        //CARGO MENSAJES
        "nombrecargo": {
            required: "Por ingrese el nombre del cargo para su registro",
            minlength: "El nombre del cargo debe ser de min??mo 5 caracteres"
        },
        "descrpcargo": {
            required: "Por favor ingrese la descripci??n del cargo para su registro",
            minlength: "La descripci??n del cargo debe ser de min??mo 8 caracteres"
        },
        "estadocargo": {
            required: "Por favor seleccione el estado en el que se encuentra el cargo para su registro"
        },

        //CATEGORIA MENSAJES
        "ecate": {
            required: "Por favor ingrese la edad que se registrara por cat??goria"
        },
        "ccate": {
            required: "Por favor ingrese la cantidad de personas por cat??goria para su registro"
        },
        "dcate": {
            required: "Por favor ingrese la descripci??n de la cat??goria para su registro",
            minlength: "La descripci??n de la cat??goria debe ser de min??mo 8 caracteres"
        },
        "escate": {
            required: "Por favor seleccione el estado en el que se encuentra la cat??goria para su registro"
        },

        //EMPLEADO MENSAJES
        "nempleado":{
            required: "Por favor ingrese el nombre del empleado para su registro",
            minlength: "El nombre del empleado debe ser de min??mo 5 carecteres"
        },
        "aempleado":{
            required: "Por favor ingrese el apellido del empleado para su registro",
            minlength: "El apellido del empleado debe ser de min??mo 5 carecteres"
        },
        "dempleado":{
            required: "Por favor ingrese la direcci??n del emplado para su registro",
            minlength: "La direcci??n del empleado debe ser de min??mo 5 carecteres"
        },
        "templeado":{
            required: "Por favor ingrese el tel??fono del empleado para su registro",
            minlength: "El tel??fono del empleado debe ser de min??mo 7 n??meros"
        },
        "selectcargo":{
            required: "Por favor seleccione el cargo el cual se le asignara al empleado"
        },
        "corrempleado":{
            required: "Por favor ingrese el correo del empleado para su registro",
            minlength: "El correo del empleado debe ser de min??mo 5 caracteres"
        },
        "contraempleado":{
            required: "Por favor ingrese la contrase??a del empleado para su registro",
            minlength: "La contrase??a del empleado debe ser de min??mo 8 caracteres"
        },
        "esempleado":{
            required: "Por favor seleccione el estado en el que se encuentra el empleado para su registro"
        },

        //IMPLEMENTO MENSAJES
        "tiimple":{
            required: "Por favor ingrese el tipo de implemento para su registro",
            minlength: "El tipo de implemento debe ser de min??mo 5 carecteres"
        },
        "nimple":{
            required: "Por favor ingrese el nombre de implemento para su registro",
            minlength: "El nombre del implemento debe ser de min??mo 5 carecteres"
        },
        "timple":{
            required: "Por favor ingrese el tama??o de implemento para su registro"
        },
        "pimple":{
            required: "Por favor ingrese el peso de implemento para su registro"
        },
        "cimple":{
            required: "Por favor ingrese ela cantidad de implementos para su registro"
        },
        "fimple":{
            required: "Por favor ingrese la funci??n del implemento para su registro",
            minlength: "La funci??n del implemento debe ser de min??mo 5 carecteres"
        },
        "oimple":{
            required: "Por favor ingrese las observaciones del implemento para su registro",
            minlength: "Las observaciones del implemento debe ser de min??mo 8 carecteres"
        },
        "selectcate":{
            required: "Por favor seleccione el la descripci??n de la cat??goria para el registro del implemento"
        },
        "esimple":{
            required: "Por favor seleccione el estado en el que se encuentra el implemento para su registro"
        },

        //MENSAJES LOGIN
        "correouser":{
            required: "Por favor digite su correo electron??co para el logueo"
        },
        "tipouser":{
            required: "Por favor seleccione un tipo de rol para el logueo"
        },
        "contrase??auser":{
            required: "Por favor digite su contrae??a para el logueo"
        }
        
    },

    ignore: [],
    errorClass: "invalid-feedback animated fadeInUp",
    errorElement: "div",
    errorPlacement: function(e, a) {
        jQuery(a).parents(".form-group > div").append(e)
    },
    highlight: function(e) {
        jQuery(e).closest(".form-group").removeClass("is-invalid").addClass("is-invalid")
    },
    success: function(e) {
        jQuery(e).closest(".form-group").removeClass("is-invalid").addClass("is-valid")
    }




});
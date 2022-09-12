package goldenlions.golden.Controllers.Empleado;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import goldenlions.golden.Models.Empleado.Empleado;
import goldenlions.golden.Service.Empleado.IEmpleadoService;
import jakarta.validation.Valid;


@Controller
@RequestMapping("/empleado")
@SessionAttributes("empleado")

public class EmpleadoController {

    @Autowired
    private IEmpleadoService empleadog;


    @GetMapping(path={"/listas"})
    public String listar(Model a){
    a.addAttribute("empleados", empleadog.findAll());
        return "views/empleados/listas";
    }

    @GetMapping("/form")     
    public String form(Model a){
    Empleado empleado=new Empleado();
    a.addAttribute("empleado", empleado);
        return "views/empleados/form";
    }
        
    @PostMapping("/add")
    public String add(@Valid Empleado empleado,BindingResult res, Model a,SessionStatus status){
    if(res.hasErrors()){
        return "views/empleados/form";
    }   
    empleadog.save(empleado);
    status.setComplete();
        return "redirect:listas";
    }  

    @GetMapping("/deleteE/{idEmpleado}")
    public String deleteE(@PathVariable Integer idEmpleado) {
        if(idEmpleado > 0){
            empleadog.delete(idEmpleado);
        }
        return "redirect:../listas";
    }

    @GetMapping("/actualizarE/{idEmpleado}")
    public String actualizarE(@PathVariable Integer idEmpleado,Model a){
        Empleado empleado=null;
        if(idEmpleado>0){
            empleado=empleadog.findOne(idEmpleado);
        }else{
            return "redirect:listas";
        }
        a.addAttribute("empleado" ,empleado);
        a.addAttribute("accion", "Actualizar el empleado");
        return "views/empleados/form";
    }    
}
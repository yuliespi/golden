package golden.golden.Controllers.Empleado;

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

import golden.golden.Models.Empleado.Empleado;
import golden.golden.Service.Cargo.ICargoService;
import golden.golden.Service.Empleado.IEmpleadoService;
import javax.validation.Valid;


@Controller
@RequestMapping("/empleado")
@SessionAttributes("empleado")

public class EmpleadoController {

    @Autowired
    private IEmpleadoService empleadog;

    @Autowired
    private ICargoService cargog;

    @GetMapping(path={"/tablaE"})
    public String listar(Model a){
    a.addAttribute("empleados", empleadog.findAll());
        return "views/Empleado/tableE";
    }

    @GetMapping("/formE")     
    public String form(Model a){
    Empleado empleado=new Empleado();
    a.addAttribute("empleado", empleado);
        return "views/Empleado/formE";
    }
        
    @PostMapping("/add")
    public String add(@Valid Empleado empleado,BindingResult res, Model a,SessionStatus status){
    if(res.hasErrors()){
        return "views/Empleado/formE";
    }   
    empleadog.save(empleado);
    status.setComplete();
        return "redirect:tablaE";
    }  

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        if(id > 0){
            empleadog.delete(id);
        }
        return "redirect:../tablaE";
    }

    @GetMapping("/actualizarE/{id}")
    public String actualizarE(@PathVariable Integer id,Model a){
        Empleado empleado=null;
        if(id>0){
            a.addAttribute("cargo", cargog.findAll());
            empleado=empleadog.findOne(id);
        }else{
            return "redirect:tablaE";
        }
        a.addAttribute("cargo", cargog.findAll());
        a.addAttribute("empleado" ,empleado);
        a.addAttribute("accion", "Actualizar el empleado");
        return "views/Empleado/formE";
    }    

    @GetMapping("/estado/{id}")
    public String estado(@PathVariable Integer id){
        Empleado empleado=new Empleado();
        empleado=empleadog.findOne(id);
        if(empleado.getEstadoEmpleado()==true){
            empleado.setEstadoEmpleado(false);
        }else if (empleado.getEstadoEmpleado()==false){
            empleado.setEstadoEmpleado(true);
        }
        empleadog.save(empleado);
        return "redirect:../listas";
    }

    @RequestMapping("/**")
    public String handleError() {
        return "/error404";
}
}
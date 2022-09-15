package goldenlions.golden.Controllers.Actividad;

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

import goldenlions.golden.Models.Actividad.Actividad;
import goldenlions.golden.Service.Actividad.IActividadService;
import jakarta.validation.Valid;



@Controller
@RequestMapping("/actividad")
@SessionAttributes("actividad")

public class ActividadController {

    @Autowired
    private IActividadService actividadg;


    @GetMapping(path={"/listas"})
    public String listar(Model a){
        a.addAttribute("actividad", new Actividad());
    a.addAttribute("actividades", actividadg.findAll());
        return "views/actividades/listas";
    }

    @GetMapping("/form")     
    public String form(Model a){
    Actividad actividad=new Actividad();
    a.addAttribute("actividad", actividad);
        return "views/actividades/form";
    }
        
    @PostMapping("/add")
    public String add(@Valid Actividad actividad,BindingResult res, Model a,SessionStatus status){
    if(res.hasErrors()){
        return "views/actividades/form";
    }   
    actividadg.save(actividad);
    status.setComplete();
        return "redirect:listas";
    }  

    @GetMapping("/deleteA/{id}")
    public String deleteA(@PathVariable Integer id) {
        if(id > 0){
            actividadg.delete(id);
        }

        return "redirect:../listas";
    }

    @GetMapping("/actualizarA/{id}")
    public String actualizarA(@PathVariable Integer id,Model a){
        Actividad actividad=null;
        if(id>0){
            actividad=actividadg.findOne(id);
        }else{
            return "redirect:listas";
        }
        a.addAttribute("actividad" ,actividad);
        a.addAttribute("accion", "Actualizar la actividad");
        return "views/actividades/form";
    }  
}
package goldenlions.golden.Controllers.Bitacora;

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

import goldenlions.golden.Models.Bitacora.Bitacora;
import goldenlions.golden.Service.Actividad.IActividadService;
import goldenlions.golden.Service.Bitacora.IBitacoraService;
import goldenlions.golden.Service.Implemento.IImplementoService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/bitacora")
@SessionAttributes("bitacora")

public class BitacoraController{

    @Autowired
    private IActividadService bactividad;

    @Autowired
    private IImplementoService bimplemento;

    @Autowired
    private IBitacoraService bitacorag;

    @GetMapping(path={"/listas"})
    public String listar(Model b){
    b.addAttribute("bitacoras", bitacorag.findAll());
    b.addAttribute("actividad", bactividad.findAll());
    b.addAttribute("implemento", bimplemento.findAll());
        return "views/bitacoras/listas";
    }

    @GetMapping("/form")     
    public String form(Model b){
    Bitacora bitacora=new Bitacora();
    b.addAttribute("bitacora", bitacora);
    b.addAttribute("actividad",bactividad.findAll());
    b.addAttribute("implemento",bimplemento.findAll());
        return "views/bitacoras/form";
    }
        
    @PostMapping("/add")
    public String add(@Valid Bitacora bitacora,BindingResult res, Model b,SessionStatus status){
    if(res.hasErrors()){
        b.addAttribute("actividad",bactividad.findAll());
        b.addAttribute("implemento",bimplemento.findAll());
        return "views/bitacoras/form";
    }   
    bitacorag.save(bitacora);
    status.setComplete();
        return "redirect:listas";
    }  
    
    @GetMapping("/actualizarB/{id}")
    public String actualizarB(@PathVariable Integer id,Model b){
        Bitacora bitacora=null;
        if(id>0){
            b.addAttribute("actividad",bactividad.findAll());
            b.addAttribute("implemento",bimplemento.findAll());
            bitacora=bitacorag.findOne(id);
        }else{
            return "views/bitacoras/form";
        }
        b.addAttribute("actividad",bactividad.findAll());
        b.addAttribute("bitacora" ,bitacora);
        b.addAttribute("accion", "Actualizar bitacora");
        return "views/bitacoras/form";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
    
        if(id > 0){
            bitacorag.delete(id);
        }
        return "redirect:../listas";
    }
}
package goldenlions.golden.Controllers.Implemento;

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

import goldenlions.golden.Models.Implemento.Implemento;
import goldenlions.golden.Service.Implemento.IImplementoService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/implemento")
@SessionAttributes("implemeto")
public class ImplementoController {

    @Autowired
    private IImplementoService implementog;

    @GetMapping(path={"/listas"})
    public String listar(Model i){
    i.addAttribute("implementos", implementog.findAll());
        return "views/implementos/listas";
    }

    @GetMapping("/form")     
    public String form(Model i){
    Implemento implemento=new Implemento();
    i.addAttribute("implemento", implemento);
        return "views/implementos/form";
    }

    @PostMapping("/add")
    public String add(@Valid Implemento implemento,BindingResult res, Model i,SessionStatus status){
    if(res.hasErrors()){
        return "views/implementos/form";
    }   
    implementog.save(implemento);
    status.setComplete();
        return "redirect:listas";
    } 
    
    @GetMapping("/actualizarI/{id}")
    public String actualizarI(@PathVariable Integer id,Model i){
        Implemento implemento=null;
        if(id>0){
            implemento=implementog.findOne(id);
        }else{
            return "views/implementos/form";
        }
        i.addAttribute("implemento" ,implemento);
        i.addAttribute("accion", "Actualizar implemento");
        return "views/implementos/form";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
    
        if(id > 0){
            implementog.delete(id);
        }
        return "redirect:../listas";
    }
}
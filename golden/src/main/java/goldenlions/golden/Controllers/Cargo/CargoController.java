package goldenlions.golden.Controllers.Cargo;

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

import goldenlions.golden.Models.Cargo.Cargo;
import goldenlions.golden.Service.Cargo.ICargoService;
import jakarta.validation.Valid;


@Controller
@RequestMapping("/cargo")
@SessionAttributes("cargo")

public class CargoController {

    @Autowired
    private ICargoService cargog;

    @GetMapping(path={"/tablaC"})
    public String listar(Model c){
    c.addAttribute("cargos", cargog.findAll());
    c.addAttribute("cargo",cargog.findAll());
        return "views/Cargo/tableCA";
    }

    @GetMapping("/formC")     
    public String form(Model c){
    Cargo cargo=new Cargo();
    c.addAttribute("cargo", cargo);
        return "views/Cargo/formCA";
    }
        
    @PostMapping("/add")
    public String add(@Valid Cargo cargo,BindingResult res, Model c,SessionStatus status){
    if(res.hasErrors()){
        return "views/Cargo/formC";
    }   
    cargog.save(cargo);
    status.setComplete();
        return "redirect:tablaC";
    }  
    
    @GetMapping("/actualizarC/{id}")
    public String actualizarC(@PathVariable Integer id,Model c){
        Cargo cargo=null;
        if(id>0){
            cargo=cargog.findOne(id);
        }else{
            return "redirect:tablaC";
        }
        c.addAttribute("cargo" ,cargo);
        c.addAttribute("accion", "Actualizar el cargo");
        return "views/Cargo/formC";
    }   

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
    
        if(id > 0){
            cargog.delete(id);
        }
        return "redirect:../tablaC";
    }
}
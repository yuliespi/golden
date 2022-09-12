package goldenlions.golden.Controllers.Categoria;

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

import goldenlions.golden.Models.Categoria.Categoria;
import goldenlions.golden.Service.Categoria.ICategoriaService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/categoria")
@SessionAttributes("categoria")
public class CategoriaController {

    @Autowired
    private ICategoriaService categoriag;

    @GetMapping(path={"/listas"})
    public String listar(Model c){
    c.addAttribute("categorias", categoriag.findAll());
        return "views/categorias/listas";
    }
    
    @GetMapping("/form")     
    public String form(Model c){
    Categoria categoria=new Categoria();
    c.addAttribute("categoria", categoria);
        return "views/categorias/form";
    }

    @PostMapping("/add")
    public String add(@Valid Categoria categoria,BindingResult res, Model c,SessionStatus status){
    if(res.hasErrors()){
        return "views/categorias/form";
    }   
    categoriag.save(categoria);
    status.setComplete();
        return "redirect:listas";
    } 

    @GetMapping("/actualizarC/{idCategoria}")
    public String actualizarC(@PathVariable Integer idCategoria,Model c){
        Categoria categoria=null;
        if(idCategoria>0){
            categoria=categoriag.findOne(idCategoria);
        }else{
            return "views/categorias/form";
        }
        c.addAttribute("categoria" ,categoria);
        c.addAttribute("accion", "Actualizar categoria");
        return "views/categorias/form";
    }

    @GetMapping("/delete/{idCategoria}")
    public String delete(@PathVariable Integer idCategoria){
    
        if(idCategoria > 0){
            categoriag.delete(idCategoria);
        }
        return "redirect:../listas";
    }
}

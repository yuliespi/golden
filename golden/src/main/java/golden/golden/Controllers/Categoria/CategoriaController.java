package golden.golden.Controllers.Categoria;

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

import golden.golden.Models.Categoria.Categoria;
import golden.golden.Service.Categoria.ICategoriaService;
import javax.validation.Valid;

@Controller
@RequestMapping("/categoria")
@SessionAttributes("categoria")
public class CategoriaController {

    @Autowired
    private ICategoriaService categoriag;

    @GetMapping(path={"/tablaCT"})
    public String listar(Model c){
    c.addAttribute("categorias", categoriag.findAll());
        return "views/Categoria/tableCT";
    }
    
    @GetMapping("/formCT")     
    public String form(Model c){
    Categoria categoria=new Categoria();
    c.addAttribute("categoria", categoria);
        return "views/Categoria/formCT";
    }

    @PostMapping("/add")
    public String add(@Valid Categoria categoria,BindingResult res, Model c,SessionStatus status){
    if(res.hasErrors()){
        return "views/Categoria/formCT";
    }   
    categoriag.save(categoria);
    status.setComplete();
        return "redirect:tablaCT";
    } 

    @GetMapping("/actualizarC/{id}")
    public String actualizarC(@PathVariable Integer id,Model c){
        Categoria categoria=null;
        if(id>0){
            categoria=categoriag.findOne(id);
        }else{
            return "views/Categoria/formCT";
        }
        c.addAttribute("categoria" ,categoria);
        c.addAttribute("accion", "Actualizar categoria");
        return "views/Categoria/formCT";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
    
        if(id > 0){
            categoriag.delete(id);
        }
        return "redirect:../tablaCT";
    }

    @GetMapping("/estado/{id}")
    public String estado(@PathVariable Integer id){
        Categoria categoria=new Categoria();
        categoria=categoriag.findOne(id);
        if(categoria.getEstadoCategoria()==true){
            categoria.setEstadoCategoria(false);
        }else if (categoria.getEstadoCategoria()==false){
            categoria.setEstadoCategoria(true);
        }
        categoriag.save(categoria);
        return "redirect:../tablaCT";
    }

    @RequestMapping("/**")
    public String handleError() {
        return "/error404";
    }
}
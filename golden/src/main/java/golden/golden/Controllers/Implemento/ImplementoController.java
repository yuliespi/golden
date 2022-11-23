package golden.golden.Controllers.Implemento;

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

import golden.golden.Models.Implemento.Implemento;
import golden.golden.Service.Implemento.IImplementoService;
import golden.golden.Service.Categoria.ICategoriaService;
import javax.validation.Valid;

@Controller
@RequestMapping("/implemento")
@SessionAttributes("implemeto")
public class ImplementoController {

    @Autowired
    private IImplementoService implementog;

    @Autowired
    private ICategoriaService categoria;

    @GetMapping(path = { "/tablaI" })
    public String listar(Model i) {
        i.addAttribute("implementos", implementog.findAll());
        i.addAttribute("categoria", categoria.findAll());
        return "views/Implemento/tableI";
    }

    @GetMapping("/formI")
    public String form(Model i) {
        Implemento implemento = new Implemento();
        i.addAttribute("implemento", implemento);
        i.addAttribute("categoria", categoria.findAll());
        return "views/Implemento/formI";
    }

    @PostMapping("/add")
    public String add(@Valid Implemento implemento, BindingResult res, Model i, SessionStatus status) {
        String mensaje = implementog.dublicado(implemento);
        if (mensaje != null) {
            i.addAttribute("categoria", categoria.findAll());
            i.addAttribute("implemento", implemento);
            i.addAttribute("duplicado", mensaje);
            return "views/Implemento/formI";
        }
        if (res.hasErrors()) {
            i.addAttribute("categoria", categoria.findAll());
            i.addAttribute("implemento", implemento);
            return "views/Implemento/formI";
        }
        implementog.save(implemento);
        status.setComplete();
        return "redirect:tablaI";
    }

    @GetMapping("/actualizarI/{id}")
    public String actualizarI(@PathVariable Integer id, Model i) {
        Implemento implemento = null;
        if (id > 0) {
            i.addAttribute("categoria", categoria.findAll());
            implemento = implementog.findOne(id);
        } else {
            return "views/Implementos/formI";
        }
        i.addAttribute("implemento", implemento);
        i.addAttribute("accion", "Actualizar implemento");
        return "views/Implemento/formI";
    }

    @GetMapping("/estado/{id}")
    public String estado(@PathVariable Integer id){
        Implemento implemento=new Implemento();
        implemento=implementog.findOne(id);
        if(implemento.getEstadoImplemento()==true){
            implemento.setEstadoImplemento(false);
        }else if (implemento.getEstadoImplemento()==false){
            implemento.setEstadoImplemento(true);
        }
        implementog.save(implemento);
        return "redirect:../tablaI";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {

        if (id > 0) {
            implementog.delete(id);
        }
        return "redirect:../tablaI";
    }
}
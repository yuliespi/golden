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
import golden.golden.Models.Rol.Roles;
import golden.golden.Service.Empleado.IEmpleadoService;
import golden.golden.Service.Rol.RolServiceImpl;

import java.util.List;

import javax.validation.Valid;

@Controller
@RequestMapping("/empleado")
@SessionAttributes("empleado")

public class EmpleadoController {

    @Autowired
    private IEmpleadoService empleadog;

    @Autowired
    private RolServiceImpl roles;

    @GetMapping(path = { "/tablaE" })
    public String listar(Model a) {
        a.addAttribute("empleados", empleadog.findAll());
        return "views/Empleado/tableE";
    }

    @GetMapping("/formE")
    public String form(Model a) {
        Empleado empleado = new Empleado();
        List<Roles> listaRoles = (List<Roles>) roles.findAll();

        if (listaRoles.size() > 0) {
            a.addAttribute("roles", listaRoles);
        }
        a.addAttribute("roles", listaRoles);
        a.addAttribute("empleado", empleado);
        return "views/Empleado/formE";
    }

    @PostMapping("/add")
    public String add(@Valid Empleado empleado, BindingResult res, Model a, SessionStatus status) {
        Empleado duplicado = empleadog.findByExistCorreoEmpleado(empleado.getCorreoEmpleado());
        if (duplicado != null) {
            a.addAttribute("duplicado", "El correo " + duplicado.getCorreoEmpleado() + " ya esta registrado");
            a.addAttribute("mensaje", "Usuario duplicado");
            List<Roles> listaRoles = (List<Roles>) roles.findAll();
            a.addAttribute("roles", listaRoles);
            return "views/Empleado/formE";
        }
        if (res.hasErrors()) {
            List<Roles> listaRoles = (List<Roles>) roles.findAll();
            a.addAttribute("roles", listaRoles);
            return "views/Empleado/formE";
        }
        empleadog.save(empleado);
        status.setComplete();
        return "redirect:tablaE";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        if (id > 0) {
            empleadog.delete(id);
        }
        return "redirect:../tablaE";
    }

    @GetMapping("/actualizarE/{id}")
    public String actualizarE(@PathVariable Integer id, Model a) {
        Empleado empleado = null;
        if (id > 0) {
            empleado = empleadog.findOne(id);
        } else {
            return "redirect:tablaE";
        }
        a.addAttribute("empleado", empleado);
        a.addAttribute("accion", "Actualizar el empleado");
        return "views/Empleado/formE";
    }

    @GetMapping("/estado/{id}")
    public String estado(@PathVariable Integer id) {
        Empleado empleado = new Empleado();
        empleado = empleadog.findOne(id);
        if (empleado.getEstadoEmpleado() == true) {
            empleado.setEstadoEmpleado(false);
        } else if (empleado.getEstadoEmpleado() == false) {
            empleado.setEstadoEmpleado(true);
        }
        empleadog.save(empleado);
        return "redirect:../tablaE";
    }

    @RequestMapping("/**")
    public String handleError() {
        return "/error404";
    }
}
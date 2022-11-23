package golden.golden.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import golden.golden.Models.Empleado.Empleado;

@Controller
public class LoginControllers {

    @GetMapping(path = {"/login"})
    public String login(Model b){
        b.addAttribute("empleado", new Empleado());
        return "login";
    }
}
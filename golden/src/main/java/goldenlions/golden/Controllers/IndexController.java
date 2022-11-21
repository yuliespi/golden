package goldenlions.golden.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {


    @GetMapping(path = {"/index"})
    public String index(Model b){
        return "index";
    }

    @GetMapping(path = {"/login"})
    public String login(Model b){
        return "login";
    }

    @GetMapping(path = {"/menu"})
    public String menu(Model b){
        return "menuu";
    }

    @GetMapping(path = {"/calendario"})
    public String calendario(Model b){
        return "calendario";
    }

    @GetMapping(path = {"/configuracion"})
    public String configuracion(Model b){
        return "configuracion";
    }
}
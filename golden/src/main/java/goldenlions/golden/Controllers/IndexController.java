package goldenlions.golden.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {


    @GetMapping(path = {"/index","/home"})
    public String index(Model b){
        return "index";
    }

    @GetMapping(path = {"/","","/login"})
    public String login(Model b){
        return "login";
    }

}
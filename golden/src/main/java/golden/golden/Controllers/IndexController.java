package golden.golden.Controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import golden.golden.Models.Empleado.Empleado;
import golden.golden.Models.Empleado.IEmpleado;

@Controller
public class IndexController {

    @Autowired 
    private IEmpleado empleadoService;

    @GetMapping("/menu")
    public String menu(Authentication auth, HttpSession session){
        
    String email = auth.getName();

        if(session.getAttribute("empleado") == null){
            Empleado empleado = empleadoService.findByCorreoEmpleado(email);
            empleado.setContrasenaEmpleado(null);
            session.setAttribute("empleado", empleado);
        }
        
        return "menu";
    }

    @GetMapping(path = {"/","","/index"})
    public String index(Model b){
        return "index";
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
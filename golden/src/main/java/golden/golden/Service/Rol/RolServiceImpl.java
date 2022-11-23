package golden.golden.Service.Rol;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import golden.golden.Models.Rol.IRol;
import golden.golden.Models.Rol.Roles;

@Service
public class RolServiceImpl implements IRolService {

    @Autowired
    private IRol rol;

    @Override
    public List<Roles>findAll(){
        return (List <Roles>)rol.findAll();
    }
}
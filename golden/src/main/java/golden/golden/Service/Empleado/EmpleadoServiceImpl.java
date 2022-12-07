package golden.golden.Service.Empleado;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import golden.golden.Models.Empleado.Empleado;
import golden.golden.Models.Empleado.IEmpleado;

@Service
public class EmpleadoServiceImpl implements IEmpleadoService {
    
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    
    @Autowired
    private IEmpleado empleadog;
    
    @Override
    public List <Empleado> findAll(){
        return(List<Empleado>)empleadog.findAll();
    }

    @Override
    public Empleado findOne(Integer idEmpleado){
        return empleadog.findById(idEmpleado).orElse(null);
    }

    @Override
    public void save(Empleado empleado){
        empleadog.save(empleado);
    }
    
    @Override
    public void delete (Integer id){
        empleadog.deleteById(id);
    }
    
    @Override
    public Empleado findByExistCorreoEmpleado(String correo) {
        return empleadog.findByCorreoEmpleado(correo);
    }

    @Override
    public Empleado registrar(Empleado empleado) {
        empleado.setContrasenaEmpleado(passwordEncoder.encode(empleado.getContrasenaEmpleado()));
        return empleadog.save(empleado);
    }
}
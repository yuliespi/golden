package goldenlions.golden.Service.Empleado;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import goldenlions.golden.Models.Empleado.Empleado;
import goldenlions.golden.Models.Empleado.IEmpleado;

@Service
public class EmpleadoServiceImpl implements IEmpleadoService {
    
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
    
}

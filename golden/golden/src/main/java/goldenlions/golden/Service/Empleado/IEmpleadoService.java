package goldenlions.golden.Service.Empleado;

import java.util.List;

import goldenlions.golden.Models.Empleado.Empleado;

public interface IEmpleadoService {
    public List <Empleado> findAll();
    public void save (Empleado empleado);
    public Empleado findOne (Integer id);
    public void delete (Integer id); 
}

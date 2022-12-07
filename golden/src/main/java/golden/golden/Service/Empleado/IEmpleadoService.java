package golden.golden.Service.Empleado;

import java.util.List;

import golden.golden.Models.Empleado.Empleado;

public interface IEmpleadoService {
    public List <Empleado> findAll();
    public void save (Empleado empleado);
    public Empleado findOne (Integer id);
    public void delete (Integer id); 
    public Empleado registrar(Empleado emple);
    public Empleado findByExistCorreoEmpleado(String correo);
}

package golden.golden.Models.Empleado;

import org.springframework.data.repository.CrudRepository;

public interface IEmpleado extends CrudRepository<Empleado,Integer>{

    Empleado findByCorreoEmpleado(String correoEmpleado);
}

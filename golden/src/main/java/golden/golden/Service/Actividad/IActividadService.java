package golden.golden.Service.Actividad;

import java.util.List;

import golden.golden.Models.Actividad.Actividad;

public interface IActividadService {

    public List <Actividad> findAll();
    public void save (Actividad actividad);
    public Actividad findOne (Integer id);
    public void delete (Integer id); 
    
}

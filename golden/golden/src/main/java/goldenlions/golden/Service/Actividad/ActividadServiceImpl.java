package goldenlions.golden.Service.Actividad;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import goldenlions.golden.Models.Actividad.Actividad;
import goldenlions.golden.Models.Actividad.IActividad;


@Service 

public class ActividadServiceImpl implements IActividadService{
    @Autowired
    private IActividad actividadg;
    
    @Override
    public List <Actividad> findAll(){
        return(List<Actividad>)actividadg.findAll();
    }

    @Override
    public Actividad findOne(Integer idActividad){
        return actividadg.findById(idActividad).orElse(null);
    }

    @Override
    public void save(Actividad actividad){
        actividadg.save(actividad);
    }
    
    @Override
    public void delete (Integer id){
        actividadg.deleteById(id);
    }
}

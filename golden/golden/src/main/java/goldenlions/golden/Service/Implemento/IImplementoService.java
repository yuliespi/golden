package goldenlions.golden.Service.Implemento;

import java.util.List;

import goldenlions.golden.Models.Implemento.Implemento;

public interface IImplementoService {
    
    public List <Implemento> findAll();
    public void save (Implemento implemento);
    public Implemento findOne (Integer id);
    public void delete (Integer id); 
}

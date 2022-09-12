package goldenlions.golden.Service.Cargo;

import java.util.List;

import goldenlions.golden.Models.Cargo.Cargo;

public interface ICargoService {
    
    public List <Cargo> findAll();
    public void save (Cargo cargo);
    public Cargo findOne (Integer id);
    public void delete (Integer id); 
}

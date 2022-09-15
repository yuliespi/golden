package goldenlions.golden.Service.Cargo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import goldenlions.golden.Models.Cargo.Cargo;
import goldenlions.golden.Models.Cargo.ICargo;

@Service
public class CargoServiceImpl implements ICargoService{
    @Autowired
    private ICargo cargog;
    
    @Override
    public List <Cargo> findAll(){
        return(List<Cargo>)cargog.findAll();
    }

    @Override
    public Cargo findOne(Integer idCargo) {
        return cargog.findById(idCargo).orElse(null);
    }

    @Override
    public void save(Cargo cargo){
        cargog.save(cargo);
    }
    
    @Override
    public void delete (Integer id){
        cargog.deleteById(id);
    }
}

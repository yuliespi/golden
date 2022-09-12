package goldenlions.golden.Service.Implemento;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import goldenlions.golden.Models.Implemento.IImplemento;
import goldenlions.golden.Models.Implemento.Implemento;

@Service
public class ImplementoServiceImpl implements IImplementoService {
    @Autowired
    private IImplemento implementog;
    
    @Override
    public List <Implemento> findAll(){
        return(List<Implemento>)implementog.findAll();
    }

    @Override
    public Implemento findOne(Integer idImplemento){
        return implementog.findById(idImplemento).orElse(null);
    }

    @Override
    public void save(Implemento implemento){
        implementog.save(implemento);
    }
    
    @Override
    public void delete (Integer id){
        implementog.deleteById(id);
    }
}

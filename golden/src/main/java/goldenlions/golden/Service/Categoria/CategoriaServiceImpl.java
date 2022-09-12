package goldenlions.golden.Service.Categoria;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import goldenlions.golden.Models.Categoria.Categoria;
import goldenlions.golden.Models.Categoria.ICategoria;

@Service
public class CategoriaServiceImpl implements ICategoriaService {
    @Autowired
    private ICategoria categoriag;
    
    @Override
    public List <Categoria> findAll(){
        return(List<Categoria>)categoriag.findAll();
    }

    @Override
    public Categoria findOne(Integer idCategoria){
        return categoriag.findById(idCategoria).orElse(null);
    }

    @Override
    public void save(Categoria categoria){
        categoriag.save(categoria);
    }
    
    @Override
    public void delete (Integer id){
        categoriag.deleteById(id);
    }
}

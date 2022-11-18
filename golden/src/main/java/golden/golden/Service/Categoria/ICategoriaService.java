package golden.golden.Service.Categoria;

import java.util.List;

import golden.golden.Models.Categoria.Categoria;

public interface ICategoriaService {
    
    public List <Categoria> findAll();
    public void save (Categoria categoria);
    public Categoria findOne (Integer id);
    public void delete (Integer id);
}

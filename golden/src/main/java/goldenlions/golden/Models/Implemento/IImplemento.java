package goldenlions.golden.Models.Implemento;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface IImplemento extends CrudRepository<Implemento,Integer> {
    List<Implemento> findByNombreImplemento(String nombreImplemento);
}

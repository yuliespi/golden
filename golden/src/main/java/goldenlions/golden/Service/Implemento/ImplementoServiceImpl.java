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
    public List<Implemento> findAll() {
        return (List<Implemento>) implementog.findAll();
    }

    @Override
    public Implemento findOne(Integer idImplemento) {
        return implementog.findById(idImplemento).orElse(null);
    }

    @Override
    public void save(Implemento implemento) {
        implementog.save(implemento);
    }

    @Override
    public void delete(Integer id) {
        implementog.deleteById(id);
    }

    @Override
    public String dublicado(Implemento implemento) {
        List<Implemento> implementos = implementog.findByNombreImplemento(implemento.getNombreImplemento());
        String mensaje = null;
        for (Implemento i : implementos) {
            if (i.getTamanoImplemento() == implemento.getTamanoImplemento()) {
                if (i.getPesoImplemento() != implemento.getPesoImplemento()) {
                    mensaje = "El implemento " + i.getNombreImplemento() + " de tamaño " + i.getTamanoImplemento()
                            + " y con peso " + i.getPesoImplemento() + " ya se encuentra registrado";
                }
            }
        }
        return mensaje;
    }
}

package goldenlions.golden.Service.Bitacora;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import goldenlions.golden.Models.Bitacora.Bitacora;
import goldenlions.golden.Models.Bitacora.IBitacora;

@Service
public class BitacoraServiceImpl implements IBitacoraService{
    @Autowired
    private IBitacora bitacorag;
    
    @Override
    public List <Bitacora> findAll(){
        return(List<Bitacora>)bitacorag.findAll();
    }

    @Override
    public Bitacora findOne(Integer idBitacora){
        return bitacorag.findById(idBitacora).orElse(null);
    }

    @Override
    public void save(Bitacora bitacora){
        bitacorag.save(bitacora);
    }
    
    @Override
    public void delete (Integer id){
        bitacorag.deleteById(id);

    }
}

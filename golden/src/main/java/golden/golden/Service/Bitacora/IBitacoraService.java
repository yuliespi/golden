package golden.golden.Service.Bitacora;

import java.util.List;

import golden.golden.Models.Bitacora.Bitacora;

public interface IBitacoraService{
    public List <Bitacora> findAll();
    public void save (Bitacora bitacora);
    public Bitacora findOne (Integer id);
    public void delete (Integer id); 
}

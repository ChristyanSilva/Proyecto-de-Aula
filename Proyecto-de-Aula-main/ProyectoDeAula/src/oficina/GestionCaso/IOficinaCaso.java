package oficina.GestionCaso;

import Excepcion.ExcepcionArchivo;
import desarrollo.caso.Caso;
import java.util.List;

public interface IOficinaCaso {        
    void registrarCaso(Caso c) throws ExcepcionArchivo;
    List<Caso> leerCaso() throws ExcepcionArchivo;
    Caso buscarCaso(Caso c)throws ExcepcionArchivo;
    Caso eliminarCaso(Caso c)throws ExcepcionArchivo;
    List<Caso> filtrarCaso(int numeroUnico) throws ExcepcionArchivo;
}

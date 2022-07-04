package oficina.GestionDetective;

import Excepcion.ExcepcionArchivo;
import desarrollo.caso.Caso;
import desarrollo.detectivesYSospechosos.Detective;
import java.util.List;

public interface IOficinaDetective {
    void registrarDetective(Detective d) throws ExcepcionArchivo;
    List<Detective> leerDetective() throws ExcepcionArchivo;
    Detective buscarDetective(Detective d)throws ExcepcionArchivo;
    Detective eliminarDetective(Detective d)throws ExcepcionArchivo;
    List<Detective> filtrarDetective(int noId) throws ExcepcionArchivo;
}

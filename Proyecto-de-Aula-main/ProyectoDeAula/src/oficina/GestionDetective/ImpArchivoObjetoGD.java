package oficina.GestionDetective;

import Excepcion.ExcepcionArchivo;
import desarrollo.detectivesYSospechosos.Detective;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ImpArchivoObjetoGD implements IOficinaDetective {
    private File archivo;
    private FileInputStream modoLectura;
    private FileOutputStream modoEscritura;
    public ImpArchivoObjetoGD() {
        this("Detective.obj");
    }
    public ImpArchivoObjetoGD(String path) {
        this.archivo = new File(path);
    }

    private void guardar(List<Detective> lista) throws ExcepcionArchivo {
        ObjectOutputStream oos = null;
        try {
            this.modoEscritura = new FileOutputStream(this.archivo);
            oos = new ObjectOutputStream(this.modoEscritura);
            oos.writeObject(lista);
            oos.close();

        } catch (FileNotFoundException e) {
            throw new ExcepcionArchivo("El Archivo de escritura no existe, o no se puede abrir");
        } catch (SecurityException e) {
            throw new ExcepcionArchivo("No tiene permiso de escritura sobre el archivo");
        } catch (IOException e) {
            throw new ExcepcionArchivo("Error al escribir en el archivo");
        } catch (NullPointerException e) {
            throw new ExcepcionArchivo("Los datos de la lista son null");
        }

    }

    private List<Detective> cargarArchivo() throws ExcepcionArchivo {

        ObjectInputStream ois = null;

        if (!this.archivo.exists()) {
            return new ArrayList<Detective>();
        }
        try {
            this.modoLectura = new FileInputStream(this.archivo);
            ois = new ObjectInputStream(this.modoLectura);
            List<Detective> lista = (List<Detective>) ois.readObject();
            ois.close();
            return lista;

        } catch (FileNotFoundException e) {
            throw new ExcepcionArchivo("El Archivo de lectura no existe, o no se puede abrir");
        } catch (SecurityException e) {
            throw new ExcepcionArchivo("No tiene permiso de lectura sobre el archivo");
        } catch (StreamCorruptedException e) {
            throw new ExcepcionArchivo("Error con los datos de flujo de cierre del objeto");
        } catch (IOException e) {
            throw new ExcepcionArchivo("Error al leer en el archivo");
        } catch (NullPointerException e) {
            throw new ExcepcionArchivo("El archivo a leer es null");
        }
        catch(ClassNotFoundException e){
            throw new ExcepcionArchivo("No existe la claase definida para el objeto leido");
        }

    }
    
    @Override
    public void registrarDetective(Detective d) throws ExcepcionArchivo {
            List<Detective> lista = this.cargarArchivo();
            lista.add(d);
            this.guardar(lista);
    }

    @Override
    public List<Detective> leerDetective() throws ExcepcionArchivo {
          return this.cargarArchivo();
    }

    @Override
    public Detective buscarDetective(Detective d) throws ExcepcionArchivo {
        List<Detective> lista = this.cargarArchivo();
        Detective buscado=null;
        for(Detective i: lista){
            if(i.getNoId()==d.getNoId()){
                buscado=i;
                break;
            }
        }
        return buscado;
    }

    @Override
    public Detective eliminarDetective(Detective d) throws ExcepcionArchivo {
        List<Detective> lista = this.cargarArchivo();
        Detective eliminar=null;
        Iterator<Detective>i = lista.iterator();
        
        while(i.hasNext()){
            Detective aux= i.next();
            if(aux.getNoId()==d.getNoId()){
                eliminar=aux;
                i.remove();
            }
        }
        
        this.guardar(lista);
        
        return eliminar;
        
    }
    
    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

    public FileInputStream getModoLectura() {
        return modoLectura;
    }

    public void setModoLectura(FileInputStream modoLectura) {
        this.modoLectura = modoLectura;
    }

    public FileOutputStream getModoEscritura() {
        return modoEscritura;
    }

    public void setModoEscritura(FileOutputStream modoEscritura) {
        this.modoEscritura = modoEscritura;
    }
    
     public List<Detective> filtrarDetective(int noId) throws ExcepcionArchivo{
         List<Detective> lista = this.cargarArchivo();
         List<Detective> listaFiltrada = new ArrayList();
         for(Detective d: lista){
             String noIdLista = String.valueOf(d.getNoId());
             String noIdFiltrada = String.valueOf(noId);
             if(noIdLista.contains(noIdFiltrada)){
                 listaFiltrada.add(d);
             }
         }
         return listaFiltrada;         
     }

}

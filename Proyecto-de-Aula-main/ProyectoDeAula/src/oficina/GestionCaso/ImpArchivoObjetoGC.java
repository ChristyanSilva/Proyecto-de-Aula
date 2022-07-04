package oficina.GestionCaso;

import Excepcion.ExcepcionArchivo;
import desarrollo.caso.Caso;
import desarrollo.detectivesYSospechosos.Detective;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import oficina.GestionDetective.IOficinaDetective;

public class ImpArchivoObjetoGC implements IOficinaCaso {
    private File archivo;
    private FileInputStream modoLectura;
    private FileOutputStream modoEscritura;
    public ImpArchivoObjetoGC() {
        this("Caso.obj");
    }
    public ImpArchivoObjetoGC(String path) {
        this.archivo = new File(path);
    }

    private void guardarCaso(List<Caso> lista) throws ExcepcionArchivo {
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

    private List<Caso> cargarArchivo() throws ExcepcionArchivo {
        ObjectInputStream ois = null;
        if (!this.archivo.exists()) {
            return new ArrayList<Caso>();
        }
        try {
            this.modoLectura = new FileInputStream(this.archivo);
            ois = new ObjectInputStream(this.modoLectura);
            List<Caso> lista = (List<Caso>) ois.readObject();
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
    public void registrarCaso(Caso c) throws ExcepcionArchivo {
            List<Caso> lista = this.cargarArchivo();
            lista.add(c);
            this.guardarCaso(lista);
    }

    @Override
    public List<Caso> leerCaso() throws ExcepcionArchivo {
          return this.cargarArchivo();
    }

    @Override
    public Caso buscarCaso(Caso c) throws ExcepcionArchivo {
        List<Caso> lista = this.cargarArchivo();
        Caso buscado=null;
        for(Caso i: lista){
            if(i.getNumeroUnico()==c.getNumeroUnico()){
                buscado=i;
                break;
            }
        }
        return buscado;
    }

    @Override
    public Caso eliminarCaso(Caso c) throws ExcepcionArchivo {
        List<Caso> lista = this.cargarArchivo();
        Caso eliminar=null;
        Iterator<Caso>i = lista.iterator();
        
        while(i.hasNext()){
            Caso aux= i.next();
            if(aux.getNumeroUnico()==c.getNumeroUnico()){
                eliminar=aux;
                i.remove();
            }
        }
        
        this.guardarCaso(lista);
        
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
    
    @Override
    public List<Caso> filtrarCaso(int numeroUnico) throws ExcepcionArchivo{
        List<Caso> lista = this.cargarArchivo();
        List<Caso> listaFiltrada = new ArrayList();
        for(Caso c: lista){
            String numeroUnicoLista = String.valueOf(c.getNumeroUnico());
            String numeroUnicoFiltrada = String.valueOf(numeroUnico);
            if(numeroUnicoLista.contains(numeroUnicoFiltrada)){
                listaFiltrada.add(c);
             }
        }
        return listaFiltrada;         
    }
}
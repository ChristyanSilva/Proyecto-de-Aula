package oficina.GestionCaso;

import Excepcion.ExcepcionArchivo;
import desarrollo.caso.Caso;
import desarrollo.caso.Cibercrimen;
import desarrollo.detectivesYSospechosos.Detective;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ImpArchivoTextoGC implements IOficinaCaso {

    private File archivo;
    private FileWriter modoEscritura;
    private Scanner modoLectura;

    public ImpArchivoTextoGC() {
        this("Caso.inv");
    }

    public ImpArchivoTextoGC(String path) {
        this.archivo = new File(path);
    }

    @Override
    public void registrarCaso(Caso c) throws ExcepcionArchivo {
        PrintWriter pw = null;
        try {

            this.modoEscritura = new FileWriter(this.archivo, true);
            pw = new PrintWriter(this.modoEscritura);
            pw.println(c.getDataFileFormat());

        } catch (IOException e) {
            throw new ExcepcionArchivo("Error al abrir o crear archivo en modo escritura");
        } finally {
            if (pw != null) {
                pw.close();
            }
        }
    }
    
    private Caso cargar(String data[]){
        int numeroUnico = Integer.valueOf(data[0]);
        String descripcion = data[1];
        String nivelImportancia = data[2];
        String detective= data[3];
        String lineacrimen= data[4];
        
        return new Cibercrimen(numeroUnico, descripcion, nivelImportancia, detective, lineacrimen);
    }

    @Override
    public List<Caso> leerCaso() throws ExcepcionArchivo {
        List<Caso> lista;
        try {
            this.modoLectura = new Scanner(this.archivo);
            lista = new ArrayList();
            while(this.modoLectura.hasNext()){
                String[] data = this.modoLectura.nextLine().split(";");
                Caso c = this.cargar(data);
                lista.add(c);
            }
            return lista;
        } catch (FileNotFoundException e) {
            throw new ExcepcionArchivo("Error al leer archivo en modo lectura");
           
        }
        finally{
            if(this.modoLectura!=null)
                this.modoLectura.close();
        }
    }   

    @Override
    public Caso buscarCaso(Caso c) throws ExcepcionArchivo {
        Caso buscado = null;
        try {
            this.modoLectura = new Scanner(this.archivo);
            while(this.modoLectura.hasNext()){
                String[] data = this.modoLectura.nextLine().split(";");
                buscado = this.cargar(data);
                if(buscado.getNumeroUnico()==c.getNumeroUnico()){
                    return buscado;
                }    
            }
            return null;
        } catch (FileNotFoundException e) {
            throw new ExcepcionArchivo("Error al buscar archivo en modo lectura");
        }
        finally{
            if(this.modoLectura!=null)
                this.modoLectura.close();
        }
    }
    
    private void renombrarArchivo(File tmp) throws IOException{
        if(!tmp.exists())
            tmp.createNewFile();
        
        if(!this.archivo.delete())
            throw new IOException("Error al eliminar el archivo principal");
        
        if(!tmp.renameTo(this.archivo))
            throw new IOException("Error al renombrar el archivo tmp");
        
    }

    @Override
    public Caso eliminarCaso(Caso c) throws ExcepcionArchivo {
        Caso eliminado = null;
        ImpArchivoTextoGC archivoTemporal = new ImpArchivoTextoGC("Caso.tmp");
        try {
            this.modoLectura = new Scanner(this.archivo);
            while(this.modoLectura.hasNext()){
                String[] data = this.modoLectura.nextLine().split(";");
                Caso aux = this.cargar(data);
                if(aux.getNumeroUnico()==c.getNumeroUnico()){
                    eliminado=aux;
                }    
                else{
                   archivoTemporal.registrarCaso(aux);
                }
            }
            this.modoLectura.close();
            this.renombrarArchivo(archivoTemporal.archivo);
            return eliminado;
        } catch (FileNotFoundException e) {
            throw new ExcepcionArchivo("Error al buscar archivo en modo lectura");
        }
        catch(IOException e){
            throw new ExcepcionArchivo(e.getMessage());
        }
        finally{
            if(this.modoLectura!=null)
                this.modoLectura.close();
        }
    }
    
    public File getArchivo() {
        return archivo;
    }
    
    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }
    
    public FileWriter getModoEscritura() {
        return modoEscritura;
    }

    public void setModoEscritura(FileWriter modoEscritura) {
        this.modoEscritura = modoEscritura;
    }

    public Scanner getModoLectura() {
        return modoLectura;
    }
    
    public void setModoLectura(Scanner modoLectura) {
        this.modoLectura = modoLectura;
    }

    @Override
    public List<Caso> filtrarCaso(int numeroUnico) throws ExcepcionArchivo {
        List<Caso> lista = this.leerCaso();
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

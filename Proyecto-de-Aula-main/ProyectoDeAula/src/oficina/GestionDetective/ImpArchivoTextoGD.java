package oficina.GestionDetective;

import Excepcion.ExcepcionArchivo;
import desarrollo.caso.Caso;
import desarrollo.detectivesYSospechosos.Detective;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ImpArchivoTextoGD implements IOficinaDetective {

    private File archivo;
    private FileWriter modoEscritura;
    private Scanner modoLectura;

    public ImpArchivoTextoGD() {
        this("Detective.inv");
    }

    public ImpArchivoTextoGD(String path) {
        this.archivo = new File(path);
    }

    @Override
    public void registrarDetective(Detective d) throws ExcepcionArchivo {
        PrintWriter pw = null;
        try {

            this.modoEscritura = new FileWriter(this.archivo, true);
            pw = new PrintWriter(this.modoEscritura);
            pw.println(d.getDataFileFormat());

        } catch (IOException e) {
            throw new ExcepcionArchivo("Error al abrir o crear archivo en modo escritura");
        } finally {
            if (pw != null) {
                pw.close();
            }
        }
    }
    
    private Detective cargar(String data[]){
        int aniosExp = Integer.valueOf(data[0]);
        String capacitado = data[1];
        int casosAsignados = Integer.valueOf(data[2]);
        int noId= Integer.valueOf(data[3]);
        String nombres = data[4];
        String Apellidos = data[5];
        
        return new Detective(aniosExp,capacitado,casosAsignados, noId, nombres,Apellidos);
    }

    @Override
    public List<Detective> leerDetective() throws ExcepcionArchivo {
        List<Detective> lista;
        try {
            this.modoLectura = new Scanner(this.archivo);
            lista = new ArrayList();
            while(this.modoLectura.hasNext()){
                String[] data = this.modoLectura.nextLine().split(";");
                Detective d = this.cargar(data);
                lista.add(d);
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
    public Detective buscarDetective(Detective d) throws ExcepcionArchivo {
        Detective buscado = null;
        try {
            this.modoLectura = new Scanner(this.archivo);
            while(this.modoLectura.hasNext()){
                String[] data = this.modoLectura.nextLine().split(";");
                buscado = this.cargar(data);
                if(buscado.getNoId()==d.getNoId()){
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
    public Detective eliminarDetective(Detective d) throws ExcepcionArchivo {
        Detective eliminado = null;
        ImpArchivoTextoGD archivoTemporal = new ImpArchivoTextoGD("Detective.tmp");
        try {
            this.modoLectura = new Scanner(this.archivo);
            while(this.modoLectura.hasNext()){
                String[] data = this.modoLectura.nextLine().split(";");
                Detective aux = this.cargar(data);
                if(aux.getNombres()==d.getNombres()){
                    eliminado=aux;
                }    
                else{
                   archivoTemporal.registrarDetective(aux);
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
    public List<Detective> filtrarDetective(int noId) throws ExcepcionArchivo {
        List<Detective> lista = this.leerDetective();
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

package desarrollo.caso;

import java.util.ArrayList;

public class Bitacora {
    private String fechaRegistro;
    private String observacion;
    private ArrayList<String> historialdeAnotaciones = new ArrayList();
    
    public String getFechaRegistro() {
        return fechaRegistro;
    }
    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    public String getObservacion() {
        return observacion;
    }
    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
    public ArrayList<String> getHistorialdeAnotaciones() {
        return historialdeAnotaciones;
    }
    public void setHistorialdeAnotaciones(ArrayList<String> historialdeAnotaciones) {
        this.historialdeAnotaciones = historialdeAnotaciones;
    }
    public Bitacora() {
    }
    public Bitacora(String fechaRegistro, String observacion) {
        this.fechaRegistro = fechaRegistro;
        this.observacion = observacion;
    }
    public String llenarBitacora(){
        historialdeAnotaciones.add(fechaRegistro +" "+ observacion);    
        return "La bitacora ha sido actualizada";        
    }
    public String mostrarBitacora(){
        for(int x=0;x<historialdeAnotaciones.size();x++){
            System.out.println("Historial de Anotaciones del Caso:"+historialdeAnotaciones.get(x));
        }
        return "Todos los elementos han sido mostrados.";
    }
}
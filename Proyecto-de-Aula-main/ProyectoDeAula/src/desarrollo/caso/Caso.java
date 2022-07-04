package desarrollo.caso;

public abstract class Caso {
    private int numeroUnico;
    private String descripcion;
    private String nivelImportancia;
    private String detective;
    private String lineacrimen;    
    
    public int getNumeroUnico() {
        return numeroUnico;
    }
    public void setNumeroUnico(int numeroUnico) {
        this.numeroUnico = numeroUnico;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getNivelImportancia() {
        return nivelImportancia;
    }
    public void setNivelImportancia(String nivelImportancia) {
        this.nivelImportancia = nivelImportancia;
    }

    public String getLineacrimen() {
        return lineacrimen;
    }
    public void setLineacrimen(String lineacrimen) {
        this.lineacrimen = lineacrimen;
    }
    public Caso() {
    }
    
    public Caso(int numeroUnico, String descripcion, String nivelImportancia, String detective, String lineacrimen) {
        this.numeroUnico = numeroUnico;
        this.descripcion = descripcion;
        this.nivelImportancia = nivelImportancia;
        this.detective = detective;
        this.lineacrimen = lineacrimen;
    }
    
    public abstract String datosdelCaso();
    public String getDataFileFormat() {
        return "Caso{"+"numeroUnico "+numeroUnico+", descripcion "+descripcion+", nivelImportancia"+nivelImportancia+ ", Detective " +detective+ ", LineadelCrimen" +lineacrimen+'}';
    }

    public String getDetective() {
        return detective;
    }

    public void setDetective(String detective) {
        this.detective = detective;
    }
}

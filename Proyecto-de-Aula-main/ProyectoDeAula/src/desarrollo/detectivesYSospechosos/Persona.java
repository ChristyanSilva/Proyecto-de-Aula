package desarrollo.detectivesYSospechosos;

public abstract class Persona {
    private int noId;
    private String nombres;
    private String Apellidos;
    
    public int getNoId() {
        return noId;
    }

    public void setNoId(int noId) {
        this.noId = noId;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public Persona() {
    }
    
    public Persona(int noId, String nombres, String Apellidos) {
        this.noId = noId;
        this.nombres = nombres;
        this.Apellidos = Apellidos;
    }
    

    
}


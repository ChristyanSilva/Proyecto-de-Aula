package desarrollo.detectivesYSospechosos;


public class Detective extends Persona{
    //Atributos 
    
    
    private double aniosExp;
    private String capacitado;
    private int casosAsignados;

    public double getAniosExp() {
        return aniosExp;
    }

    public void setAniosExp(double aniosExp) {
        this.aniosExp = aniosExp;
    }

    public String getCapacitado() {
        return capacitado;
    }

    public void setCapacitado(String capacitado) {
        this.capacitado = capacitado;
    }

    public int getCasosAsignados() {
        return casosAsignados;
    }

    public void setCasosAsignados(int casosAsignados) {
        this.casosAsignados = casosAsignados;
    }

    public Detective() {
    }

    public Detective(double aniosExp, String capacitado, int casosAsignados) {
        this.aniosExp = aniosExp;
        this.capacitado = capacitado;
        this.casosAsignados = casosAsignados;
    }

    public Detective(double aniosExp, String capacitado, int casosAsignados, int noId, String nombres, String Apellidos) {
        super(noId, nombres, Apellidos);
        this.aniosExp = aniosExp;
        this.capacitado = capacitado;
        this.casosAsignados = casosAsignados;
    }

    public String getDataFileFormat() {
        return "Detective{"+"noID"+super.getNoId()+", Nombres"+super.getNombres()+", Apellidos"+super.getApellidos() + "aniosExp=" + aniosExp + ", capacitado=" + capacitado + ", casosAsignados=" + casosAsignados + '}';
    }

       
    
}

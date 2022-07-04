package desarrollo.detectivesYSospechosos;

public class Direccion {
    private double noVivienda;
    private String localidad;
    private String ciudad;
    private String dpto;
    private String pais;

    public double getNoVivienda() {
        return noVivienda;
    }

    public void setNoVivienda(double noVivienda) {
        this.noVivienda = noVivienda;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDpto() {
        return dpto;
    }

    public void setDpto(String dpto) {
        this.dpto = dpto;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Direccion() {
    }

    public Direccion(double noVivienda, String localidad, String ciudad, String dpto, String pais) {
        this.noVivienda = noVivienda;
        this.localidad = localidad;
        this.ciudad = ciudad;
        this.dpto = dpto;
        this.pais = pais;
    }
    
    
}

package desarrollo.detectivesYSospechosos;

public class Sospechoso extends Persona{
    private String alias;
    private int edad;
    private Direccion direccion;
    private FotografiadelSospechoso foto;
    private CaracteristicasFisicas caracteristicas;

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public FotografiadelSospechoso getFoto() {
        return foto;
    }

    public void setFoto(FotografiadelSospechoso foto) {
        this.foto = foto;
    }

    public CaracteristicasFisicas getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(CaracteristicasFisicas caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public Sospechoso() {
    }

    public Sospechoso(String alias, int edad, Direccion direccion, FotografiadelSospechoso foto, CaracteristicasFisicas caracteristicas) {
        this.alias = alias;
        this.edad = edad;
        this.direccion = direccion;
        this.foto = foto;
        this.caracteristicas = caracteristicas;
    }

    public Sospechoso(String alias, int edad, Direccion direccion, FotografiadelSospechoso foto, CaracteristicasFisicas caracteristicas, int noId, String nombres, String Apellidos) {
        super(noId, nombres, Apellidos);
        this.alias = alias;
        this.edad = edad;
        this.direccion = direccion;
        this.foto = foto;
        this.caracteristicas = caracteristicas;
    }

}

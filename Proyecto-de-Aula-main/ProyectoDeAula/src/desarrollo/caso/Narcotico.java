package desarrollo.caso;

import desarrollo.detectivesYSospechosos.Detective;

public class Narcotico extends Caso{
    private String localizaciondelCaso;

    public String getLocalizaciondelCaso() {
        return localizaciondelCaso;
    }

    public void setLocalizaciondelCaso(String localizaciondelCaso) {
        this.localizaciondelCaso = localizaciondelCaso;
    }

    public Narcotico() {
    }

    public Narcotico(String localizaciondelCaso, int numeroUnico, String descripcion, String nivelImportancia, String detective, String lineacrimen) {
        super(numeroUnico, descripcion, nivelImportancia, detective, lineacrimen);
        this.localizaciondelCaso = localizaciondelCaso;
    }

    @Override
    public String datosdelCaso() {
        return "Caso{" + "numeroUnico=" + super.getNumeroUnico() + ", descripcion=" + super.getDescripcion() + ", nivelImportancia=" + super.getNivelImportancia() + ", detective=" + super.getDetective() + ", lineacrimen=" + super.getLineacrimen() + "Localidad del Caso= "+localizaciondelCaso+ '}';
    }
}
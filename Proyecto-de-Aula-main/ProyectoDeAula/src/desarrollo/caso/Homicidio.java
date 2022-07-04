package desarrollo.caso;

import desarrollo.detectivesYSospechosos.Detective;

public class Homicidio extends Caso {
    private String segDetective;

    public String getSegDetective() {
        return segDetective;
    }

    public void setSegDetective(String segDetective) {
        this.segDetective = segDetective;
    }

    public Homicidio() {
    }

    public Homicidio(String segDetective, int numeroUnico, String descripcion, String nivelImportancia, String detective, String lineacrimen) {
        super(numeroUnico, descripcion, nivelImportancia, detective, lineacrimen);
        this.segDetective = segDetective;
    }



    @Override
    public String datosdelCaso() {
        return "Caso{" + "numeroUnico=" + super.getNumeroUnico() + ", descripcion=" + super.getDescripcion() + ", nivelImportancia=" + super.getNivelImportancia() + ", detective=" + super.getDetective() + ", lineacrimen=" + super.getLineacrimen() + "SegundoDetective= "+segDetective+ '}';
    }    
}
package desarrollo.caso;

import desarrollo.detectivesYSospechosos.Detective;

public class Cibercrimen extends Caso {

    public Cibercrimen() {
    }    

    public Cibercrimen(int numeroUnico, String descripcion, String nivelImportancia, String detective, String lineacrimen) {
        super(numeroUnico, descripcion, nivelImportancia, detective, lineacrimen);
    }

    @Override
    public String datosdelCaso() {
        return "Caso{" + "numeroUnico=" + super.getNumeroUnico() + ", descripcion=" + super.getDescripcion() + ", nivelImportancia=" + super.getNivelImportancia() + ", detective=" + super.getDetective() + ", lineacrimen=" + super.getLineacrimen() + '}';
    }
}

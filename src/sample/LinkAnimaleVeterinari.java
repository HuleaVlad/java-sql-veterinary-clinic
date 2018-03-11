package sample;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 * Created by HV on 05-Jan-18.
 */
public class LinkAnimaleVeterinari {
    private IntegerProperty id_animal;
    private IntegerProperty id_veterinar;

    public LinkAnimaleVeterinari() {
        this.id_animal = new SimpleIntegerProperty();
        this.id_veterinar = new SimpleIntegerProperty();

    }

    //region id_animal
    public int getIdAnimal() {
        return id_animal.get();
    }

    public void setIdAnimal(int idAnimal) {
        this.id_animal.set(idAnimal);
    }

    public IntegerProperty IdAnimalProperty() {
        return id_animal;
    }
    //endregion

    //region id_veterinar
    public int getIdVeterinar() {
        return id_veterinar.get();
    }

    public void setIdVeterinar(int idVeterinar) {
        this.id_veterinar.set(idVeterinar);
    }

    public IntegerProperty IdVeterinarProperty() {
        return id_veterinar;
    }
    //endregion
}

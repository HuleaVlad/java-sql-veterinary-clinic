package sample;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 * Created by HV on 05-Jan-18.
 */
public class LinkAnimaleHrana {
    private IntegerProperty id_animal;
    private IntegerProperty id_hrana;

    public LinkAnimaleHrana() {
        this.id_animal = new SimpleIntegerProperty();
        this.id_hrana = new SimpleIntegerProperty();
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

    //region id_hrana
    public int getIdHrana() {
        return id_hrana.get();
    }

    public void setIdHrana(int idHrana) {
        this.id_hrana.set(idHrana);
    }

    public IntegerProperty idHranaProperty() {
        return id_hrana;
    }
    //endregion

}
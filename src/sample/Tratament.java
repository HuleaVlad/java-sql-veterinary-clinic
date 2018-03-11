package sample;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by HV on 05-Jan-18.
 */
public class Tratament {
    private IntegerProperty idTratament;
    private StringProperty numeMedicament;
    private StringProperty folosireMedicament;

    public Tratament(){
        this.idTratament = new SimpleIntegerProperty();
        this.numeMedicament = new SimpleStringProperty();
        this.folosireMedicament = new SimpleStringProperty();

    }

    //region idTratament
    public int getIdTratament() {
        return idTratament.get();
    }

    public void setIdTratament(int idTratament) {
        this.idTratament.set(idTratament);
    }

    public IntegerProperty IdTratamentProperty() {
        return idTratament;
    }
    //endregion

    //region numeMedicament
    public String getNumeMedicament() {
        return numeMedicament.get();
    }

    public void setNumeMedicament(String numeMedicament) {

        this.numeMedicament.set(numeMedicament);
    }

    public StringProperty NumeMedicamentProperty() {
        return numeMedicament;
    }
    //endregion

    //region folosireMedicament
    public String getFolosireMedicament() {
        return folosireMedicament.get();
    }

    public void setFolosireMedicament(String folosireMedicament) {

        this.folosireMedicament.set(folosireMedicament);
    }

    public StringProperty FolosireMedicamentProperty() {
        return folosireMedicament;
    }
    //endregion

}

package sample;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by HV on 05-Jan-18.
 */
public class TipAnimal {
    private IntegerProperty idTipAnimal;
    private StringProperty numeAnimal;
    private StringProperty descriereAnimal;

    public TipAnimal(){
        this.idTipAnimal = new SimpleIntegerProperty();
        this.numeAnimal = new SimpleStringProperty();
        this.descriereAnimal = new SimpleStringProperty();

    }

    //region idTipAnimal
    public int getIdTipAnimal() {
        return idTipAnimal.get();
    }

    public void setIdTipAnimal(int idTipAnimal) {
        this.idTipAnimal.set(idTipAnimal);
    }

    public IntegerProperty IdTipAnimalProperty() {
        return idTipAnimal;
    }
    //endregion

    //region numeAnimal
    public String getNumeAnimal() {
        return numeAnimal.get();
    }

    public void setNumeAnimal(String numeAnimal) {
        this.numeAnimal.set(numeAnimal);
    }

    public StringProperty NumeAnimalProperty() {
        return numeAnimal;
    }
    //endregion

    //region descriereAnimal
    public String getDescriereAnimal() {
        return descriereAnimal.get();
    }

    public void setDescriereAnimal(String descriereAnimal) {
        this.descriereAnimal.set(descriereAnimal);
    }

    public StringProperty DescriereAnimalProperty() {
        return descriereAnimal;
    }
    //endregion
}

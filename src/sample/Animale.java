package sample;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.*;

import java.util.Date;

/**
 * Created by HV on 05-Jan-18.
 */
public class Animale {
    private IntegerProperty idAnimal;
    private IntegerProperty idTipAnimal;
    private IntegerProperty greutate;
    private StringProperty sex;
    private StringProperty descriere;
    private SimpleObjectProperty<java.sql.Date> dataNasterii;
    private IntegerProperty idHrana;
    private IntegerProperty idProprietar;
    private StringProperty tipHrana;
    private StringProperty numeProprietar;
    private StringProperty prenumeProprietar;
    private StringProperty numeAnimal;



    public Animale() {
        this.idAnimal = new SimpleIntegerProperty();
        this.idTipAnimal = new SimpleIntegerProperty();
        this.greutate = new SimpleIntegerProperty();
        this.sex = new SimpleStringProperty();
        this.descriere = new SimpleStringProperty();
        this.dataNasterii = new SimpleObjectProperty<>();
        this.idHrana = new SimpleIntegerProperty();
        this.idProprietar = new SimpleIntegerProperty();
        this.tipHrana = new SimpleStringProperty();
        this.numeProprietar=new SimpleStringProperty();
        this.prenumeProprietar=new SimpleStringProperty();
        this.numeAnimal=new SimpleStringProperty();
    }

    //region idAnimal
    public int getIdAnimal() {
        return idAnimal.get();
    }

    public void setIdAnimal(int idAnimal) {
        this.idAnimal.set(idAnimal);
    }

    public IntegerProperty IdAnimalProperty() {
        return idAnimal;
    }
    //endregion

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

    //region greutate
    public int getGreutate() {
        return greutate.get();
    }

    public void setGreutate(Integer greutateval) {

        this.greutate.set(greutateval);
    }

    public IntegerProperty GreutateProperty() {
        return greutate;
    }
    //endregion

    //region sex
    public String getSex() {
        return sex.get();
    }

    public void setSex(String sexval) {
        this.sex.set(sexval);
    }

    public StringProperty SexProperty() {
        return sex;
    }
    //endregion

    //region descriere
    public String getDescriere() {
        return descriere.get();
    }

    public void setDescriere(String descriereval) {
        this.descriere.set(descriereval);
    }

    public StringProperty DescriereProperty() {
        return descriere;
    }
    //endregion

    //region dataNasterii
    public java.sql.Date getDataNasterii() {
        return dataNasterii.getValue();
    }

    public void setdataNasterii(java.sql.Date dataNasterii) {
        this.dataNasterii.set(dataNasterii);
    }

    public SimpleObjectProperty<java.sql.Date> DataNasteriiProperty() {
        return dataNasterii;
    }
    //endregion

    //region idHrana
    public int getIdHrana() {
        return idHrana.get();
    }

    public void setIdHrana(int idHrana) {
        this.idHrana.set(idHrana);
    }

    public IntegerProperty idHranaProperty() {
        return idHrana;
    }
    //endregion

    //region idProprietar
    public int getIdProprietar() {
        return idProprietar.get();
    }

    public void setIdProprietar(int idProprietar) {
        this.idProprietar.set(idProprietar);
    }

    public IntegerProperty idProprietarProperty() {
        return idProprietar;
    }
    //endregion

    //region tipHrana
    public String getTipHrana() {
        return tipHrana.get();
    }

    public void setTipHrana(String tipHrana) {
        this.tipHrana.set(tipHrana);
    }

    public StringProperty TipHranaProperty() {
        return tipHrana;
    }
    //endregion

    //region numeAnimal
    public String getNumeAnimal() {
        return numeAnimal.get();
    }

    public void setNumeAnimal(String numeAnimal) {
        this.numeAnimal.set(numeAnimal);
    }

    public StringProperty numeAnimalProperty() {
        return numeAnimal;
    }
    //endregion

    //region numeProprietar
    public String getNumeProprietar() {
        return numeProprietar.get();
    }

    public void setNumeProprietar(String numeProprietar) {
        this.numeProprietar.set(numeProprietar);
    }

    public StringProperty NumeProprietarProperty() {
        return numeProprietar;
    }
    //endregion

    //region prenumeProprietar
    public String getPrenumeProprietar() {
        return prenumeProprietar.get();
    }

    public void setPrenumeProprietar(String prenumeProprietar) {
        this.prenumeProprietar.set(prenumeProprietar);
    }

    public StringProperty PrenumeProprietarProperty() {
        return prenumeProprietar;
    }
    //endregion
}

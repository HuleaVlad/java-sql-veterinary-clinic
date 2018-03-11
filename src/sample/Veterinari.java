package sample;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by HV on 05-Jan-18.
 */
public class Veterinari {
    private IntegerProperty idVeterinar;
    private IntegerProperty telefonVeterinar;
    private StringProperty numeVeterinar;
    private StringProperty prenumeVeterinar;
    private StringProperty adresaVeterinar;
    private StringProperty emailVeterinar;

    public Veterinari(){
        this.idVeterinar = new SimpleIntegerProperty();
        this.telefonVeterinar = new SimpleIntegerProperty();
        this.numeVeterinar = new SimpleStringProperty();
        this.prenumeVeterinar = new SimpleStringProperty();
        this.adresaVeterinar = new SimpleStringProperty();
        this.emailVeterinar = new SimpleStringProperty();

    }

    //region idVeterinar
    public int getIdVeterinar() {
        return idVeterinar.get();
    }

    public void setIdVeterinar(int idVeterinar) {
        this.idVeterinar.set(idVeterinar);
    }

    public IntegerProperty IdVeterinarProperty() {
        return idVeterinar;
    }
    //endregion

    //region telefonVeterinar
    public int getTelefonVeterinar() {
        return telefonVeterinar.get();
    }

    public void setTelefonVeterinar(int telefonVeterinar) {
        this.telefonVeterinar.set(telefonVeterinar);
    }

    public IntegerProperty TelefonVeterinarProperty() {
        return telefonVeterinar;
    }
    //endregion

    //region numeVeterinar
    public String getNumeVeterinar() {
        return numeVeterinar.get();
    }

    public void setNumeVeterinar(String numeVeterinar) {

        this.numeVeterinar.set(numeVeterinar);
    }

    public StringProperty NumeVeterinariProperty() {
        return numeVeterinar;
    }
    //endregion

    //region prenumeVeterinar
    public String getPrenumeVeterinar() {
        return prenumeVeterinar.get();
    }

    public void setPrenumeVeterinar(String prenumeVeterinar) {

        this.prenumeVeterinar.set(prenumeVeterinar);
    }

    public StringProperty PrenumeVeterinarroperty() {
        return prenumeVeterinar;
    }
    //endregion

    //region adresaVeterinar
    public String getAdresaVeterinar() {
        return adresaVeterinar.get();
    }

    public void setAdresaVeterinar(String adresaVeterinar) {

        this.adresaVeterinar.set(adresaVeterinar);
    }

    public StringProperty AdresaVeterinarProperty() {
        return adresaVeterinar;
    }
    //endregion

    //region emailVeterinar
    public String getEmailVeterinar() {
        return emailVeterinar.get();
    }

    public void setEmailVeterinar(String emailVeterinar) {

        this.emailVeterinar.set(emailVeterinar);
    }

    public StringProperty EmailVeterinarProperty() {
        return emailVeterinar;
    }
    //endregion
}

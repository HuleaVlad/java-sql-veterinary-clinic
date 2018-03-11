package sample;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by HV on 05-Jan-18.
 */
public class Proprietar {
    private IntegerProperty idProprietar;
    private IntegerProperty telefonProprietar;
    private StringProperty numeProprietar;
    private StringProperty prenumeProprietar;
    private StringProperty mailProprietar;

    public Proprietar(){
        this.idProprietar = new SimpleIntegerProperty();
        this.telefonProprietar = new SimpleIntegerProperty();
        this.numeProprietar = new SimpleStringProperty();
        this.prenumeProprietar = new SimpleStringProperty();
        this.mailProprietar = new SimpleStringProperty();

    }

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

    //region telefonProprietar
    public int getTelefonProprietar() {
        return telefonProprietar.get();
    }

    public void setTelefonProprietar(int telefonProprietar) {
        this.telefonProprietar.set(telefonProprietar);
    }

    public IntegerProperty TelefonProprietarProperty() {
        return telefonProprietar;
    }
    //endregion

    //region numeProprietar
    public String getNumeProprietar() {
        return numeProprietar.get();
    }

    public void setNumeProprietar(String numeProprietar) {
        this.numeProprietar.set(numeProprietar);
    }

    public StringProperty NumeProprProperty() {
        return numeProprietar;
    }
    //endregion

    //region prenumeProprietar
    public String getPrenumeProprietar() {
        return prenumeProprietar.get();
    }

    public void setPrenumePropr(String prenumeProprietar) {
        this.prenumeProprietar.set(prenumeProprietar);
    }

    public StringProperty PrenumeProprProperty() {
        return prenumeProprietar;
    }
    //endregion

    //region mailProprietar
    public String getMailProprietar() {
        return mailProprietar.get();
    }

    public void setMailProprietar(String mailProprietar) {
        this.mailProprietar.set(mailProprietar);
    }

    public StringProperty MailProprietarProperty() {
        return mailProprietar;
    }
    //endregion

}

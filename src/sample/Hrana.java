package sample;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.*;

import java.util.Date;

/**
 * Created by HV on 05-Jan-18.
 */
public class Hrana {
    private IntegerProperty idHrana;
    private IntegerProperty pret;
    private StringProperty tipHrana;
    private StringProperty brand;

    public Hrana() {
        this.idHrana = new SimpleIntegerProperty();
        this.pret = new SimpleIntegerProperty();
        this.tipHrana = new SimpleStringProperty();
        this.brand = new SimpleStringProperty();

    }

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

    //region pret
    public int getPret() {
        return pret.get();
    }

    public void setPret(int pretval) {
        this.pret.set(pretval);
    }

    public IntegerProperty PretProperty() {
        return pret;
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

    //region brand
    public String getBrand() {
        return brand.get();
    }

    public void setBrand(String brandval) {
        this.brand.set(brandval);
    }

    public StringProperty BrandProperty() {
        return brand;
    }
    //endregion

}



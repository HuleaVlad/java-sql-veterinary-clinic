package sample;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.*;

import java.util.Date;

/**
 * Created by HV on 05-Jan-18.
 */
public class Consultatii {
    private IntegerProperty idConsultatie;
    private IntegerProperty idTratament;
    private IntegerProperty idAnimal;
    private StringProperty diagnostic;
    private SimpleObjectProperty<Date> dataConsultatie;
    private IntegerProperty idVeterinar;
    private StringProperty numeVeterinar;
    private StringProperty prenumeVeterinar;
    private StringProperty numeMedicament;

    public Consultatii() {
        this.idAnimal = new SimpleIntegerProperty();
        this.idTratament = new SimpleIntegerProperty();
        this.diagnostic = new SimpleStringProperty();
        this.dataConsultatie = new SimpleObjectProperty<>();
        this.idVeterinar = new SimpleIntegerProperty();
        this.idConsultatie= new SimpleIntegerProperty();
        this.numeVeterinar=new SimpleStringProperty();
        this.prenumeVeterinar=new SimpleStringProperty();
        this.numeMedicament=new SimpleStringProperty();
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

    //region idConsultatie
    public int getIdConsultatie() {
        return idConsultatie.get();
    }

    public void setIdConsultatie(int idConsultatie) {
        this.idConsultatie.set(idConsultatie);
    }

    public IntegerProperty IdConsultatieProperty() {
        return idConsultatie;
    }
    //endregion

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

    //region diagnostic
    public String getDiagnostic() {
        return diagnostic.get();
    }

    public void setDiagnostic(String Diagnostic) {

        this.diagnostic.set(Diagnostic);
    }

    public StringProperty DiagnosticProperty() {
        return diagnostic;
    }
    //endregion

    //region dataConsultatie
    public Object getDataConsultatie() {
        return dataConsultatie.get();
    }

    public void setDataConsultatie(Date data_nasterii) {
        this.dataConsultatie.set(data_nasterii);
    }

    public SimpleObjectProperty<Date> DataConsultatieProperty() {
        return dataConsultatie;
    }
    //endregion

    //region numeVeterinar
    public String getNumeVeterinar() {
        return numeVeterinar.get();
    }

    public void setNumeVeterinar(String numeVeterinar) {

        this.numeVeterinar.set(numeVeterinar);
    }

    public StringProperty NumeVeterinarProperty() {
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

    public StringProperty PrenumeVeterinarProperty() {
        return prenumeVeterinar;
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

}

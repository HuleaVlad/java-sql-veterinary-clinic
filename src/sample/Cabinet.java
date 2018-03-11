package sample;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.DataAccessObjects.*;
import sun.util.resources.LocaleData;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

public class Cabinet {

    //region Declarari
    @FXML
    private TableColumn<Animale, String> animaleColumnPrenumeProprietar;

    @FXML
    private TextField txtConsultatieIdTratamentSearch;

    @FXML
    private TableColumn<Tratament, String> tratamentColumnNumeMedicament;

    @FXML
    private TableColumn<TipAnimal, String> tipAnimalColumnDescriere;

    @FXML
    private TableColumn<Hrana, Integer> hranaColumnPret;

    @FXML
    private TableColumn<Tratament, Integer> tratamentColumnIdTratament;

    @FXML
    private Button btnRefreshAnimale;

    @FXML
    private Button btnAnimaleCreate;

    @FXML
    private Button btnConsultatiiCreate;
    @FXML
    private TableColumn<Consultatii, String> consultatiiColumnPrenumeVeterinar;

    @FXML
    private DatePicker txtAnimaleIDataNasteriiAdd;

    @FXML
    private TableColumn<Animale, Date> animaleColumnDataNasterii;

    @FXML
    private TableColumn<Tratament, String> tratamentColumnFolosireMedicament;

    @FXML
    private TableColumn<Proprietar, String> proprietarColumnNume;

    @FXML
    private TextField txtConsultatieAnimalSearch;

    @FXML
    private TableColumn<Veterinari, String> veterinariColumnPrenume;

    @FXML
    private TableColumn<Proprietar, Integer> proprietarColumnTelefon;

    @FXML
    private Button btnSaveAnimale;

    @FXML
    private TableColumn<Proprietar, String> proprietarColumnPrenume;

    @FXML
    private Button btnEditAnimale;

    @FXML
    private TextField txtAnimaleNumeVeterinarEdit;

    @FXML
    private TableColumn<Veterinari, String> veterinariColumnEmail;

    @FXML
    private TableColumn<Hrana, Integer> hranaColumnIdHrana;

    @FXML
    private TableColumn<Hrana, String> hranaColumnTipHrana;

    @FXML
    private TableColumn<Veterinari, String> veterinariColumnNume;

    @FXML
    private TableColumn<Veterinari, Integer> veterinariColumnIdVeterinar;

    @FXML
    private Button btnAddConsultatii;

    @FXML
    private Button btnSaveConsultatii;

    @FXML
    private TableColumn<Consultatii, Integer> consultatiiColumnCodConsultatie;


    @FXML
    private Button btnEditConsultatii;

    @FXML
    private TextField txtAnimaleHranaAdd;

    @FXML
    private TextField txtAnimaleTipAnimalAdd;

    @FXML
    private TableColumn<Animale, Integer> animaleColumnGreutate;

    @FXML
    private TextField txtAnimaleNumeProprietarAdd;

    @FXML
    private TextField txtAnimalePrenumeVeterinarEdit;

    @FXML
    private Button btnDelAnimale;

    @FXML
    private TextField txtAnimaleGreutateAdd;

    @FXML
    private TextField txtConsultatieVeterinarSearch;

    @FXML
    private TableColumn<Hrana, String> hranaColumnBrand;

    @FXML
    private TableView<Animale> tableAnimal;

    @FXML
    private TableView<Consultatii> tableConsultatii;

    @FXML
    private TableView<Hrana> tableHrana;

    @FXML
    private TableView<Proprietar> tableProprietar;

    @FXML
    private TableView<TipAnimal> tableTipAnimal;

    @FXML
    private TableView<Tratament> tableTratament;

    @FXML
    private TableView<Veterinari> tableVeterinari;

    @FXML
    private TableColumn<TipAnimal, String> tipAnimalColumnTipAnimal;

    @FXML
    private TableColumn<Proprietar, String> proprietarColumnMail;

    @FXML
    private TableColumn<Veterinari, Integer> veterinariColumnTelefon;

    @FXML
    private TableColumn<Consultatii, Date> consultatiiColumnDataConsultatie;

    @FXML
    private TableColumn<Proprietar, Integer> proprietarColumnIdProprietar;

    @FXML
    private TextField txtAnimaleSexAdd;

    @FXML
    private TableColumn<Animale, String> animaleColumnSex;

    @FXML
    private DatePicker txtConsultatieDataConsultatieAdd;

    @FXML
    private TextField txtAnimaleNumeProprietarSearch;

    @FXML
    private Button btnAddAnimale;

    @FXML
    private TableColumn<Veterinari, String> veterinariColumnAdresa;

    @FXML
    private TableColumn<Animale, String> animaleColumnHrana;

    @FXML TableColumn<Animale, String> animaleColumnTipAnimal;

    @FXML
    private TableColumn<Animale, String> animaleColumnNumeProprietar;

    @FXML
    private TableColumn<Animale, Integer> animaleColumnIdAnimal;

    @FXML
    private TextField txtConsultatieNumeVeterinarAdd;

    @FXML
    private TextField txtConsultatiePrenumeVeterinarAdd;

    @FXML
    private TableColumn<Consultatii, String> consultatiiColumnNumeVeterinar;

    @FXML
    private DatePicker txtConsultatieDataConsultatieSearch;

    @FXML
    private TextField txtAnimalePrenumeProprietarSearch;


    @FXML
    private TextField txtConsultatieTratamentAdd;

    @FXML
    private TableColumn<Consultatii, String> consultatiiColumnTratament;

    @FXML
    private TextField txtAnimalePrenumeProprietarAdd1;

    @FXML
    private TableColumn<TipAnimal, String> tipAnimalColumnNumeAnimal;

    //endregion

    @FXML
    void initialize() {
        this.setVisibleItem(false);
        this.setVisibleItem2(false);
        this.setVisibleItem3(false);
        this.setVisibleItem4(false);

        //Only numbers
        txtAnimaleGreutateAdd.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                txtAnimaleGreutateAdd.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
    }

    //region Methods
    private void loadTableViewAnimaleProprietarGET(String NumeProprietar, String PrenumeProprietar) {
        //Set what values from database we'll use in interface
        animaleColumnIdAnimal.setCellValueFactory(new PropertyValueFactory<>("idAnimal"));
        animaleColumnGreutate.setCellValueFactory(new PropertyValueFactory<>("greutate"));
        animaleColumnSex.setCellValueFactory(new PropertyValueFactory<>("sex"));
        animaleColumnDataNasterii.setCellValueFactory(new PropertyValueFactory<>("dataNasterii"));
        animaleColumnHrana.setCellValueFactory(new PropertyValueFactory<>("tipHrana"));
        animaleColumnNumeProprietar.setCellValueFactory(new PropertyValueFactory<>("numeProprietar"));
        animaleColumnPrenumeProprietar.setCellValueFactory(new PropertyValueFactory<>("prenumeProprietar"));
        animaleColumnTipAnimal.setCellValueFactory(new PropertyValueFactory<>("numeAnimal"));


        //Get values from database
        ArrayList<Animale> animale = AnimaleDAO.AnimaleProprietarGET(NumeProprietar, PrenumeProprietar);

        //Populate TableView from database
        tableAnimal.getItems().setAll(animale);
    }

    private void loadTableViewAnimaleVeterinarGET(String NumeVeterinar, String PrenumeVeterinar) {
        //Set what values from database we'll use in interface
        animaleColumnIdAnimal.setCellValueFactory(new PropertyValueFactory<>("idAnimal"));
        animaleColumnGreutate.setCellValueFactory(new PropertyValueFactory<>("greutate"));
        animaleColumnSex.setCellValueFactory(new PropertyValueFactory<>("sex"));
        animaleColumnDataNasterii.setCellValueFactory(new PropertyValueFactory<>("dataNasterii"));
        animaleColumnHrana.setCellValueFactory(new PropertyValueFactory<>("tipHrana"));
        animaleColumnNumeProprietar.setCellValueFactory(new PropertyValueFactory<>("numeProprietar"));
        animaleColumnPrenumeProprietar.setCellValueFactory(new PropertyValueFactory<>("prenumeProprietar"));
        animaleColumnTipAnimal.setCellValueFactory(new PropertyValueFactory<>("numeAnimal"));

        //Get values from database
        ArrayList<Animale> animale = AnimaleDAO.AnimaleVeterinarGET(NumeVeterinar, PrenumeVeterinar);

        //Populate TableView from database
        tableAnimal.getItems().setAll(animale);
    }

    private void loadTableViewAnimaleREFRESHGET() {
        //Set what values from database we'll use in interface
        animaleColumnIdAnimal.setCellValueFactory(new PropertyValueFactory<>("idAnimal"));
        animaleColumnGreutate.setCellValueFactory(new PropertyValueFactory<>("greutate"));
        animaleColumnSex.setCellValueFactory(new PropertyValueFactory<>("sex"));
        animaleColumnDataNasterii.setCellValueFactory(new PropertyValueFactory<>("dataNasterii"));
        animaleColumnHrana.setCellValueFactory(new PropertyValueFactory<>("tipHrana"));
        animaleColumnNumeProprietar.setCellValueFactory(new PropertyValueFactory<>("numeProprietar"));
        animaleColumnPrenumeProprietar.setCellValueFactory(new PropertyValueFactory<>("prenumeProprietar"));
        animaleColumnTipAnimal.setCellValueFactory(new PropertyValueFactory<>("numeAnimal"));


        //Get values from database
        ArrayList<Animale> animale = AnimaleDAO.AnimaleREFRESHGET();

        //Populate TableView from database
        tableAnimal.getItems().setAll(animale);
    }

    private void loadTableViewConsultatiiConsultatieGET(java.sql.Date dataNasterii, Integer idVeterinar) {
        consultatiiColumnCodConsultatie.setCellValueFactory(new PropertyValueFactory<>("idConsultatie"));
        consultatiiColumnDataConsultatie.setCellValueFactory(new PropertyValueFactory<>("dataConsultatie"));
        consultatiiColumnTratament.setCellValueFactory(new PropertyValueFactory<>("tratament"));
        consultatiiColumnNumeVeterinar.setCellValueFactory(new PropertyValueFactory<>("numeVeterinar"));
        consultatiiColumnPrenumeVeterinar.setCellValueFactory(new PropertyValueFactory<>("prenumeVeterinar"));

        ArrayList<Consultatii> consultatiiArrayList=ConsultatiiDAO.ConsultatiiConsultatieGET(dataNasterii,idVeterinar);

        tableConsultatii.getItems().setAll(consultatiiArrayList);
    }

    private void loadTableViewConsultatiiAnimalGET(String numeAnimal, Integer idTratament) {
        consultatiiColumnCodConsultatie.setCellValueFactory(new PropertyValueFactory<>("idConsultatie"));
        consultatiiColumnDataConsultatie.setCellValueFactory(new PropertyValueFactory<>("dataConsultatie"));
        consultatiiColumnTratament.setCellValueFactory(new PropertyValueFactory<>("tratament"));
        consultatiiColumnNumeVeterinar.setCellValueFactory(new PropertyValueFactory<>("numeVeterinar"));
        consultatiiColumnPrenumeVeterinar.setCellValueFactory(new PropertyValueFactory<>("prenumeVeterinar"));

        ArrayList<Consultatii> consultatiiArrayList=ConsultatiiDAO.ConsultatiiAnimalGET(numeAnimal,idTratament);

        tableConsultatii.getItems().setAll(consultatiiArrayList);
    }

    private void loadTableViewConsultatiiREFRESHGET() {
        //Set what values from database we'll use in interface
        consultatiiColumnCodConsultatie.setCellValueFactory(new PropertyValueFactory<>("idConsultatie"));
        consultatiiColumnDataConsultatie.setCellValueFactory(new PropertyValueFactory<>("dataConsultatie"));
        consultatiiColumnTratament.setCellValueFactory(new PropertyValueFactory<>("numeMedicament"));
        consultatiiColumnNumeVeterinar.setCellValueFactory(new PropertyValueFactory<>("numeVeterinar"));
        consultatiiColumnPrenumeVeterinar.setCellValueFactory(new PropertyValueFactory<>("prenumeVeterinar"));


        ArrayList<Consultatii> consultatii=ConsultatiiDAO.ConsultatiiREFRESHGET();

        tableConsultatii.getItems().setAll(consultatii);
    }

    private void loadTableViewHranaREFRESHGET() {
        //Set what values from database we'll use in interface
        hranaColumnIdHrana.setCellValueFactory(new PropertyValueFactory<>("idHrana"));
        hranaColumnTipHrana.setCellValueFactory(new PropertyValueFactory<>("tipHrana"));
        hranaColumnBrand.setCellValueFactory(new PropertyValueFactory<>("brand"));
        hranaColumnPret.setCellValueFactory(new PropertyValueFactory<>("pret"));

        ArrayList<Hrana> hranaArrayList= HranaDAO.HranaGET();

        tableHrana.getItems().setAll(hranaArrayList);
    }

    private void loadTableViewProprietarREFRESHGET() {
        //Set what values from database we'll use in interface
        proprietarColumnIdProprietar.setCellValueFactory(new PropertyValueFactory<>("idProprietar"));
        proprietarColumnNume.setCellValueFactory(new PropertyValueFactory<>("numeProprietar"));
        proprietarColumnPrenume.setCellValueFactory(new PropertyValueFactory<>("prenumeProprietar"));
        proprietarColumnMail.setCellValueFactory(new PropertyValueFactory<>("mailProprietar"));
        proprietarColumnTelefon.setCellValueFactory(new PropertyValueFactory<>("telefonProprietar"));

        ArrayList<Proprietar> proprietarArrayList= ProprietarDAO.ProprietarGET();

        tableProprietar.getItems().setAll(proprietarArrayList);
    }

    private void loadTableViewTipAnimalREFRESHGET() {
        //Set what values from database we'll use in interface
        tipAnimalColumnTipAnimal.setCellValueFactory(new PropertyValueFactory<>("idTipAnimal"));
        tipAnimalColumnNumeAnimal.setCellValueFactory(new PropertyValueFactory<>("numeAnimal"));
        tipAnimalColumnDescriere.setCellValueFactory(new PropertyValueFactory<>("descriereAnimal"));

        ArrayList<TipAnimal> tipAnimalArrayList= TipAnimalDAO.TipAnimalGET();

        tableTipAnimal.getItems().setAll(tipAnimalArrayList);
    }

    private void loadTableViewTratamentREFRESHGET() {
        //Set what values from database we'll use in interface
        tratamentColumnIdTratament.setCellValueFactory(new PropertyValueFactory<>("idTratament"));
        tratamentColumnNumeMedicament.setCellValueFactory(new PropertyValueFactory<>("numeMedicament"));
        tratamentColumnFolosireMedicament.setCellValueFactory(new PropertyValueFactory<>("folosireMedicament"));

        ArrayList<Tratament> tratamentArrayList= TratamentDAO.TratamentGET();

        tableTratament.getItems().setAll(tratamentArrayList);
    }

    private void loadTableViewVeterinariREFRESHGET() {
        //Set what values from database we'll use in interface
        veterinariColumnIdVeterinar.setCellValueFactory(new PropertyValueFactory<>("idVeterinar"));
        veterinariColumnNume.setCellValueFactory(new PropertyValueFactory<>("numeVeterinar"));
        veterinariColumnPrenume.setCellValueFactory(new PropertyValueFactory<>("prenumeVeterinar"));
        veterinariColumnAdresa.setCellValueFactory(new PropertyValueFactory<>("adresaVeterinar"));
        veterinariColumnEmail.setCellValueFactory(new PropertyValueFactory<>("emailVeterinar"));
        veterinariColumnTelefon.setCellValueFactory(new PropertyValueFactory<>("telefonVeterinar"));

        ArrayList<Veterinari> veterinari= VeterinariDAO.VeterinariGET();

        tableVeterinari.getItems().setAll(veterinari);
    }

    @FXML
    void setBtnRefreshDateAnimaleOnClick() {
        loadTableViewAnimaleREFRESHGET();
        tableAnimal.setDisable(false);

    }

    @FXML
    void setBtnDeleteAnimaleOnClick() {
        AnimaleDAO.AnimaleDEL(tableAnimal.getSelectionModel().getSelectedItem());

    }

    @FXML
    void setBtnAddAnimaleOnClick() {
        this.setVisibleItem(true);
        tableAnimal.setDisable(true);
        btnSaveAnimale.setVisible(false);
    }

    @FXML
    void setBtnSaveAnimaleOnClick() {
        this.setVisibleItem3(false);
        tableAnimal.setDisable(false);

        Animale animal = new Animale();
        if (tableAnimal.getItems().size() != 0) {
            animal.setIdAnimal(tableAnimal.getSelectionModel().getSelectedItem().getIdAnimal());
            animal.setGreutate(Integer.valueOf(txtAnimaleGreutateAdd.getText()));
            animal.setdataNasterii(java.sql.Date.valueOf(txtAnimaleIDataNasteriiAdd.getValue()));
            animal.setSex(txtAnimaleSexAdd.getText());
            animal.setTipHrana(txtAnimaleHranaAdd.getText());
            animal.setNumeProprietar(txtAnimaleNumeProprietarAdd.getText());
            animal.setPrenumeProprietar(txtAnimalePrenumeProprietarAdd1.getText());
            animal.setNumeAnimal(txtAnimaleTipAnimalAdd.getText());
        }
        AnimaleDAO.AnimaleUPD(animal);
    }

    @FXML
    void setBtnEditAnimaleOnClick() {
        this.setVisibleItem3(true);
        tableAnimal.setDisable(true);
        btnAnimaleCreate.setVisible(false);
    }

    @FXML
    void setBtnAnimaleCreateOnClick() {
        this.setVisibleItem(false);
        this.tableConsultatii.setDisable(false);
        tableAnimal.setDisable(false);
        Animale animal = new Animale();

        ///animal.setIdAnimal(tableAnimal.getSelectionModel().getSelectedItem().getIdAnimal());
        animal.setGreutate(Objects.equals(txtAnimaleGreutateAdd.getText(), "") ? -1 : Integer.valueOf(txtAnimaleGreutateAdd.getText()));
        animal.setdataNasterii(java.sql.Date.valueOf(txtAnimaleIDataNasteriiAdd.getValue()));
        animal.setSex(txtAnimaleSexAdd.getText());
        animal.setTipHrana(txtAnimaleHranaAdd.getText());
        animal.setNumeProprietar(txtAnimaleNumeProprietarAdd.getText());
        animal.setPrenumeProprietar(txtAnimalePrenumeProprietarAdd1.getText());
        animal.setNumeAnimal(txtAnimaleTipAnimalAdd.getText());

        AnimaleDAO.AnimaleINS(animal);
    }

    @FXML
    void setBtnSearchAnimaleProprietarOnClick() {
        this.loadTableViewAnimaleProprietarGET(txtAnimaleNumeProprietarSearch.getText(), txtAnimalePrenumeProprietarSearch.getText());
    }

    @FXML
    void setBtnSearchAnimaleVeterinarOnClick() {
        this.loadTableViewAnimaleVeterinarGET(txtAnimaleNumeVeterinarEdit.getText(), txtAnimalePrenumeVeterinarEdit.getText());
    }

    @FXML
    void setBtnAddConsultatiiOnClick() {
        this.setVisibleItem2(true);
        tableConsultatii.setDisable(true);

    }

    @FXML
    void setBtnDeleteConsultatiiOnClick() {
        ConsultatiiDAO.ConsultatiiDEL(tableConsultatii.getSelectionModel().getSelectedItem());
    }

    @FXML
    void setBtnRefreshConsultatiiOnClick() {
        tableConsultatii.setDisable(false);
        this.loadTableViewConsultatiiREFRESHGET();
    }

    @FXML
    void setBtnSaveConsultatiiOnClick() {
        this.setVisibleItem4(false);

        Consultatii consultatii = new Consultatii();
        if (tableAnimal.getItems().size() != 0) {
            consultatii.setIdConsultatie(tableConsultatii.getSelectionModel().getSelectedItem().getIdAnimal());
            consultatii.setNumeMedicament(txtConsultatieTratamentAdd.getText());
            consultatii.setDataConsultatie(java.sql.Date.valueOf(txtConsultatieDataConsultatieAdd.getValue()));
            consultatii.setNumeVeterinar(txtConsultatieNumeVeterinarAdd.getText());
            consultatii.setPrenumeVeterinar(txtConsultatiePrenumeVeterinarAdd.getText());
        }
        ConsultatiiDAO.ConsultatiiUPD(consultatii);
    }

    @FXML
    void setBtnSearchConsultatieOnClick() {
        this.loadTableViewConsultatiiConsultatieGET(java.sql.Date.valueOf(txtConsultatieDataConsultatieSearch.getValue()),Integer.valueOf(txtConsultatieVeterinarSearch.getText()));
    }

    @FXML
    void setBtnSearchConsultatieAnimalOnClick() {
        this.loadTableViewConsultatiiAnimalGET(txtConsultatieAnimalSearch.getText(),Integer.valueOf(txtConsultatieIdTratamentSearch.getText()));
    }

    @FXML
    void setBtnEditConsultatiiOnClick() {
        this.setVisibleItem4(true);
    }

    @FXML
    void setBtnConsultatiiCreateOnClick(){
        this.setVisibleItem2(false);
        this.tableConsultatii.setDisable(false);
        Consultatii consultatii=new Consultatii();
        //consultatii.setIdConsultatie(tableConsultatii.getSelectionModel().getSelectedItem().getIdAnimal());
        consultatii.setNumeMedicament(txtConsultatieTratamentAdd.getText());
        consultatii.setDataConsultatie(java.sql.Date.valueOf(txtConsultatieDataConsultatieAdd.getValue()));
        consultatii.setNumeVeterinar(txtConsultatieNumeVeterinarAdd.getText());
        consultatii.setPrenumeVeterinar(txtConsultatiePrenumeVeterinarAdd.getText());

        ConsultatiiDAO.ConsultatiiINS(consultatii);
    }

    @FXML
    void setBtnRefreshDateHranaOnClick() {
        this.loadTableViewHranaREFRESHGET();
    }

    @FXML
    void setBtnRefreshProprietarOnClick() {
        this.loadTableViewProprietarREFRESHGET();
    }

    @FXML
    void setBtnRefreshDateTipAnimalOnClick() {
        this.loadTableViewTipAnimalREFRESHGET();
    }

    @FXML
    void setBtnRefreshDateTratamentOnClick() {
        this.loadTableViewTratamentREFRESHGET();
    }

    @FXML
    void setBtnRefreshDateVeterinariOnClick() {
        this.loadTableViewVeterinariREFRESHGET();
    }
    //endregion

    //region Private Methods
    private void setVisibleItem(Boolean visibleItem) {
        this.txtAnimaleGreutateAdd.setVisible(visibleItem);
        this.txtAnimaleSexAdd.setVisible(visibleItem);
        this.txtAnimaleIDataNasteriiAdd.setVisible(visibleItem);
        this.txtAnimaleHranaAdd.setVisible(visibleItem);
        this.txtAnimaleNumeProprietarAdd.setVisible(visibleItem);
        this.txtAnimalePrenumeProprietarAdd1.setVisible(visibleItem);
        this.btnAnimaleCreate.setVisible(visibleItem);
        this.txtAnimaleTipAnimalAdd.setVisible(visibleItem);
    }

    private void setVisibleItem3(Boolean visibleItem3) {
        this.btnSaveAnimale.setVisible(visibleItem3);
        this.txtAnimaleGreutateAdd.setVisible(visibleItem3);
        this.txtAnimaleSexAdd.setVisible(visibleItem3);
        this.txtAnimaleIDataNasteriiAdd.setVisible(visibleItem3);
        this.txtAnimaleHranaAdd.setVisible(visibleItem3);
        this.txtAnimaleNumeProprietarAdd.setVisible(visibleItem3);
        this.txtAnimalePrenumeProprietarAdd1.setVisible(visibleItem3);
        this.txtAnimaleTipAnimalAdd.setVisible(visibleItem3);


    }

    private void setVisibleItem2(Boolean visibleItem2) {
        this.txtConsultatieDataConsultatieAdd.setVisible(visibleItem2);
        this.txtConsultatieTratamentAdd.setVisible(visibleItem2);
        this.txtConsultatieNumeVeterinarAdd.setVisible(visibleItem2);
        this.txtConsultatiePrenumeVeterinarAdd.setVisible(visibleItem2);
        this.btnConsultatiiCreate.setVisible(visibleItem2);
    }

    private void setVisibleItem4(Boolean visibleItem4) {
        this.txtConsultatieDataConsultatieAdd.setVisible(visibleItem4);
        this.txtConsultatieTratamentAdd.setVisible(visibleItem4);
        this.txtConsultatieNumeVeterinarAdd.setVisible(visibleItem4);
        this.txtConsultatiePrenumeVeterinarAdd.setVisible(visibleItem4);
        this.btnSaveConsultatii.setVisible(visibleItem4);
    }
    //endregion
}

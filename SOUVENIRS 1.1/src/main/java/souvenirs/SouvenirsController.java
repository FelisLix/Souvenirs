package souvenirs;


import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.DoubleStringConverter;
import souvenirs.IO.IO;
import souvenirs.Souvenirs.Manufacturer;
import souvenirs.Souvenirs.Souvenir;
import souvenirs.Souvenirs.SouvenirsProcessor;

import java.util.List;

public class SouvenirsController {

    public Button save;
    private List<Souvenir> souvenirsList;
    public TableView<Souvenir> souvenirTable;
    public TableColumn<Souvenir, String> souvenirTableName;
    public TableColumn<Souvenir, String> souvenirTableManufacturer;
    public TableColumn<Souvenir, String> souvenirTableCountry;
    public TableColumn<Souvenir, String> souvenirTableDate;
    public TableColumn<Souvenir, Double> souvenirTablePrice;
    public ComboBox<String> optionSort;
    public TextField optionGet;
    public Button sort;
    public TextField getName;
    public TextField getManufacturer;
    public TextField getCountry;
    public TextField getDate;
    public TextField getPrice;
    public Button add;
    public Button showAll;
    public Label information;

    public void initialize(){
        IO io = new IO();

        souvenirsList = io.readObjects();

        souvenirTable.setItems(FXCollections.observableList(souvenirsList));
        ObservableList<String> options = FXCollections.observableArrayList(
                "Вивести інформацію про сувеніри заданого виробника",
                "Вивести інформацію про сувеніри, виготовлені в заданій країні",
                "Вивести інформацію про виробників, чиї ціни на сувеніри менше заданої",
                "Вивести інформацію по всіх виробниках та, для кожного виробника вивести інформацію про всі сувеніри, які він виробляє",
                "Вивести інформацію про виробників заданого сувеніру, виробленого у заданому року",
                "Для кожного року вивести список сувенірів, зроблених цього року",
                "Видалити заданого виробника та його сувеніри");
        optionSort.setItems(options);

        souvenirTableName.setCellFactory(TextFieldTableCell.forTableColumn());
        souvenirTableName.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getName()));

        souvenirTableManufacturer.setCellFactory(TextFieldTableCell.forTableColumn());
        souvenirTableManufacturer.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getManufacturer().getName()));

        souvenirTableCountry.setCellFactory(TextFieldTableCell.forTableColumn());
        souvenirTableCountry.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getManufacturer().getCountry()));

        souvenirTableDate.setCellFactory(TextFieldTableCell.forTableColumn());
        souvenirTableDate.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getDate()));

        souvenirTablePrice.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        souvenirTablePrice.setCellValueFactory(c -> new SimpleDoubleProperty(c.getValue().getPrice()).asObject());
    }

    public void showResult() {
        SouvenirsProcessor souvenirsProcessor = new SouvenirsProcessor();
        switch (optionSort.getValue()){
            case "Вивести інформацію про сувеніри заданого виробника" ->
                    souvenirTable.setItems(FXCollections.observableList(souvenirsProcessor.sortByManufacturer(souvenirsList, optionGet.getText())));
            case "Вивести інформацію про сувеніри, виготовлені в заданій країні" ->
                    souvenirTable.setItems(FXCollections.observableList(souvenirsProcessor.sortByCountry(souvenirsList, optionGet.getText())));
            case "Вивести інформацію про виробників, чиї ціни на сувеніри менше заданої" ->
                    souvenirTable.setItems(FXCollections.observableList(souvenirsProcessor.sortByPrice(souvenirsList, Double.parseDouble(optionGet.getText()))));
            case "Вивести інформацію по всіх виробниках та, для кожного виробника вивести інформацію про всі сувеніри, які він виробляє" ->
                    souvenirTable.setItems(FXCollections.observableList(souvenirsProcessor.sortManufacturer(souvenirsList)));
            case "Вивести інформацію про виробників заданого сувеніру, виробленого у заданому року" ->
                    souvenirTable.setItems(FXCollections.observableList(souvenirsProcessor.sortByYearAndName(souvenirsList,
                            optionGet.getText().substring(0, optionGet.getText().length()-5),
                            optionGet.getText().substring(optionGet.getText().length()-4))));
            case "Для кожного року вивести список сувенірів, зроблених цього року" ->
                    souvenirTable.setItems(FXCollections.observableList(souvenirsProcessor.sortByYear(souvenirsList)));
            case "Видалити заданого виробника та його сувеніри" -> {
                souvenirTable.setItems(FXCollections.observableList(souvenirsProcessor.deleteManufacturer(souvenirsList, optionGet.getText())));
                souvenirsList = souvenirsProcessor.deleteManufacturer(souvenirsList, optionGet.getText());
            }
        }
    }

    public void editSouvenirName(TableColumn.CellEditEvent<Souvenir, String> souvenirStringCellEditEvent) {
        souvenirStringCellEditEvent.getTableView().getItems().get(souvenirStringCellEditEvent.getTablePosition().getRow()).setName(souvenirStringCellEditEvent.getNewValue());
    }

    public void editManufacturerName(TableColumn.CellEditEvent<Souvenir, String> souvenirStringCellEditEvent) {
        souvenirStringCellEditEvent.getTableView().getItems().get(souvenirStringCellEditEvent.getTablePosition().getRow()).setManufacturerName(souvenirStringCellEditEvent.getNewValue());
    }

    public void editManufacturerCountry(TableColumn.CellEditEvent<Souvenir, String> souvenirStringCellEditEvent) {
        souvenirStringCellEditEvent.getTableView().getItems().get(souvenirStringCellEditEvent.getTablePosition().getRow()).setManufacturerCountry(souvenirStringCellEditEvent.getNewValue());
    }

    public void editSouvenirDate(TableColumn.CellEditEvent<Souvenir, String> souvenirStringCellEditEvent) {
        souvenirStringCellEditEvent.getTableView().getItems().get(souvenirStringCellEditEvent.getTablePosition().getRow()).setDate(souvenirStringCellEditEvent.getNewValue());
    }

    public void editSouvenirPrice(TableColumn.CellEditEvent<Souvenir, Double> souvenirDoubleCellEditEvent) {
        souvenirDoubleCellEditEvent.getTableView().getItems().get(souvenirDoubleCellEditEvent.getTablePosition().getRow()).setPrice(souvenirDoubleCellEditEvent.getNewValue());
    }

    public void addNewSouvenir() {
        Souvenir souvenir = new Souvenir();
        souvenir.add(souvenirsList, (new Souvenir(getName.getText(), new Manufacturer(getManufacturer.getText(), getCountry.getText()), getDate.getText(), Double.parseDouble(getPrice.getText()))));
        souvenirTable.setItems(FXCollections.observableList(souvenirsList));
    }

    public void writeToFile() {
        IO io = new IO();
        io.writeObjects(souvenirsList);
    }

    public void showAll() {
        souvenirTable.setItems(FXCollections.observableList(souvenirsList));
    }
}

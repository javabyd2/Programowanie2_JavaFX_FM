package com.sda.javafx.Controller;

import com.sda.javafx.Main;
import com.sda.javafx.Model.Person;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;


public class Controller {


    @FXML
    private TableView<Person> personTableView;
    @FXML
    private TableColumn<Person, String> firstNameColumn;
    @FXML
    private TableColumn<Person, String> lastNameColumn;
    @FXML
    private Label labelFirstName;
    @FXML
    private Label labelLastName;
    @FXML
    private Label labelStreet;
    @FXML
    private Label labelCity;
    @FXML
    private Label labelZIP;
    @FXML
    private Label labelBirth;


    //referencja klasy main
    private Main main;

    public void setMain(Main main) {
        this.main = main;
        personTableView.setItems(main.getPerson());
    }

    public Controller() {
    }


    @FXML
    private void initialize() {

        firstNameColumn.setCellValueFactory(data -> data.getValue().firstnameProperty());
        lastNameColumn.setCellValueFactory(data -> data.getValue().lastnameProperty());

        personTableView.getSelectionModel().selectedItemProperty().addListener((observable, x, y) -> showPerson(y));

    }


    public void showPerson(Person person) {

        labelFirstName.setText(person.getFirstname());
        System.out.println(person.getFirstname());

        labelLastName.setText(person.getLastname());
        labelStreet.setText(person.getStreet());
        labelCity.setText(person.getCity());
        labelZIP.setText(person.getZipCode());
        labelBirth.setText(person.getBirthday());


    }
}

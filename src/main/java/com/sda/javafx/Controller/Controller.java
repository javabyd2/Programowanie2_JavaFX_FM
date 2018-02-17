package com.sda.javafx.Controller;

import com.sda.javafx.Main;
import com.sda.javafx.Model.Person;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.awt.event.ActionListener;


public class Controller {


    @FXML
    private TableView<Person> personTableView;
    @FXML
    private TableColumn<Person, String> firstNameColumn;
    @FXML
    private TableColumn<Person, String> lastNameColumn;
    @FXML
    private Label kolumnaName1;
    @FXML
    private Label kolumnaName2;
    @FXML
    private Label kolumnaName3;
    @FXML
    private Label kolumnaName4;
    @FXML
    private Label kolumnaName5;
    @FXML
    private Label kolumnaName6;


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

        kolumnaName1.setText(person.getFirstname());
        System.out.println(person.getFirstname());

        kolumnaName2.setText(person.getLastname());
        kolumnaName3.setText(person.getStreet());
        kolumnaName4.setText(person.getCity());
        kolumnaName5.setText(person.getZipCode());
        kolumnaName6.setText(person.getBirthday());


    }
}

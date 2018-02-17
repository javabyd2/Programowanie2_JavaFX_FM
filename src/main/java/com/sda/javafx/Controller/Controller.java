package com.sda.javafx.Controller;

import com.sda.javafx.Main;
import com.sda.javafx.Model.Person;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;


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

    @FXML
    private void deletePerson() {

        int index = personTableView.getSelectionModel().getSelectedIndex();
        if (index >= 0) {
            personTableView.getItems().remove(index);

            Alert alert = new Alert((Alert.AlertType.INFORMATION));

            alert.setTitle("Info");
            alert.setHeaderText("Usunięcie potwierdzone.");
            alert.setContentText("Usunąłeś " + main.getPerson().get(index).getFirstname() + " " + main.getPerson().get(index).getLastname());
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Błąd");
            alert.setHeaderText("TO jest błĄD");
            alert.setContentText("Nie mozna usunac.");
            alert.showAndWait();
        }


    }

    @FXML
    private void addPerson(ActionEvent actionEvent) throws IOException {

        VBox addPersonLayout = FXMLLoader.load(getClass().getClassLoader().getResource("newPerson.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(addPersonLayout);
        stage.setScene(scene);
        stage.show();


    }

}





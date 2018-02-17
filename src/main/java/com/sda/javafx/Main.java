package com.sda.javafx;

import com.sda.javafx.Controller.Controller;
import com.sda.javafx.Model.Person;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;

    private ObservableList<Person> personObservableList = FXCollections.observableArrayList();

//    static {
//
//    }


    public Main (){

        personObservableList.add(new Person("Jan", "Kowalski","ulica","ww","1","2"));
        personObservableList.add(new Person("Adam", "Jankowski","ulica","ww","22","33"));
        personObservableList.add(new Person("Ola", "D","ulica","BYD","1982","22"));
        personObservableList.add(new Person("Ania", "Z","ulica","TOR","1988","32"));
        personObservableList.add(new Person("Iza", "F","ulica","NY","1999","52"));
        personObservableList.add(new Person("Filip", "K","ulica","WRO","1821","62"));
        personObservableList.add(new Person("Stefan", "L","ulica","ZAK","2000","27"));

    }

    public ObservableList<Person> getPerson(){
        return  personObservableList;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;

        initRootLayout();
        showPersonLayout();


    }

    public void initRootLayout() throws IOException {
        rootLayout = FXMLLoader.load(getClass().getClassLoader().getResource("rootLayout.fxml"));

        Scene scene = new Scene(rootLayout);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public void showPersonLayout() throws IOException {

        FXMLLoader loader = new FXMLLoader((getClass().getClassLoader().getResource("mojeFX.fxml")));

        AnchorPane person = loader.load();
        rootLayout.setCenter(person);

        Controller controller =  loader.getController();

        controller.setMain(this);
    }


    public static void main(String[] args) {

        launch(args);
    }
}

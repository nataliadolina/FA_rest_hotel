package com.example.hotelfrontend;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class BookingApplication extends Application {
    public static Requests requests;

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        requests = new Requests();

        FXMLLoader fxmlLoader = new FXMLLoader(BookingApplication.class.getResource("primary.fxml"));
        scene = new Scene(fxmlLoader.load(), 345, 424);
        stage.setTitle("Booking application");
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(BookingApplication.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }
}
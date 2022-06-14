package com.example.projectfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.stage.Stage;
import java.io.IOException;

import static com.example.projectfx.HelloController.*;

public class HelloApplication extends Application {

        @Override

        public void start(Stage stage) throws IOException {

            initializeDB();

            System.out.println(getClass());
            Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
            stage.setTitle("User Registration");
            stage.setScene(new Scene(root, 500, 300));
            stage.show();
        }
//        public void start(Stage stage) throws IOException {
//
//            initializeDB();
//
//            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
//            Scene scene = new Scene(fxmlLoader.load());
//            stage.setTitle("Registration!");
//            stage.setScene(scene);
//            stage.show();
//        }



    public static void main(String[] args) {

        launch();
    }
}
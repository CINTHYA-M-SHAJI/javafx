package com.example.projectfx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.sql.Statement;
import java.sql.*;
import javafx.stage.Window;

public class HelloController {
    private static Statement stmt;

    public static void initializeDB() {
        try {
// Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
//

            System.out.println("Driver loaded");
// Establish a connection
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/car_rental", "root", "");
            System.out.println("Database connected");

            // Create a statement
            HelloController.stmt = connection.createStatement();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    @FXML
    private TextField Name;


    @FXML
    private TextField Email;

    @FXML
    private TextField Licence;

    @FXML
    private TextField Address;

    @FXML
    private PasswordField Password;

    @FXML
    private Button submitButton;


    @FXML
    public void submit(ActionEvent event) throws SQLException {

        Window owner = submitButton.getScene().getWindow();

        System.out.println(Name.getText());
        System.out.println(Address.getText());
        System.out.println(Licence.getText());
        System.out.println(Email.getText());
        System.out.println(Password.getText());
        if (Name.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner,"Form Error!",  "Please enter your name");
            return;
        }

        if (Email.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner,"Form Error!",
                    "Please enter your email id");
            return;
        }


        if (Licence.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR,owner, "Form Error!", "Please enter your Licence number");
            return;
        }

        if (Address.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner,"Form Error!", "Please enter your address");
            return;
        }

        if (Password.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner,"Form Error!",
                    "Please enter a password");
            return;
        }

        String names = Name.getText();
        String address = Address.getText();
        String licence = Licence.getText();
        String emailId = Email.getText();
        String password = Password.getText();

        JdbcDao jdbcDao = new JdbcDao();
        jdbcDao.insertRecord(names,emailId,licence,  address,  password);

        showAlert(Alert.AlertType.CONFIRMATION, owner,"Registration Successful!",
                "Welcome " + Name.getText());
    }


    private static void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.show();
    }
}


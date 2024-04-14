package com.lcaohoanq.loginsignupjavafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class SignupController {

    @FXML
    private TextArea confirmPassword;

    @FXML
    private TextArea password;

    @FXML
    private Button signInHere;

    @FXML
    private Button submit;

    @FXML
    private TextArea username;

    @FXML
    void onCLickSignInHere(ActionEvent event) {
        try {
            // Load the login view
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login-view.fxml"));
            Parent loginView = fxmlLoader.load();

            // Create a new stage for the login view
            Stage loginStage = new Stage();
            loginStage.setTitle("Login");
            loginStage.setScene(new Scene(loginView));

            // Show the stage to display the login form
            loginStage.show();

            // Close the current stage (sign-up form)
            signInHere.getScene().getWindow().hide();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onClickSubmit(ActionEvent event) {
        String user = username.getText();
        String pass = password.getText();
        String confirmPass = confirmPassword.getText();
        if(pass.equals(confirmPass)) {
            System.out.println("Signup successful");
        } else {
            System.out.println("Signup failed");
        }
    }

}

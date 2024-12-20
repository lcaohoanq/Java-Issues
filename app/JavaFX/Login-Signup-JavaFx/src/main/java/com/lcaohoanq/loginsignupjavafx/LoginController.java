package com.lcaohoanq.loginsignupjavafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class LoginController {

    @FXML
    private TextArea password;

    @FXML
    private Button signUpHere;

    @FXML
    private Button submit;

    @FXML
    private TextArea username;

    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    void onCLickSignUpHere(ActionEvent event) {
        try {
            // Load the sign-up view
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("signup-view.fxml"));
            Parent signUpView = fxmlLoader.load();

            // Create a new stage for the sign-up view
            Stage signUpStage = new Stage();
            signUpStage.setTitle("Sign Up");
            signUpStage.setScene(new Scene(signUpView));

            if(stage != null){
                stage.close();
            }

            // Show the stage to display the sign-up form
            signUpStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onClickSubmit(ActionEvent event) {
        String user = username.getText();
        String pass = password.getText();
        if(user.equals("admin") && pass.equals("admin")) {
            System.out.println("Login successful");
        } else {
            System.out.println("Login failed");
        }
    }

}

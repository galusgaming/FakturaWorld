package pl.galusgaming.fakturaworld.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import pl.galusgaming.fakturaworld.services.LoginService;

public class LoginController {
    @FXML
    private Label errorLabel;
    @FXML
    private TextField login;
    @FXML
    private PasswordField password;

    public void initialize() {
        errorLabel.setText("");
        login.setOnKeyPressed(e->{
            if(e.getCode() == KeyCode.ENTER) {
                password.requestFocus();
            }
        });
        password.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                onLoginButtonClick(null);
            }
        });
    }
    @FXML
    private void onLoginButtonClick(ActionEvent event) {
        String login = this.login.getText();
        String password = this.password.getText();
        if (login.isEmpty() && password.isEmpty()) {
            errorLabel.setStyle("-fx-text-fill: red;");
            errorLabel.setText("Login and password are empty!");
            return;
        } else if (login.isEmpty()) {
            errorLabel.setStyle("-fx-text-fill: red;");
            errorLabel.setText("Login is empty!");
            return;
        } else if (password.isEmpty()) {
            errorLabel.setStyle("-fx-text-fill: red;");
            errorLabel.setText("Password is empty!");
            return;
        }
        boolean isAuth = LoginService.auth(login, password);
        if(isAuth) {
            errorLabel.setStyle("-fx-text-fill: green;");
            errorLabel.setText("Login successful!");
        } else {
            errorLabel.setStyle("-fx-text-fill: red;");
            errorLabel.setText("Login failed!");
        }
    }
}
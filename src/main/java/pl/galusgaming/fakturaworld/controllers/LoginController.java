package pl.galusgaming.fakturaworld.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import org.kordamp.bootstrapfx.BootstrapFX;
import pl.galusgaming.fakturaworld.HelloApplication;
import pl.galusgaming.fakturaworld.services.LoginService;

public class LoginController {
    @FXML
    private Label errorLabel;
    @FXML
    private TextField login;
    @FXML
    private PasswordField password;
    @FXML
    private Button btnLogin;


    public void initialize() {
        btnLogin.getStyleClass().addAll("btn", "btn-primary");
        errorLabel.setText("");
        login.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
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
        errorLabel.getStyleClass().clear(); // Clear previous styles

        if (login.isEmpty() && password.isEmpty()) {
            errorLabel.getStyleClass().addAll("alert", "alert-danger");
            errorLabel.setText("Login and password are empty!");
            return;
        } else if (login.isEmpty()) {
            errorLabel.getStyleClass().addAll("alert", "alert-danger");
            errorLabel.setText("Login is empty!");
            return;
        } else if (password.isEmpty()) {
            errorLabel.getStyleClass().addAll("alert", "alert-danger");
            errorLabel.setText("Password is empty!");
            return;
        }

        boolean isAuth = LoginService.auth(login, password);
        if (isAuth) {
            errorLabel.getStyleClass().addAll("alert", "alert-success");
            errorLabel.setText("Login successful!");

            try {
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("dashboard-view.fxml"));
                String css = HelloApplication.class.getResource("dashboard.css").toExternalForm();
                HelloApplication.getStage().getScene().getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());
                HelloApplication.getStage().getScene().getStylesheets().add(css);
                HelloApplication.getStage().getScene().setRoot(fxmlLoader.load());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            errorLabel.getStyleClass().addAll("alert", "alert-danger");
            errorLabel.setText("Login failed!");
        }
    }
}
package pl.galusgaming.fakturaworld.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import pl.galusgaming.fakturaworld.HelloApplication;

public class DashboardController {


    @FXML
    private ListView<String> newsList;

    @FXML
    private void onManageInvoices(ActionEvent event) {
        loadView("invoice-view.fxml", "invoice.css");
    }

    @FXML
    private void onManageClients(ActionEvent event) {
        loadView("client-view.fxml", "client.css");
    }

    @FXML
    private void onManageProducts(ActionEvent event) {
        loadView("product-view.fxml", "product.css");
    }

    private void loadView(String fxmlFile, String cssFile) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(fxmlFile));
            String css = HelloApplication.class.getResource(cssFile).toExternalForm();
            HelloApplication.getStage().getScene().getStylesheets().add(css);
            HelloApplication.getStage().getScene().setRoot(fxmlLoader.load());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void initialize() {
        
        newsList.getItems().addAll(
                "Update 1.0: New features added",
                "Update 1.1: Bug fixes and improvements",
                "Update 1.2: Performance enhancements"
        );
    }
}
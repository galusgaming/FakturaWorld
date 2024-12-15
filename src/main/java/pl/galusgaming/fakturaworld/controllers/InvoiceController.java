package pl.galusgaming.fakturaworld.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import pl.galusgaming.fakturaworld.HelloApplication;

public class InvoiceController {
    @FXML
    private TextField searchField;
    @FXML
    private TableView<?> invoiceTable;
    @FXML
    private TableColumn<?, ?> invoiceNumberColumn;
    @FXML
    private TableColumn<?, ?> customerNameColumn;
    @FXML
    private TableColumn<?, ?> amountColumn;
    @FXML
    private TableColumn<?, ?> statusColumn;
    @FXML
    private Button addInvoiceButton;
    @FXML
    private Button editInvoiceButton;
    @FXML
    private Button deleteInvoiceButton;

    @FXML
    private void onSearchButtonClick() {
        // Handle search button click
    }

    @FXML
    private void onAddInvoiceButtonClick() {
        // Handle add invoice button click
    }

    @FXML
    private void onEditInvoiceButtonClick() {
        // Handle edit invoice button click
    }

    @FXML
    private void onDeleteInvoiceButtonClick() {
        // Handle delete invoice button click
    }
    @FXML
    public void OnBtnReturnClick(ActionEvent actionEvent) {

        loadView("dashboard-view.fxml", "dashboard.css");
    }

    public void onNewFile(ActionEvent actionEvent) {
    }

    public void onOpenFile(ActionEvent actionEvent) {
    }

    public void onSaveFile(ActionEvent actionEvent) {
    }

    public void onExit(ActionEvent actionEvent) {
    }

    public void onCut(ActionEvent actionEvent) {
    }

    public void onCopy(ActionEvent actionEvent) {
    }

    public void onPaste(ActionEvent actionEvent) {
    }

    public void onViewDashboard(ActionEvent actionEvent) {
    }

    public void onViewOtherPage(ActionEvent actionEvent) {

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
}
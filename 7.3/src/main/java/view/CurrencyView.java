package view;

import controller.CurrencyController;
import datasource.JpaConnection;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.List;

public class CurrencyView extends Application {
    private final CurrencyController controller = new CurrencyController();


    private TextField amountField;
    private ComboBox<String> fromCurrencyBox;
    private ComboBox<String> toCurrencyBox;
    private TextField resultField;
    private Button convertButton;
    private Button addCurrencyButton;

    @Override
    public void start(Stage primaryStage) {
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20));
        grid.setHgap(10);
        grid.setVgap(10);


        amountField = new TextField();
        amountField.setPromptText("Enter amount");

        fromCurrencyBox = new ComboBox<>();
        toCurrencyBox = new ComboBox<>();

        resultField = new TextField();
        resultField.setEditable(false);

        convertButton = new Button("Convert");
        addCurrencyButton = new Button("Add New Currency");


        refreshCurrencyComboBoxes();


        convertButton.setOnAction(event -> {
            try {
                double amount = Double.parseDouble(amountField.getText());
                String fromCurrency = fromCurrencyBox.getValue();
                String toCurrency = toCurrencyBox.getValue();

                if (fromCurrency == null || toCurrency == null) {
                    resultField.setText("Please select currencies.");
                    return;
                }

                double result = controller.convert(fromCurrency, toCurrency, amount);
                resultField.setText(String.format("%.2f", result));

            } catch (NumberFormatException e) {
                resultField.setText("Invalid amount entered.");
            } catch (IllegalArgumentException e) {
                resultField.setText("Error: " + e.getMessage());
            } catch (RuntimeException e) {
                showError("Database error during conversion: " + e.getMessage());
                resultField.setText("Conversion failed (DB error).");
            }
        });


        addCurrencyButton.setOnAction(event -> openAddCurrencyWindow(primaryStage));


        grid.add(new Label("Amount:"), 0, 0);
        grid.add(amountField, 1, 0);
        grid.add(new Label("From Currency:"), 0, 1);
        grid.add(fromCurrencyBox, 1, 1);
        grid.add(new Label("To Currency:"), 0, 2);
        grid.add(toCurrencyBox, 1, 2);
        grid.add(convertButton, 1, 3);
        grid.add(addCurrencyButton, 0, 3);
        grid.add(new Label("Converted Amount:"), 0, 4);
        grid.add(resultField, 1, 4);


        Scene scene = new Scene(grid, 450, 350);
        primaryStage.setTitle("Currency Converter (JPA)");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void refreshCurrencyComboBoxes() {
        try {
            List<String> abbreviations = controller.getAllCurrencyAbbreviations();
            fromCurrencyBox.getItems().clear();
            toCurrencyBox.getItems().clear();

            if (abbreviations.isEmpty()) {
                showError("No currencies found in the database. Please add some.");
                disableInputs(true);
            } else {
                fromCurrencyBox.getItems().addAll(abbreviations);
                toCurrencyBox.getItems().addAll(abbreviations);

                if (!fromCurrencyBox.getItems().contains(fromCurrencyBox.getValue())) {
                    fromCurrencyBox.setValue("USD");
                }
                if (!toCurrencyBox.getItems().contains(toCurrencyBox.getValue())) {
                    toCurrencyBox.setValue("EUR");
                }
                disableInputs(false);
            }
        } catch (RuntimeException e) {
            showError("Database connection error on startup: " + e.getMessage());
            disableInputs(true);
        }
    }

    private void openAddCurrencyWindow(Stage primaryStage) {
        Stage addStage = new Stage();
        addStage.initModality(Modality.APPLICATION_MODAL);
        addStage.initOwner(primaryStage);
        addStage.setTitle("Add New Currency");

        GridPane addGrid = new GridPane();
        addGrid.setPadding(new Insets(20));
        addGrid.setHgap(10);
        addGrid.setVgap(10);

        TextField abbrField = new TextField();
        abbrField.setPromptText("e.g., USD");
        TextField nameField = new TextField();
        nameField.setPromptText("e.g., United States Dollar");
        TextField rateField = new TextField();
        rateField.setPromptText("e.g., 1.0");

        Button saveButton = new Button("Save");
        Button cancelButton = new Button("Cancel");

        saveButton.setOnAction(e -> {
            try {
                String abbreviation = abbrField.getText().trim().toUpperCase();
                String name = nameField.getText().trim();
                double rate = Double.parseDouble(rateField.getText());

                controller.addCurrency(abbreviation, name, rate);
                addStage.close();
                refreshCurrencyComboBoxes();
                showError("Invalid rate. Please enter a number.");
            } catch (IllegalArgumentException ex) {
                showError("Input Error: " + ex.getMessage());
            } catch (RuntimeException ex) {
                showError("Database error when adding currency: " + ex.getMessage());
            }
        });

        cancelButton.setOnAction(e -> addStage.close());

        addGrid.add(new Label("Abbreviation:"), 0, 0);
        addGrid.add(abbrField, 1, 0);
        addGrid.add(new Label("Name:"), 0, 1);
        addGrid.add(nameField, 1, 1);
        addGrid.add(new Label("Rate (to USD):"), 0, 2);
        addGrid.add(rateField, 1, 2);
        addGrid.add(saveButton, 0, 3);
        addGrid.add(cancelButton, 1, 3);

        Scene addScene = new Scene(addGrid, 350, 200);
        addStage.setScene(addScene);
        addStage.showAndWait();
    }

    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void disableInputs(boolean disable) {
        amountField.setDisable(disable);
        fromCurrencyBox.setDisable(disable);
        toCurrencyBox.setDisable(disable);
        convertButton.setDisable(disable);
        addCurrencyButton.setDisable(disable);
        resultField.setDisable(disable);
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        JpaConnection.close();
    }
}
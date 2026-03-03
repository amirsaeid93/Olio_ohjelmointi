package view;

import controller.CurrencyController;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.util.List;

public class CurrencyView extends Application {
    private final CurrencyController controller = new CurrencyController();

    @Override
    public void start(Stage primaryStage) {
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20));
        grid.setHgap(10);
        grid.setVgap(10);


        Label amountLabel = new Label("Amount:");
        TextField amountField = new TextField();
        amountField.setPromptText("Enter amount");

        Label fromCurrencyLabel = new Label("From Currency:");
        ComboBox<String> fromCurrencyBox = new ComboBox<>();

        Label toCurrencyLabel = new Label("To Currency:");
        ComboBox<String> toCurrencyBox = new ComboBox<>();

        Label resultLabel = new Label("Converted Amount:");
        TextField resultField = new TextField();
        resultField.setEditable(false);

        Button convertButton = new Button("Convert");


        try {
            List<String> abbreviations = controller.getAllCurrencyAbbreviations();
            if (abbreviations.isEmpty()) {
                showError("No currencies found in the database.");
                disableInputs(amountField, fromCurrencyBox, toCurrencyBox, convertButton);
            } else {
                fromCurrencyBox.getItems().addAll(abbreviations);
                toCurrencyBox.getItems().addAll(abbreviations);
                fromCurrencyBox.setValue("USD"); // Set default
                toCurrencyBox.setValue("EUR");   // Set default
            }
        } catch (SQLException e) {
            showError("Database connection error on startup.");
            disableInputs(amountField, fromCurrencyBox, toCurrencyBox, convertButton);
        }


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
            } catch (SQLException e) {
                resultField.setText("Database error during conversion.");
            }
        });


        grid.add(amountLabel, 0, 0);
        grid.add(amountField, 1, 0);
        grid.add(fromCurrencyLabel, 0, 1);
        grid.add(fromCurrencyBox, 1, 1);
        grid.add(toCurrencyLabel, 0, 2);
        grid.add(toCurrencyBox, 1, 2);
        grid.add(convertButton, 1, 3);
        grid.add(resultLabel, 0, 4);
        grid.add(resultField, 1, 4);


        Scene scene = new Scene(grid, 400, 300);
        primaryStage.setTitle("Currency Converter");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void disableInputs(TextField amountField, ComboBox<String> fromBox, ComboBox<String> toBox, Button convertButton) {
        amountField.setDisable(true);
        fromBox.setDisable(true);
        toBox.setDisable(true);
        convertButton.setDisable(true);
    }
}
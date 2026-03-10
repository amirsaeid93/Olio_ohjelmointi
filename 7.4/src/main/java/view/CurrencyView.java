package view;

import controller.CurrencyController;
import datasource.JpaConnection;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Currency;

public class CurrencyView extends Application {

    private final CurrencyController controller = new CurrencyController();
    private ComboBox<Currency> fromCurrencyBox;
    private ComboBox<Currency> toCurrencyBox;

    @Override
    public void start(Stage primaryStage) {
        try {
            controller.initializeDatabase();
        } catch (Exception e) {
            showError("Fatal Error", "Could not initialize database connection.", e.getMessage());
            return; // Exits if the DB connection fails
        }

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20));
        grid.setHgap(10);
        grid.setVgap(10);

        // UI Components
        TextField amountField = new TextField();
        amountField.setPromptText("Enter amount");
        fromCurrencyBox = new ComboBox<>();
        toCurrencyBox = new ComboBox<>();
        TextField resultField = new TextField();
        resultField.setEditable(false);
        Button convertButton = new Button("Convert");

        // Populates ComboBoxes
        refreshComboBoxes();

        // Event Handler
        convertButton.setOnAction(event -> {
            try {
                double amount = Double.parseDouble(amountField.getText());
                Currency fromCurrency = fromCurrencyBox.getValue();
                Currency toCurrency = toCurrencyBox.getValue();

                if (fromCurrency == null || toCurrency == null) {
                    resultField.setText("Please select currencies.");
                    return;
                }

                double result = controller.convertAndSave(fromCurrency.getAbbreviation(), toCurrency.getAbbreviation(), amount);
                resultField.setText(String.format("%.2f %s", result, toCurrency.getAbbreviation()));
                showInfo("Success", "Transaction saved successfully!");

            } catch (NumberFormatException e) {
                showError("Input Error", "Invalid amount entered.", "Please enter a valid number.");
            } catch (Exception e) {
                showError("Error", "An error occurred during conversion.", e.getMessage());
            }
        });

        // Layout
        grid.add(new Label("Amount:"), 0, 0);
        grid.add(amountField, 1, 0);
        grid.add(new Label("From:"), 0, 1);
        grid.add(fromCurrencyBox, 1, 1);
        grid.add(new Label("To:"), 0, 2);
        grid.add(toCurrencyBox, 1, 2);
        grid.add(convertButton, 1, 3);
        grid.add(new Label("Result:"), 0, 4);
        grid.add(resultField, 1, 4);

        Scene scene = new Scene(grid, 400, 300);
        primaryStage.setTitle("Currency Converter with Transactions");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void refreshComboBoxes() {
        fromCurrencyBox.getItems().setAll(controller.getCurrencies());
        toCurrencyBox.getItems().setAll(controller.getCurrencies());
        fromCurrencyBox.getSelectionModel().selectFirst();
        toCurrencyBox.getSelectionModel().selectLast();
    }

    private void showInfo(String title, String header) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.showAndWait();
    }

    private void showError(String title, String header, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }

    @Override
    public void stop() {
        JpaConnection.close();
    }
}
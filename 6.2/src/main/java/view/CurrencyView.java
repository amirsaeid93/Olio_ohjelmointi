package view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import controller.CurrencyController;

public class CurrencyView extends Application {
    private final CurrencyController controller = new CurrencyController();

    @Override
    public void start(Stage primaryStage) {

        Label titleLabel = new Label("Currency Converter");
        titleLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        Label amountLabel = new Label("Amount:");
        TextField amountField = new TextField();
        amountField.setPromptText("Enter amount");

        Label fromCurrencyLabel = new Label("From Currency:");
        ComboBox<String> fromCurrencyBox = new ComboBox<>();
        fromCurrencyBox.getItems().addAll(controller.getCurrencyRates().keySet());
        fromCurrencyBox.setValue("USD");

        Label toCurrencyLabel = new Label("To Currency:");
        ComboBox<String> toCurrencyBox = new ComboBox<>();
        toCurrencyBox.getItems().addAll(controller.getCurrencyRates().keySet());
        toCurrencyBox.setValue("EUR");

        Label resultLabel = new Label("Converted Amount:");
        TextField resultField = new TextField();
        resultField.setEditable(false);

        Button convertButton = new Button("Convert");
        convertButton.setOnAction(event -> {
            try {
                double amount = Double.parseDouble(amountField.getText());
                String fromCurrency = fromCurrencyBox.getValue();
                String toCurrency = toCurrencyBox.getValue();
                double result = controller.convert(fromCurrency, toCurrency, amount);
                resultField.setText(String.format("%.2f", result));
            } catch (NumberFormatException e) {
                resultField.setText("Invalid amount");
            } catch (IllegalArgumentException e) {
                resultField.setText("Conversion error");
            }
        });


        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20));
        grid.setHgap(10);
        grid.setVgap(10);
        grid.add(titleLabel, 0, 0);
        grid.add(amountLabel, 0, 1);
        grid.add(amountField, 0, 2);
        grid.add(fromCurrencyLabel, 0, 3);
        grid.add(fromCurrencyBox, 0, 4);
        grid.add(toCurrencyLabel, 0, 5);
        grid.add(toCurrencyBox, 0, 6);
        grid.add(resultLabel, 0, 7);
        grid.add(resultField, 0, 8);
        grid.add(convertButton, 0, 9);

        Scene scene = new Scene(grid, 400, 500);

        // getting the styling from the css file
        scene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());

        primaryStage.setTitle("Currency Converter");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
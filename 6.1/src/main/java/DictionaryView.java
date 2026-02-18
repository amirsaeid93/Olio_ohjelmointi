import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class DictionaryView extends Application {
    private final DictionaryController controller = new DictionaryController();

    @Override
    public void start(Stage primaryStage) {

        TextField wordInput = new TextField();
        wordInput.setPromptText("Enter a word");
        Button searchButton = new Button("Search");
        Label resultLabel = new Label();


        searchButton.setOnAction(event -> {
            String word = wordInput.getText();
            String result = controller.searchWord(word);
            resultLabel.setText(result);
        });


        FlowPane root = new FlowPane(10, 10, wordInput, searchButton, resultLabel);
        root.setPrefWrapLength(300);


        Scene scene = new Scene(root, 400, 200);
        primaryStage.setTitle("Virtual org.example.Dictionary");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
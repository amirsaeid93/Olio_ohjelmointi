package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ListView extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/NoteView.fxml"));
        Scene scene = new Scene(loader.load());
        primaryStage.setTitle("Note-Taking Application");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
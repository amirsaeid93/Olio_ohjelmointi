package View;

import Model.Pet;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import Controller.PetController;

public class PetView extends Application {
    private final Pet pet = new Pet(200, 200);
    private final PetController controller = new PetController(pet);
    private boolean isMouseInside = false;
    private double mouseX, mouseY;

    @Override
    public void start(Stage primaryStage) {
        Canvas canvas = new Canvas(600, 400);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        Image petImage = new Image(getClass().getResource("/pet.png").toExternalForm());

        canvas.setOnMouseMoved(event -> {
            isMouseInside = true;
            mouseX = event.getX();
            mouseY = event.getY();
        });

        canvas.setOnMouseEntered(event -> {
            isMouseInside = true;
            mouseX = event.getX();
            mouseY = event.getY();
        });

        canvas.setOnMouseExited(event -> isMouseInside = false);

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (isMouseInside) {
                    controller.updatePosition(mouseX, mouseY);
                }
                draw(gc, petImage);
            }
        };
        timer.start();

        Pane root = new Pane(canvas);
        Scene scene = new Scene(root);
        primaryStage.setTitle("Virtual Pet");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void draw(GraphicsContext gc, Image petImage) {
        gc.clearRect(0, 0, 600, 400);

        double imageWidth = 50;
        double imageHeight = 50;

        gc.drawImage(petImage, pet.getX() - imageWidth / 2, pet.getY() - imageHeight / 2, imageWidth, imageHeight);
    }
}
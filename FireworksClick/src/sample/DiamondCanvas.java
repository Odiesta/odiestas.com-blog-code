package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class DiamondCanvas extends Application {

    private static final int WIDTH = 850;
    private static final int HEIGHT = 565;

    private static final int RECTANGLE = 100;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Canvas canvas = new Canvas(WIDTH, HEIGHT);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.fillRect(0, 0, WIDTH, HEIGHT);
        gc.setFill(Color.web("#EAEDF5"));
        gc.rotate(45);

        for (int i = 50, j = -50; j <= 250; i += RECTANGLE, j += RECTANGLE) {

            for (int x = i, y = j; x <= WIDTH; x += RECTANGLE, y -= RECTANGLE) {
                gc.fillRect(x, y, RECTANGLE, RECTANGLE);
            }
        }

        primaryStage.setScene(new Scene(new StackPane(canvas), WIDTH, HEIGHT));
        primaryStage.setTitle("Diamond Canvas");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}

package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class HelloCanvas extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Canvas canvas = new Canvas(500, 500);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.BLACK);
        gc.setFont(Font.font("Arial", 60));
        gc.fillText("Hello Canvas", 50, 100);
        primaryStage.setScene(new Scene(new StackPane(canvas), 500, 500));
        primaryStage.setTitle("Hello Canvas");
        primaryStage.show();
    }
}

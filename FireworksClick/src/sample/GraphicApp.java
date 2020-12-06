package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.util.Duration;

public abstract class GraphicApp extends Application {

    protected int width = 800;
    protected int height = 600;
    protected GraphicsContext graphicsContext;

    private Paint backgroundColor = Color.BLACK;
    private Timeline timeline = new Timeline();
    private int frames = 30;
    private BorderPane root;
    private Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.stage = primaryStage;
        Canvas canvas = new Canvas(width, height);
        graphicsContext = canvas.getGraphicsContext2D();
        root = new BorderPane(canvas);
        primaryStage.setScene(new Scene(root));
        setup();
        startDrawing();
        primaryStage.show();
    }

    public abstract void setup();

    public abstract void draw();

    public void title(String title) {
        stage.setTitle(title);
    }

    public void background(Paint color) {
        backgroundColor = color;
    }

    public void frames(int frames) {
        this.frames = frames;
        startDrawing();
    }

    public void setBottom(Node node) {
        root.setBottom(node);
    }

    private void internalDraw() {
        graphicsContext.setFill(backgroundColor);
        graphicsContext.fillRect(0, 0, width, height);
        draw();
    }

    private void startDrawing() {
        if (frames > 0) {
            KeyFrame frame = new KeyFrame(Duration.millis(1000 / frames), e -> internalDraw());
            timeline.getKeyFrames().add(frame);
            timeline.setCycleCount(Timeline.INDEFINITE);
            timeline.play();
        }
    }
}
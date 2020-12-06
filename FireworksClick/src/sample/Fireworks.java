package sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Fireworks extends GraphicApp {
    private List<Emitter> emitters = new ArrayList<>();
    List<Point2D> directions = new ArrayList<>(Arrays.asList(
            new Point2D(0, -1),
            new Point2D(0.75, -1),
            new Point2D(1, 0),
            new Point2D(0.75, 1),
            new Point2D(0, 1),
            new Point2D(-0.75, 1),
            new Point2D(-1, 0),
            new Point2D(-0.75, -1)
    ));
    Random random = new Random();

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void setup() {
        frames(50);
        graphicsContext.getCanvas().setOnMouseClicked(e -> emitters.
                add(new Emitter(e.getSceneX(), e.getSceneY())));
        title("Simple Fireworks");
    }

    @Override
    public void draw() {
        for (Emitter emitter : emitters) {
            emitter.emit(graphicsContext);
        }
    }

    public class Emitter {
        List<Spark> sparks = new ArrayList<>();
        double x, y;

        public Emitter(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public void emit(GraphicsContext gc) {
            for (int i = 0; i < directions.size(); i++) {
                int duration = random.nextInt(100) + 2;
                double xDir = directions.get(i).getX();
                double yDir = directions.get(i).getY();
                Spark p = new Spark(x, y, duration,
                        xDir, yDir);
                sparks.add(p);
            }
            for (Spark particle : sparks) {
                particle.step();
                particle.show(gc);
            }
            sparks = sparks.stream().filter(p ->
                    p.duration > 0).collect(Collectors.toList());
        }
    }

    public class Spark {
        int duration;
        double x, y, yDir, xDir;

        public Spark(double x, double y, int duration, double
                xDir, double yDir) {
            this.x = x;
            this.y = y;
            this.duration = duration;
            this.xDir = xDir;
            this.yDir = yDir;
        }

        public void step() {
            x += xDir;
            y += yDir;
            duration--;
        }

        public void show(GraphicsContext gc) {
            gc.setFill(Color.rgb(255, 20, 20, 0.6));
            gc.fillOval(x, y, 3, 3);
        }
    }
}
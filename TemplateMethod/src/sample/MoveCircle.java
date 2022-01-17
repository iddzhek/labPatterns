package sample;

import javafx.geometry.Bounds;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;

public class MoveCircle extends AbstractMove {

    @Override
    public Shape createFigure(AnchorPane scene) {
        Circle circle = new Circle(20, Color.RED);
        Bounds bounds = scene.getBoundsInLocal();
        circle.relocate(bounds.getMaxX(), bounds.getMaxY());
        scene.getChildren().add(circle);
        return circle;
    }
}

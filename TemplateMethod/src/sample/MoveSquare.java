package sample;

import javafx.geometry.Bounds;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class MoveSquare extends AbstractMove{
    @Override
    public Shape createFigure(AnchorPane scene) {
        Rectangle rectangle = new Rectangle(20, 20, Color.GREEN);
        Bounds bounds = scene.getBoundsInLocal();
        rectangle.relocate(bounds.getMaxX(), bounds.getMaxY());
        scene.getChildren().add(rectangle);
        return rectangle;
    }
}

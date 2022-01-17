package sample;

import javafx.geometry.Bounds;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class MoveStar extends AbstractMove{


    @Override
    public Shape createFigure(AnchorPane scene) {
        Polygon polygon = new Polygon();
        polygon.getPoints().addAll(new Double[]{
                10.0, 0.0,
                5.0, 20.0,
                20.0, 10.0,
                0.0, 10.0,
                20.0, 20.0});
        Bounds bounds = scene.getBoundsInLocal();
        polygon.relocate(bounds.getMaxX(), bounds.getMaxY());
        scene.getChildren().add(polygon);
        return polygon;
    }
}

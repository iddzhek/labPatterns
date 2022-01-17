package sample;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

import java.awt.*;

public abstract class AbstractMove {

    public synchronized void move(AnchorPane scene){

        Shape shape = createFigure(scene);

        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(10), new EventHandler<ActionEvent>() {

            double deltaX = 2;
            double deltaY = 2;

            @Override
            public void handle(ActionEvent actionEvent) {
                shape.setLayoutX(shape.getLayoutX() + deltaX);
                shape.setLayoutY(shape.getLayoutY() + deltaY);

                Bounds bounds = scene.getBoundsInLocal();

//                boolean rightBorder = shape.getLayoutX() >= (scene.getMaxWidth() - 20);
//                boolean leftBorder = shape.getLayoutX() <= (scene.getMinWidth() + 20);
//                boolean bottomBorder = shape.getLayoutY() >= (scene.getMaxHeight() - 20);
//                boolean topBorder = shape.getLayoutY() <= (scene.getMinHeight() + 20);
                boolean rightBorder = shape.getLayoutX() >= (bounds.getMaxX() - 20);
                boolean leftBorder = shape.getLayoutX() <= (bounds.getMinX() + 20);
                boolean bottomBorder = shape.getLayoutY() >= (bounds.getMaxY() - 20);
                boolean topBorder = shape.getLayoutY() <= (bounds.getMinY() + 20);
//                boolean rightBorder = shape.getLayoutX() >= (bounds.getMaxX() - shape.getRadius());
//                boolean leftBorder = shape.getLayoutX() <= (bounds.getMinX() + shape.getRadius());
//                boolean bottomBorder = shape.getLayoutY() >= (bounds.getMaxY() - shape.getRadius());
//                boolean topBorder = shape.getLayoutY() <= (bounds.getMinY() + shape.getRadius());

                if (rightBorder || leftBorder) {
                    deltaX *= -1;
                }
                if (bottomBorder || topBorder) {
                    deltaY *= -1;
                }
            }
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();

    }

    public abstract Shape createFigure(AnchorPane scene);
}

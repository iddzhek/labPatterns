//package sample;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.awt.*;
import java.sql.Time;

//public class Move {

//    public static synchronized void move(Circle circle, AnchorPane scene) {
//            Timeline timeline = new Timeline(new KeyFrame(Duration.millis(10), new EventHandler<ActionEvent>() {
//
//                double deltaX = 2;
//                double deltaY = 2;
//
//                @Override
//                public void handle(ActionEvent actionEvent) {
//                    circle.setLayoutX(circle.getLayoutX() + deltaX);
//                    circle.setLayoutY(circle.getLayoutY() + deltaY);
//
//                    Bounds bounds = scene.getBoundsInLocal();
//                    boolean rightBorder = circle.getLayoutX() >= (bounds.getMaxX() - circle.getRadius());
//                    boolean leftBorder = circle.getLayoutX() <= (bounds.getMinX() + circle.getRadius());
//                    boolean bottomBorder = circle.getLayoutY() >= (bounds.getMaxY() - circle.getRadius());
//                    boolean topBorder = circle.getLayoutY() <= (bounds.getMinY() + circle.getRadius());
//
//                    if (rightBorder || leftBorder) {
//                        deltaX *= -1;
//                    }
//                    if (bottomBorder || topBorder) {
//                        deltaY *= -1;
//                    }
//                }
//            }));
//            timeline.setCycleCount(Animation.INDEFINITE);
//            timeline.play();
//        };
//            public void run() {
//                image.setX(250);
//                image.setY(200);
//
//                while (true) {
//
//                    image.setX(image.getX() - dX);
//                    image.setY(image.getY() - dY);
//
//                    double i = image.getLayoutX();
//
//                    boolean rightBorder = image.getX() >= (maxX - 20);
//                    boolean leftBorder = image.getX() <= (minX + 20);
//                    boolean bottomBorder = image.getY() >= (maxY - 20);
//                    boolean topBorder = image.getY() <= (minY + 20);
//
//                    if (rightBorder || leftBorder) {
//                        dX *= -1;
//                    }
//                    if (bottomBorder || topBorder) {
//                        dY *= -1;
//                    }
//                }
//            }
//        };
//    }
//}

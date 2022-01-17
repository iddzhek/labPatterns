package sample;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class Road {

    public static boolean controlCar(Rectangle car, Circle trafficLights){
        if (TrafficLightsAnimator.getColorTrafficLights(trafficLights).equals(Color.RED)
                || TrafficLightsAnimator.getColorTrafficLights(trafficLights).equals(Color.YELLOW)){
            if (CarAnimator.getPositionCar(car) < 420 && CarAnimator.getPositionCar(car) > 400){
                return false;
            }
        }
        return true;
    }
}

package sample;

import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class Facade {

    CarAnimator carAnimator = new CarAnimator();
    TrafficLightsAnimator trafficLightsAnimator = new TrafficLightsAnimator();

    public void start(Rectangle car, Circle trafficLights){
        carAnimator.start(car, trafficLights);
        trafficLightsAnimator.start(trafficLights);
    }
}

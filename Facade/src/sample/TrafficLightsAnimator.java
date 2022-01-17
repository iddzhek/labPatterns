package sample;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class TrafficLightsAnimator{

    static Paint getColorTrafficLights(Circle trafficLights){
        return trafficLights.getFill();
    }

    public void setColorGreenTrafficLights(Circle trafficLights){
        trafficLights.setFill(Color.GREEN);
    }

    public void setColorYellowTrafficLights(Circle trafficLights){
        trafficLights.setFill(Color.YELLOW);
    }

    public void setColorRedTrafficLights(Circle trafficLights){
        trafficLights.setFill(Color.RED);
    }

    public void start(Circle trafficLights){
        Thread trafficLightsThread = new Thread(){
            public void run() {
                try{
                    while (true){
                        setColorGreenTrafficLights(trafficLights);
                        sleep(3200);
                        setColorYellowTrafficLights(trafficLights);
                        sleep(1000);
                        setColorRedTrafficLights(trafficLights);
                        sleep(3200);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        trafficLightsThread.start();
    }
}

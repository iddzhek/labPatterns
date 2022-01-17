package sample;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class CarAnimator{

    private int coordinateYUp = -100;
    private int coordinateYDown = 700;

    static double getPositionCar(Rectangle car){
        return car.getLayoutY();
    }

    private void setPositionCar(Rectangle car){
        car.setLayoutY(getPositionCar(car)-5);
    }

    public void start(Rectangle car, Circle trafficLights){
        Thread carThread = new Thread(){
            public void run() {
                car.setLayoutY(coordinateYDown);
                try{
                    while (true){
                        if (car.getLayoutY() <= coordinateYUp){
                            car.setLayoutY(coordinateYDown);
                        }
                        if (car.getLayoutY() >= coordinateYUp){
                            if (Road.controlCar(car, trafficLights)){
                                setPositionCar(car);
                            }
                        }
                        sleep(20);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        carThread.start();
    }
}

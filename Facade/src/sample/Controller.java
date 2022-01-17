package sample;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class Controller{

    @FXML
    private Rectangle car;

    @FXML
    private Circle trafficLights;

    Facade facade = new Facade();

    @FXML
    public void startFacade(MouseEvent event) throws InterruptedException {
        facade.start(car, trafficLights);
    }
}

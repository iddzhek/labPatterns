package sample;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;



public class Controller {

    @FXML
    private AnchorPane scene;

    @FXML
    void startButton(MouseEvent event) {

        AbstractMove moveCircle = new MoveCircle();
        AbstractMove moveSquare = new MoveSquare();
        AbstractMove moveStar = new MoveStar();
        moveCircle.move(scene);
        moveSquare.move(scene);
        moveStar.move(scene);
    }
}

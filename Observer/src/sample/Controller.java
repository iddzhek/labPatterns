package sample;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;


public class Controller{

    @FXML
    private ImageView openLeftEye;

    @FXML
    private ImageView openMouth;

    @FXML
    private ImageView openRightEye;

    @FXML
    private ImageView orangeNose;

    @FXML
    private ImageView nose;

    @FXML
    void leftEye(MouseEvent event) {
        observer(openLeftEye);
    }

    @FXML
    void rightEye(MouseEvent event) {
        observer(openRightEye);
    }

    @FXML
    void nose(MouseEvent event) {
        observer(orangeNose);
    }

    @FXML
    void mouth(MouseEvent event) {
        observer(openMouth);
    }

    void observer(ImageView img){
        if(!img.isVisible()) {
            img.setVisible(true);
        } else {
            img.setVisible(false);
        }
    }

}

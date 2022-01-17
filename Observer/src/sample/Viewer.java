package sample;

import javax.swing.text.html.ImageView;

public class Viewer implements Observer{

    private ImageView imageView;

    @Override
    public void handleEvent(ImageView imageView) {
        this.imageView = imageView;
    }
}

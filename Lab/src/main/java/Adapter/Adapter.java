package Adapter;

import java.util.Arrays;

public class Adapter extends ArraysDate implements OutputStream{

    @Override
    public void getOutputStream() {
        if(this.arraysData == null)
            return;
        for (String s : this.arraysData){
            byte [] byteArrays = s.getBytes();
            System.out.println(Arrays.toString(byteArrays));
        }
    }
}

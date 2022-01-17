package Adapter;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Adapter arraysDate = new Adapter();

        arraysDate.addDate("String1");
        arraysDate.addDate("String2");
        arraysDate.addDate("String3");

        arraysDate.getOutputStream();
    }
}

package Adapter;

import java.util.Arrays;

public class ArraysDate {

    public String[] arraysData;
    private int sizeArraysDate = 0;

    public ArraysDate(){
        this.arraysData = new String[sizeArraysDate];
    }

    public void addDate(String value){
        if (value == null)
            return;
        for (int i = 0; i <= sizeArraysDate; i++){
            if(sizeArraysDate == i)
                arraysData = Arrays.copyOf(arraysData, arraysData.length+1);
            if(arraysData[i] == null){
                arraysData = Arrays.copyOf(arraysData, arraysData.length);
                arraysData[i] = value;
                sizeArraysDate += 1;
                break;
            }
        }
    }
}

package FactoryMethod;

import DAO.*;

import java.awt.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) throws DuplicateModelNameException, NoSuchModelNameException, CloneNotSupportedException, IOException, ClassNotFoundException {

        Transport ladaCar = ClassStaticMethod.createInstance("Lada", 3);
        ladaCar.addNewModel("Vesta", 760000);
        ladaCar.addNewModel("Granta", 600000);
        ladaCar.addNewModel("X-Ray", 900000);
        ladaCar.addNewModel("X-Ray1", 900000);

        ClassStaticMethod.setTransportFactory(new BikeFactory());
        Transport izBike = ClassStaticMethod.createInstance("Iz", 5);
        izBike.addNewModel("Jupiter", 100);
        izBike.addNewModel("Planet", 200);
        izBike.addNewModel("Planet2", 300);
        izBike.addNewModel("Planet5", 300);
//
////ChainOfResponsibility
//        ChainOfResponsibility outputString = new OutputString(ladaCar);
//        ChainOfResponsibility outputColumn = new OutputColumn(ladaCar);
//
//        outputString.setNextParticipant(outputColumn);
//        outputString.output();

//        ChainOfResponsibility outputString = new OutputString(izBike);
//        ChainOfResponsibility outputColumn = new OutputColumn(izBike);
//
//        outputString.setNextParticipant(outputColumn);
//        outputString.output();
////command
//        ladaCar.setPrintCommand("String");
//        ladaCar.print();
//
//
//        ladaCar.setPrintCommand("Column");
//        ladaCar.print();

        //iterator
//        Car.AutoIterator iterator = (Car.AutoIterator) ladaCar.getIterator();
//        while (iterator.iterator().hasNext()){
//            iterator.iterator().next().toString();
//        }

        //memento
        Car lada = new Car("Lada", 3);
        lada.addNewModel("111", 111);
        lada.addNewModel("222", 222);
        lada.addNewModel("333", 333);
//
//        lada.createMemento();
//
//        lada.addNewModel("444", 444);
//
//        Car.AutoIterator iterator = (Car.AutoIterator) lada.getIterator();
//        while (iterator.iterator().hasNext()){
//            iterator.iterator().next().toString();
//        }
//
//        Car deserializelada = lada.setMemento();
//
//        System.out.println("________________");
//        Car.AutoIterator deserializeIterator = (Car.AutoIterator) deserializelada.getIterator();
//        while (deserializeIterator.iterator().hasNext()){
//            deserializeIterator.iterator().next().toString();
//        }
        //visitor
//        ladaCar.accept();
//        System.out.println("\n_____________");
//        izBike.accept();

//        DAO
        lada.createTextFile();
        lada.createSerializableFile();
        lada.readTextFile();
        System.out.println("______________");
        lada.readFileSerializable();
        DAO data = new FileSerializable();
        data.create(lada);
        data.read();
    }
}

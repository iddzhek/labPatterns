package Visitor;

import FactoryMethod.*;

public class PrintVisitor implements Visitor {

    @Override
    public String visit(Car car) {
        System.out.print("Brand: " + car.getStamp());
        String[] nameCar = car.getNamesOfAllModels();
        double[] priceCar = car.getPriceOfAllModels();
        for (int i = 0; i < car.getSizeModel(); i++){
            System.out.print(" Model: " + nameCar[i] + "; Price: " + priceCar[i]);
        }
        return null;
    }

    @Override
    public void visit(Bike bike) {
        System.out.println("Brand: " + bike.getStamp());
        String[] nameBike = bike.getNamesOfAllModels();
        double[] priceBike = bike.getPriceOfAllModels();
        for (int i = 0; i < bike.getSizeModel(); i++) {
            System.out.println("Model: " + nameBike[i] + "; Price: " + priceBike[i]);
        }
    }
}

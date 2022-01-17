package Visitor;

import FactoryMethod.Bike;
import FactoryMethod.Car;

public interface Visitor {

    String visit(Car car);

    void visit(Bike bike);
}

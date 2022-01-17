package FactoryMethod;

public class CarFactory implements TransportFactory{

    @Override
    public Transport createInstance(String brandTransport, int sizeArraysModel) {
        return new Car(brandTransport, sizeArraysModel);
    }
}

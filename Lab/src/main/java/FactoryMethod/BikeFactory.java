package FactoryMethod;

public class BikeFactory implements TransportFactory{

    @Override
    public Transport createInstance(String brandTransport, int sizeArraysModel) throws DuplicateModelNameException {
        return new Bike(brandTransport, sizeArraysModel);
    }
}

package FactoryMethod;

public interface TransportFactory {

    Transport createInstance(String brandTransport, int sizeArraysModel) throws DuplicateModelNameException;
}

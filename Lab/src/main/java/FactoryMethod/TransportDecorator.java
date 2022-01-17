package FactoryMethod;

import java.io.FileNotFoundException;
import java.io.IOException;

public class TransportDecorator implements Transport{

    private Transport transport;

    public TransportDecorator(Transport transport){
        this.transport = transport;
    }

    @Override
    public synchronized String getStamp() {
        return transport.getStamp();
    }

    @Override
    public synchronized String[] getNamesOfAllModels() {
        return transport.getNamesOfAllModels();
    }

    @Override
    public synchronized double[] getPriceOfAllModels() {
        return transport.getPriceOfAllModels();
    }

    @Override
    public synchronized double getPriceByModelName(String modelCar) throws NoSuchModelNameException{
        return transport.getPriceByModelName(modelCar) ;
    }

    @Override
    public synchronized void setNewPriceByModelName(String model, double newPriceModel) throws NoSuchModelNameException {
        transport.setNewPriceByModelName(model, newPriceModel);
    }

    @Override
    public synchronized void setNewNameModel(String oldNameModel, String newNameModel) throws NoSuchModelNameException, DuplicateModelNameException {
        transport.setNewNameModel(oldNameModel, newNameModel);
    }

    @Override
    public synchronized void addNewModel(String model, double price) throws DuplicateModelNameException {
        transport.addNewModel(model, price);
        System.out.println("check");
    }

    @Override
    public synchronized void delModel(String model, double price) throws DuplicateModelNameException, NoSuchModelNameException {
        transport.delModel(model, price);
    }

    @Override
    public synchronized int getSizeModel() {
        return transport.getSizeModel();
    }

    @Override
    public synchronized Object clone() throws CloneNotSupportedException {
        return transport.clone();
    }

    @Override
    public void setPrintCommand(String string) {

    }

    @Override
    public void print() {

    }

    @Override
    public Object getIterator() {
        return null;
    }

    @Override
    public void accept() {

    }

}

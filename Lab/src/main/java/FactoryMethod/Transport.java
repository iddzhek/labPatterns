package FactoryMethod;

import Visitor.Visitor;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface Transport {

    String getStamp();

    String[] getNamesOfAllModels();

    double[] getPriceOfAllModels();

    double getPriceByModelName(String modelCar) throws NoSuchModelNameException;

    void setNewPriceByModelName(String model, double newPriceModel) throws NoSuchModelNameException;

    void setNewNameModel(String oldNameModel, String newNameModel) throws NoSuchModelNameException, DuplicateModelNameException;

    void addNewModel(String model, double price) throws DuplicateModelNameException;

    void delModel(String model, double price) throws NoSuchModelNameException, DuplicateModelNameException;

    int getSizeModel();

    Object clone() throws CloneNotSupportedException;

    void setPrintCommand(String string);

    void print();

    Object getIterator();

    void accept();

}

package FactoryMethod;

import DAO.*;
import Visitor.*;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Bike implements Transport,Cloneable{

    private String brandBike;
    private int sizeListModelBike;
    private Model head = new Model(null, Double.NaN);
    {
        head.next = head;
        head.prev = head;
    }

    private class Model implements Cloneable{
        private String modelBike;
        private double priceBike;
        private Model prev = null;
        private Model next = null;

        private Model(String modelBike, double priceBike) throws DuplicateModelNameException {
            if(throwDuplicateModelNameException(modelBike)){
                this.modelBike = modelBike;
            }if (throwModelPriceOutOfBoundsException(priceBike))
                this.priceBike = priceBike;
        }
    }


    public Bike(String brandBike, int sizeArraysModel) throws DuplicateModelNameException {
        this.brandBike = brandBike;
        if (head.next.equals(null)) sizeListModelBike = 0;
    }

    public String getStamp() {
        return brandBike;
    }

    public void setStamp(String stamp) {
        this.brandBike = stamp;
    }

    @Override
    public String[] getNamesOfAllModels() {
        Model current = head.next;
        String[] arraysNamesModel = new String[sizeListModelBike];
            for(int i = 0; i < sizeListModelBike; i++){
                arraysNamesModel[i] = current.modelBike;
                current = current.next;
            }
        return arraysNamesModel;
    }

    @Override
    public double[] getPriceOfAllModels() {
        Model current = head.next;
        double[] arraysPriceModel = new double[sizeListModelBike];
        for(int i = 0; i < sizeListModelBike; i++){
            arraysPriceModel[i] = current.priceBike;
            current = current.next;
        }
        return arraysPriceModel;
    }

    @Override
    public double getPriceByModelName(String modelBike) throws NoSuchModelNameException{
        Model current = head.next;
        double priceBike = 0;
        while (current != null){
            if (current.modelBike.equals(modelBike)){
                priceBike = current.priceBike;
                return priceBike;
            }
            current = current.next;
        }
        throw new NoSuchModelNameException("Error: model not found");
    }

    @Override
    public void setNewPriceByModelName(String modelBike, double newPriceModel) throws NoSuchModelNameException {
        if(throwModelPriceOutOfBoundsException(newPriceModel));
        if(throwNoSuchModelNameException(modelBike));
        Model current = head.next;
        while (current.modelBike != null){
            if (current.modelBike.equals(modelBike))
                current.priceBike = newPriceModel;
                current = current.next;
        }
    }

    @Override
    public void setNewNameModel(String oldNameModel, String newNameModel) throws NoSuchModelNameException, DuplicateModelNameException {
        if(throwDuplicateModelNameException(newNameModel));
        if(throwNoSuchModelNameException(oldNameModel));
        Model current = head.next;
        while (current.modelBike != null){
            if (current.modelBike.equals(oldNameModel))
                current.modelBike = newNameModel;
            current = current.next;
        }
    }

    @Override
    public void addNewModel(String modelBike, double priceBike) throws DuplicateModelNameException {
        Model model = new Model(modelBike, priceBike);
        model.next = head;
        model.prev = head.prev;
        head.prev.next = model;
        head.prev = model;
        sizeListModelBike++;
    }

    @Override
    public void delModel(String modelBike, double priceBike) throws NoSuchModelNameException{
        if (throwModelPriceOutOfBoundsException(priceBike))
            return;
        if (throwNoSuchModelNameException(modelBike))
            return;
        Model findModel = forEach(modelBike, priceBike);
        findModel.next.prev = findModel.prev;
        findModel.prev.next = findModel.next;
        sizeListModelBike--;
    }

    public Model forEach(String modelBike, double priceBike){
        Model model = this.head;
        if(model != null){
            do {
                model = model.next;
            }while (!model.modelBike.equals(modelBike));
        }
        return model;
    }

    public String toString(){
        Model current = head.next;
        for (int i = 0; i < sizeListModelBike; i++) {
            try{
                System.out.printf("model: %s, price: %1f\n", current.modelBike, current.priceBike);
                System.out.printf("next model: %s, next price: %1f\n", current.next.modelBike, current.next.priceBike);
                System.out.printf("prev model: %s, prev price: %1f\n", current.prev.modelBike, current.prev.priceBike);
            }catch (NullPointerException e){
                System.out.println(e.getMessage());
            }
            System.out.println("-----------------------------------------------------------------------");
            current = current.next;
        }
        return null;
    }

    @Override
    public int getSizeModel(){
        return sizeListModelBike;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Bike cloneBike;
        cloneBike = (Bike) super.clone();
        Model current = this.head.next;
        cloneBike.head = null;
        try {
            Bike intermediateBike = new Bike(current.modelBike, sizeListModelBike);
            for (int i = 0; i < sizeListModelBike; i++) {
                intermediateBike.addNewModel(current.modelBike, current.priceBike);
                current = current.next;
            }
            cloneBike.head = intermediateBike.head;
        }catch (DuplicateModelNameException e) {
                e.printStackTrace();
        }
        return cloneBike;
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
        Visitor visitor = new PrintVisitor();
        visitor.visit(this);
    }

    private boolean throwModelPriceOutOfBoundsException(double price){
        if (price < 0) throw new ModelPriceOutOfBoundsException("Error: incorrect price modelBike");
        return true;
    }

    private boolean throwDuplicateModelNameException(String modelBike) throws DuplicateModelNameException {
        if (head == null)
            return false;
        Model current = head.next;
        while (current.modelBike != null) {
            if (current.modelBike.equals(modelBike))
                throw new DuplicateModelNameException("Error: this modelBike already exists");
            current = current.next;
        }
        return true;
    }

    private boolean throwNoSuchModelNameException(String modelBike) throws NoSuchModelNameException {
        Model current = head.next;
        while (current.modelBike != null) {
            if (current.modelBike.equals(modelBike))
                return false;
            current = current.next;
        } throw new NoSuchModelNameException("Error: this modelBike not found");
    }
}

package FactoryMethod;

import Visitor.*;

import java.io.*;
import java.util.Arrays;
import java.util.Iterator;
import DAO.*;

public class Car implements Transport, Cloneable, java.io.Serializable {

    private  String brandCar;
    private int sizeArraysModel;
    private int counterSizeArraysModel;
    private static Model[] arraysModels;
    private String typePrint;

    public Car() {
    }

    class AutoIterator implements Iterable{
        int index;
        @Override
        public Iterator iterator() {
            return new Iterator() {
                @Override
                public boolean hasNext() {
                    if(index < counterSizeArraysModel){
                        return true;
                    }
                    return false;
                }

                @Override
                public Object next() {
                    if (!hasNext()){
                        return new RuntimeException();
                    }
                    return arraysModels[index++];
                }
            };
        }
    }

    static class Memento{
        static byte[] byteArray;

        public static void setAuto(Car car) {
            try (ByteArrayOutputStream saveCurrentStates = new ByteArrayOutputStream();
                 ObjectOutputStream objStream = new ObjectOutputStream(saveCurrentStates)){
                objStream.writeObject(car);
                objStream.flush();
                byteArray = saveCurrentStates.toByteArray();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public static Car getAuto() throws IOException, ClassNotFoundException {
            ByteArrayInputStream saveCurrentStatesToByteArray = new ByteArrayInputStream(byteArray);
            ObjectInputStream obgStream = new ObjectInputStream(saveCurrentStatesToByteArray);
            return (Car) obgStream.readObject();
        }

        public static byte[] getByteArray(){
            return byteArray;
        }
    }

    static class Model implements Cloneable, java.io.Serializable {

        private String modelCar;
        private double price;

        public Model(String modelCar, double price) throws DuplicateModelNameException {
            if (throwDuplicateModelNameException(modelCar)) {
                if (modelCar.equals(""))
                    return;
                this.modelCar = modelCar;
                if (throwModelPriceOutOfBoundsException(price)) {
                    this.price = price;
                }
            }
        }

        public String toString(){
            System.out.println("Model name: " + modelCar + ". Price model: " + price + ".");
            return null;
        }
    }


    public Car(String brandCar, int sizeArraysModel) {
        this.brandCar = brandCar;
        this.counterSizeArraysModel = 0;
        this.sizeArraysModel = sizeArraysModel;
        this.arraysModels = new Model[sizeArraysModel];
    }

    @Override
    public String getStamp(){
        return brandCar;
    }

    public void setStamp(String stamp){
        this.brandCar = stamp;
    }

    public String[] getNamesOfAllModels(){
        String[] namesOfAllModels = new String[arraysModels.length];
        for (int i = 0; i < arraysModels.length; i++){
            if(arraysModels[i] == null)
                return namesOfAllModels;
            namesOfAllModels[i] = arraysModels[i].modelCar;
        }
        return namesOfAllModels;
    }

    public double[] getPriceOfAllModels(){
        double[] priceOfAllModels = new double[counterSizeArraysModel];
        for (int i = 0; i < counterSizeArraysModel; i++){
            if (arraysModels[i] == null)
                return priceOfAllModels;
            priceOfAllModels[i] = arraysModels[i].price;
        }
        return priceOfAllModels;
    }

    public double getPriceByModelName(String modelCar) throws NoSuchModelNameException{
        for (Model s : arraysModels){
            if(modelCar.equals(s.modelCar)){
                return s.price;
            }
        } throw new NoSuchModelNameException("Error: model not found");
    }

    public void setNewPriceByModelName(String modelCar, double newPriceModel) throws NoSuchModelNameException {
        boolean foundModel = false;
        if(arraysModels[0] == null) throw new NullPointerException();
        if (newPriceModel < 0) throw new ModelPriceOutOfBoundsException("Error: incorrect price model");
        for (Model s : arraysModels) {
            if (modelCar.equals(s.modelCar)) {
                s.price = newPriceModel;
                foundModel = true;
            }
        }
        if (!foundModel) throw new NoSuchModelNameException("Error: model not found");
    }

    public void setNewNameModel(String oldNameModel, String newNameModel) throws NoSuchModelNameException, NullPointerException, DuplicateModelNameException {
        boolean foundModel = false;
        if(arraysModels[0] == null) throw new NullPointerException();
        if(throwDuplicateModelNameException(newNameModel))
            for (int i = 0; i < arraysModels.length; i++) {
                if (oldNameModel.equals(arraysModels[i].modelCar)) {
                    arraysModels[i].modelCar = newNameModel;
                    foundModel = true;
                }
            }
        if (!foundModel) throw new NoSuchModelNameException("Error: model not found");
    }

    public void addNewModel(String modelCar, double price) throws DuplicateModelNameException {
        Model model = new Model(modelCar, price);
        if (model.modelCar.equals(null) || model.price == 0){
            return;
        }
        for (int i = 0; i < this.arraysModels.length+1; i++){
            if(sizeArraysModel == i){
                arraysModels = Arrays.copyOf(arraysModels, arraysModels.length+1);
            }
            if(arraysModels[i] == null){
                arraysModels = Arrays.copyOf(arraysModels, arraysModels.length);
                arraysModels[i] = model;
                counterSizeArraysModel += 1;
                break;
            }
        }
    }

    public void delModel(String modelCar, double price) throws NoSuchModelNameException {
        boolean foundModel = false;
        if (throwModelPriceOutOfBoundsException(price));
        Model[] newArraysModel = new Model[arraysModels.length-1];
        for (int i = 0; i < arraysModels.length; i++) {
            if (arraysModels[i].modelCar.equals(modelCar) && arraysModels[i].price == price) {
                System.arraycopy(arraysModels, 0, newArraysModel, 0, i);
                System.arraycopy(arraysModels, i+1, newArraysModel, i, arraysModels.length-i-1);
                foundModel = true;
                sizeArraysModel -=1 ;
            }
        }
        arraysModels = newArraysModel;
        if (!foundModel) throw new NoSuchModelNameException("Error: model not found");
    }

    public int getSizeModel(){
        return counterSizeArraysModel;
    }

    @Override
    public Object clone() {
        Car cloneCar = null;
        try {
            cloneCar = (Car) super.clone();
            cloneCar.arraysModels = new Model[this.sizeArraysModel];
            for (int i = 0; i < this.sizeArraysModel; i++){
                cloneCar.addNewModel(this.arraysModels[i].modelCar, this.arraysModels[i].price);
            }
            return cloneCar;
        } catch (CloneNotSupportedException | DuplicateModelNameException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void print(){
        if (typePrint.equals("String")){
            Command command = new PrintString(this);
            command.execute();
        }
        if (typePrint.equals("Column")){
            Command command = new PrintColumn(this);
            command.execute();
        }
    }
    public void setPrintCommand(String typePrint){
        if (typePrint.equals("String")){
            this.typePrint = typePrint;
            return;
        }
        if (typePrint.equals("Column")){
            this.typePrint = typePrint;
            return;
        }
        else System.out.println("Invalid command");
    }

    public Object getIterator(){
        return new AutoIterator();
    }

    @Override
    public void accept() {
        Visitor visitor = new PrintVisitor();
        visitor.visit(this);
    }

    public void createMemento() throws IOException, CloneNotSupportedException {
        Memento.setAuto(this);
    }

    public Car setMemento() throws IOException, ClassNotFoundException {
        return Memento.getAuto();
    }

    public void createTextFile() throws IOException, CloneNotSupportedException {
        DAO dao = new FileText();
        dao.create(this);
    }

    public void readTextFile() throws IOException, ClassNotFoundException {
        DAO dao = new FileText();
        dao.read();
    }

    public void readFileSerializable() throws IOException, ClassNotFoundException {
        DAO dao = new FileSerializable();
        dao.read();
    }

    public void createSerializableFile() throws IOException, CloneNotSupportedException {
        DAO dao = new FileSerializable();
        dao.create(this);
    }

    public byte[] getSerializable(){
        return Memento.getByteArray();
    }


    public static boolean throwModelPriceOutOfBoundsException(double price){
        if (price < 0) throw new ModelPriceOutOfBoundsException("Error: incorrect price model");
        return true;
    }

    public static boolean throwDuplicateModelNameException(String modelCar) throws DuplicateModelNameException {
        if (arraysModels[0] != null) {
            for (Model s : arraysModels) {
                if (s == null) break;
                if (s.modelCar.equals(modelCar))
                    throw new DuplicateModelNameException("Error: this model already exists");
            }
        } return true;
    }
}

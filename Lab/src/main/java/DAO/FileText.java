package DAO;

import java.io.*;

import FactoryMethod.*;


public class FileText implements DAO{

    @Override
    public void create(Car car) throws FileNotFoundException {
        File file = new File("src/main/resources/DAOText.txt");
        try (FileWriter writer = new FileWriter("src/main/resources/DAOText.txt", false)) {
            String brand = "Brand: " + car.getStamp() + ", number of models: " + car.getSizeModel() + "\n";
            writer.write(brand);
            String[] nameCar = car.getNamesOfAllModels();
            double[] priceCar = car.getPriceOfAllModels();
            for (int i = 0; i < car.getSizeModel(); i++){
                String data = "Model: " + nameCar[i] + "; Price: " + priceCar[i] + "\n";
                writer.write(data);
            }

            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void read() {
        try (FileReader reader = new FileReader("src/main/resources/DAOText.txt")) {
            int c;
            while ((c=reader.read())!=-1){
                System.out.print((char)c);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

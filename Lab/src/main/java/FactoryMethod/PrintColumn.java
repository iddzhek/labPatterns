package FactoryMethod;

import java.io.FileWriter;
import java.io.IOException;

public class PrintColumn implements Command{

    private Car car;

    public PrintColumn(Car car) {
        this.car = car;
    }

    @Override
    public void execute() {
        try (FileWriter writer = new FileWriter("CarModelColumn.txt", false)) {
            String title = car.getStamp();
            writer.write("Stamp transport: " + title + ". \n");
            for (int i = 0; i < car.getSizeModel(); i++){
                String[] nameModel = car.getNamesOfAllModels();
                double[] priceModel = car.getPriceOfAllModels();
                String data = nameModel[i];
                double value = priceModel[i];
                writer.write("Model: " + data + ", price: " + value + ". \n");
                writer.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

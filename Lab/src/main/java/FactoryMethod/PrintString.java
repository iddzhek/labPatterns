package FactoryMethod;

import java.io.FileWriter;
import java.io.IOException;

public class PrintString implements Command{

    private Car car;

    public PrintString(Car car) {
        this.car = car;
    }

    @Override
    public void execute() {
        try (FileWriter writer = new FileWriter("CarModelString.txt", false)) {
            String title = car.getStamp();
            writer.write("Stamp transport: " + title + ". ");
            for (int i = 0; i < car.getSizeModel(); i++){
                String[] nameModel = car.getNamesOfAllModels();
                double[] priceModel = car.getPriceOfAllModels();
                String data = nameModel[i];
                double value = priceModel[i];
                writer.write("Model: " + data + ", price: " + value + ". ");
                writer.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

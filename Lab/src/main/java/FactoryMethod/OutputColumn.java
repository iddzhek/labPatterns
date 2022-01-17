package FactoryMethod;

import java.io.FileWriter;
import java.io.IOException;

public class OutputColumn implements ChainOfResponsibility{

    private Transport transport;
    private ChainOfResponsibility nextParticipant;

    public OutputColumn(Transport transport) {
        this.transport = transport;
    }

//    @Override
//    public void acceptsTransport(Transport transport) {
//        this.transport = transport;
//    }

    @Override
    public void setNextParticipant(ChainOfResponsibility chainOfResponsibility) {
        this.nextParticipant = chainOfResponsibility;
    }

    @Override
    public void output() {
        int count = transport.getSizeModel();
        if (count > 3) {
            try (FileWriter writer = new FileWriter("ModelColumn.txt", false)) {
                String title = transport.getStamp();
                writer.write("Stamp transport: " + title + ". \n");
                for (int i = 0; i < count; i++){
                    String[] nameModel = transport.getNamesOfAllModels();
                    double[] priceModel = transport.getPriceOfAllModels();
                    String data = nameModel[i];
                    double value = priceModel[i];
                    writer.write("Model: " + data + ", price: " + value + ". \n");
                    writer.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else nextParticipant.output();
    }
}

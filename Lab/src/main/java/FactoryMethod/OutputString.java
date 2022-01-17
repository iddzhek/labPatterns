package FactoryMethod;

import java.io.FileWriter;
import java.io.IOException;

public class OutputString implements ChainOfResponsibility {

    private Transport transport;
    private ChainOfResponsibility nextParticipant;

    public OutputString(Transport transport) {
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
        if (transport.getSizeModel() <= 3) {
            try (FileWriter writer = new FileWriter("ModelString.txt", false)) {
                String title = transport.getStamp();
                writer.write("Stamp transport: " + title + ". ");
                for (int i = 0; i < 3; i++){
                    String[] nameModel = transport.getNamesOfAllModels();
                    double[] priceModel = transport.getPriceOfAllModels();
                    String data = nameModel[i];
                    double value = priceModel[i];
                    writer.write("Model: " + data + ", price: " + value + ". ");
                    writer.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else nextParticipant.output();
    }
}

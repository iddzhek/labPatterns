package FactoryMethod;

public interface ChainOfResponsibility {

//    void acceptsTransport(Transport transport);

    void setNextParticipant(ChainOfResponsibility chainOfResponsibility);

    void output();
}

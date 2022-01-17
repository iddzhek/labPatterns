package FactoryMethod;

public class ClassStaticMethod{

    private static TransportFactory factory = new CarFactory();

//    public static Transport setTransportFactory(String TransportFactory){
//        if (TransportFactory.equalsIgnoreCase("Car")){
//            factory = new CarFactory();
//        }else if(TransportFactory.equalsIgnoreCase("Bike")){
//            factory = new BikeFactory();
//        }else throw new RuntimeException(factory + " is unknown");
//        return null;
//    }

    public static void setTransportFactory(TransportFactory t){
        factory = t;
    }

    public static Transport createInstance(String brandTransport, int sizeArraysModel) throws DuplicateModelNameException {
        return factory.createInstance(brandTransport, sizeArraysModel);
    }

    static double getMiddleSumOfAllTransport(Transport t){
        double sumOfAllTransport = 0;
        double middleSumOfAllTransport = 0;
        double[] arraysPrice = t.getPriceOfAllModels();
        for (double s : arraysPrice){
            sumOfAllTransport += s;
        }
        middleSumOfAllTransport = sumOfAllTransport/arraysPrice.length;
        return middleSumOfAllTransport;
    }

    static void getNameOfAllTransport(Transport t){
        for (String s : t.getNamesOfAllModels()){
            System.out.println(s);
        }
    }

    static void getPriceOfAllTransport(Transport t){
        for (double s : t.getPriceOfAllModels()){
            System.out.println(s);
        }
    }

    static Transport synchronizedTransport (Transport t){
        Transport transport = new TransportDecorator(t);
        return transport;
    }
}

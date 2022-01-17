package DAO;

import FactoryMethod.*;


import java.io.*;

public class FileSerializable implements DAO {

    @Override
    public void create(Car car) throws IOException, CloneNotSupportedException {
        File file = new File("src/main/resources/DAOSerializable.dat");
        FileOutputStream outputStream = new FileOutputStream("src/main/resources/DAOSerializable.dat");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(car);
        objectOutputStream.close();
    }

    @Override
    public void read() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("src/main/resources/DAOSerializable.dat");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        Car car = (Car) objectInputStream.readObject();

        car.accept();

    }
}

package DAO;

import java.io.FileNotFoundException;
import java.io.IOException;

import FactoryMethod.*;

public interface DAO {

    void create(Car car) throws IOException, CloneNotSupportedException;

    void read() throws IOException, ClassNotFoundException;
}

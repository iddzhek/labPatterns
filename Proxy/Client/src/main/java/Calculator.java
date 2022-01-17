import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Calculator {

    public Double multiplication() {
        try (Socket client = new Socket("localhost",5000)){
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));

            System.out.println("Enter first value");
            String firstValue = reader.readLine();
            System.out.println("Enter second value");
            String secondValue = reader.readLine();

            out.write(firstValue + "\n");
            out.write(secondValue + "\n");
            out.flush();

            String result = in.readLine();
            System.out.println(result);

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}

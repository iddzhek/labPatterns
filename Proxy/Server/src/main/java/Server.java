import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(5000)){
            System.out.println("Connection to the server is successful");
            Socket client = server.accept();
            System.out.println("Client " + client.getInetAddress().getCanonicalHostName() + " connection");

            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));

            String firstValue = in.readLine();
            System.out.println("You entered the first number");
            String secondValue = in.readLine();
            System.out.println("You entered the second number");
            String result = String.valueOf(Double.parseDouble(firstValue) + (Double.parseDouble(secondValue)));

            out.write("The sum if the number " + firstValue + " and number " + secondValue + " is equal to: " + result + "\n");
            out.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

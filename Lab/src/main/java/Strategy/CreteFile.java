package Strategy;

import java.util.Scanner;

public class CreteFile {

    static String pathFile;
    static String nameFile;

    public static String pathWayFile(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the path: ");
        pathFile = in.nextLine();
        return pathFile;
    }

    public static String nameFile(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the name: ");
        nameFile = in.nextLine();
        return nameFile;
    }

}

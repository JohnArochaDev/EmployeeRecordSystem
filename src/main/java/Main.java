import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Console console = new Console(scanner);
        Boolean homeMenu = true;


        console.start(homeMenu);
//        int userChoice = scanner.nextInt();
//        console.display(userChoice);
    }
}
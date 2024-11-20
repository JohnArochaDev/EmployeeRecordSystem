import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Console {

    private final Scanner scanner;
    ObjectMapper objectMapper = new ObjectMapper();

    public Console(Scanner scanner) {
        this.scanner = scanner;  // Initialize the scanner field
    }


    public void start(Boolean menu) {

        if(menu) {
            System.out.println("Employee Management System");
            System.out.println("--------------------------");
            System.out.println("Make a selection:");
            System.out.println("1. Create Employee");
            System.out.println("2. Delete Employee");
            System.out.println("3. Find Employee");
        } else {
            System.out.println("Goodbye...");
        }
    }

    public void display(int userChoice) {
        switch (userChoice) {
            case 1:
                System.out.println("Create Employee");
                System.out.println("Employee first name:");
                String firstName = scanner.nextLine();
                scanner.nextLine();

                System.out.println("Employee last name:");
                String lastName = scanner.nextLine();

                System.out.println("Employee age:");
                int age = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Employee email:");
                String email = scanner.nextLine();

                System.out.println("Employee position:");
                String position = scanner.nextLine();

                Employee employee = new Employee(firstName, lastName, age, email, position);

                try {
                    // Read existing employees from JSON file (if any)
                    File file = new File("src/main/db/db.json");
                    List<Employee> employees;

                    // If the file doesn't exist or is empty, initialize an empty list
                    if (file.exists() && file.length() > 0) {
                        // Read the existing array of employees
                        employees = objectMapper.readValue(file, objectMapper.getTypeFactory().constructCollectionType(List.class, Employee.class));
                    } else {
                        // Initialize empty list if the file doesn't exist or is empty
                        employees = new ArrayList<>();
                    }

                    // Add the new employee to the list
                    employees.add(employee);

                    // Write the updated list back to the file
                    objectMapper.writeValue(file, employees);
                    System.out.println("Employee successfully created.");
                } catch (IOException e) {
                    System.out.println("Error occurred: " + e.getMessage());
                }

                System.out.println("Back to main menu? (Y/N)");
                String menu = scanner.nextLine();
                Boolean toMenu = menu.toLowerCase().equals("y") ? true : false;
                start(toMenu);
                break;
            case 2:
                System.out.println("Delete Employee");
                break;
            case 3:
                System.out.println("Find Employee");
                break;
        }
    }
}

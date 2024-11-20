import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Console {

    private final Scanner scanner;
    ObjectMapper objectMapper = new ObjectMapper();
    File file = new File("src/main/db/db.json");

    public Console(Scanner scanner) {
        this.scanner = scanner;  // Initialize the scanner field
    }


    public void start(Boolean menu) {

        if(menu) {
            System.out.println("Employee Management System");
            System.out.println("--------------------------");
            System.out.println("Make a selection:");
            System.out.println("(1). Create Employee");
            System.out.println("(2). Delete Employee");
            System.out.println("(3). Find Employee");

            int userChoice = scanner.nextInt();
            display(userChoice);
        } else {
            System.out.println("Goodbye...");
        }
    }

    public void display(int userChoice) {
        switch (userChoice) {
            case 1:
                System.out.println("Create Employee");
                System.out.println("Employee first name:");
                scanner.nextLine();
                String firstName = scanner.nextLine().strip();


                System.out.println("Employee last name:");
                String lastName = scanner.nextLine().strip();

                System.out.println("Employee age:");
                int age = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Employee email:");
                String email = scanner.nextLine().strip();

                System.out.println("Employee position:");
                String position = scanner.nextLine().strip();

                Employee employee = new Employee(firstName, lastName, age, email, position);

                try {
                    // Read existing employees from JSON file (if any)
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

                Boolean toMenu = menu.equalsIgnoreCase("y");
                start(toMenu);

                break;

            case 2:
                System.out.println("Delete Employee");
                System.out.println("Employee first and last name:");
                scanner.nextLine();
                String fullName = scanner.nextLine().strip();

                try{
                    List<Employee> employees;

                    if (file.exists() && file.length() > 0) {
                        employees = objectMapper.readValue(file, objectMapper.getTypeFactory().constructCollectionType(List.class, Employee.class));
                    } else {
                        employees = new ArrayList<>();
                    }

                    Employee cannedEmployee = null;
                    for (Employee person : employees) {
                        if (person.getName().equals(fullName)) {
                            cannedEmployee = person;
                            break;
                        }
                    }

                    if (cannedEmployee != null) {
                        employees.remove(cannedEmployee);
                        System.out.println("Employee " + fullName + " successfully deleted.");
                    } else {
                        System.out.println("Employee " + fullName + " not found.");
                    }

                    objectMapper.writeValue(file, employees);

                } catch (IOException e) {
                    System.out.println("Error occurred: " + e.getMessage());
                }

                System.out.println("Back to main menu? (Y/N)");
                menu = scanner.nextLine();

                toMenu = menu.equalsIgnoreCase("y");
                start(toMenu);

                break;
            case 3:
                System.out.println("Find Employee");

                System.out.println("Employee ID:");
                scanner.nextLine();
                Integer findID = scanner.nextInt();
                scanner.nextLine();

                try{
                    List<Employee> employees;

                    if (file.exists() && file.length() > 0) {
                        employees = objectMapper.readValue(file, objectMapper.getTypeFactory().constructCollectionType(List.class, Employee.class));
                    } else {
                        employees = new ArrayList<>();
                    }

                    Employee foundEmployee = null;
                    for (Employee person : employees) {
                        if (person.getEmployeeId().equals(findID)) {
                            foundEmployee = person;
                            break;
                        }
                    }

                    if (foundEmployee != null) {
                        System.out.println(foundEmployee.toString());
                    } else {
                        System.out.println("Employee " + findID + " not found.");
                    }

                    objectMapper.writeValue(file, employees);

                } catch (IOException e) {
                    System.out.println("Error occurred: " + e.getMessage());
                }

                System.out.println("Back to main menu? (Y/N)");
                menu = scanner.nextLine();

                toMenu = menu.equalsIgnoreCase("y");
                start(toMenu);

                break;
        }
    }
}
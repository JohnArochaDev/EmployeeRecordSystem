import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class Console {

    ObjectMapper objectMapper = new ObjectMapper();


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
                Employee employee = new Employee("John", "Doe", 24, "test@test.com", "test");
                try {
                    objectMapper.writeValue(new File("src/main/db/db.json"), employee);
                    System.out.println("Employee successfully created");
                } catch (IOException e) {
                    System.out.println("Error occurred: ");
                    System.out.println(e);
                }

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

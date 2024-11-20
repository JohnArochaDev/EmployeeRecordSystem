import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class Employee {
    private String name;
    private String email;
    private String position;
    private Integer age; // Integer type for age, as in the constructor
    private final int employeeId;

    // Static variable to track the next employee ID
    private static int nextEmployeeId = 1;

    // File that stores the next employee ID (in case we need to persist it)
    private static final File nextEmployeeIdFile = new File("src/main/db/nextEmployeeId.json");

    // Default constructor for Jackson
    public Employee() {
        this.employeeId = nextEmployeeId++;
        saveNextEmployeeId(); // Save the updated nextEmployeeId after creating an employee
    }

    // Constructor with fields
    public Employee(String firstName, String lastName, Integer age, String email, String position) {
        this.name = firstName + " " + lastName;
        this.age = age;
        this.email = email;
        this.position = position;
        this.employeeId = nextEmployeeId++;
        saveNextEmployeeId(); // Save the updated nextEmployeeId after creating an employee
    }

    // Static method to save the next employee ID to a file
    private static void saveNextEmployeeId() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(nextEmployeeIdFile, nextEmployeeId); // Write the nextEmployeeId value to the file
        } catch (IOException e) {
            System.out.println("Error saving next employee ID: " + e.getMessage());
        }
    }

    // Static method to load the next employee ID from the file
    private static void loadNextEmployeeId() {
        if (nextEmployeeIdFile.exists() && nextEmployeeIdFile.length() > 0) {
            try {
                ObjectMapper objectMapper = new ObjectMapper();
                nextEmployeeId = objectMapper.readValue(nextEmployeeIdFile, Integer.class); // Read nextEmployeeId from the file
            } catch (IOException e) {
                System.out.println("Error loading next employee ID: " + e.getMessage());
            }
        }
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPosition() {
        return position;
    }

    public Integer getAge() {
        return age;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    // Static method to set the next available employee ID (useful for loading from file)
    public static void setNextEmployeeId(int nextId) {
        nextEmployeeId = nextId;
        saveNextEmployeeId(); // Save the new value
    }

    // Static method to get the next available employee ID
    public static int getNextEmployeeId() {
        return nextEmployeeId;
    }

    @Override
    public String toString() {
        return "Employee{" +
               "name='" + name + '\'' +
               ", email='" + email + '\'' +
               ", position='" + position + '\'' +
               ", age=" + age +
               ", employeeId=" + employeeId +
               '}';
    }

    // Static block to load the nextEmployeeId from file when the class is loaded
    static {
        loadNextEmployeeId();
    }
}

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class Employee {
    private String name;
    private String email;
    private String position;
    private Integer age; // Integer type for age, as in the constructor
    private final int employeeId;

    private static int nextEmployeeId = 1;

    private static final File nextEmployeeIdFile = new File("src/main/db/nextEmployeeId.json");

    public Employee() {
        this.employeeId = nextEmployeeId++;
        saveNextEmployeeId();
    }

    public Employee(String firstName, String lastName, Integer age, String email, String position) {
        this.name = firstName + " " + lastName;
        this.age = age;
        this.email = email;
        this.position = position;
        this.employeeId = nextEmployeeId++;
        saveNextEmployeeId();
    }

    private static void saveNextEmployeeId() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(nextEmployeeIdFile, nextEmployeeId);
        } catch (IOException e) {
            System.out.println("Error saving next employee ID: " + e.getMessage());
        }
    }

    private static void loadNextEmployeeId() {
        if (nextEmployeeIdFile.exists() && nextEmployeeIdFile.length() > 0) {
            try {
                ObjectMapper objectMapper = new ObjectMapper();
                nextEmployeeId = objectMapper.readValue(nextEmployeeIdFile, Integer.class);
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

    public static void setNextEmployeeId(int nextId) {
        nextEmployeeId = nextId;
        saveNextEmployeeId();
    }

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

    static {
        loadNextEmployeeId();
    }
}

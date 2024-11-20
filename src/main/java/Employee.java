public class Employee {
    private String name;
    private String email;
    private String position;
    private Integer age; // Integer type for age, as in the constructor
    private final int employeeId;

    private static int nextEmployeeId = 1;

    public Employee(String firstName, String lastName, Integer age, String email, String position) {
        this.name = firstName + " " + lastName;
        this.age = age;
        this.email = email;
        this.position = position;
        this.employeeId = nextEmployeeId++;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setAge(Integer age) {  // Set Integer to match the field type
        this.age = age;
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
}

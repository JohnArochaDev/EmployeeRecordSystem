public class Employee {
    private String name;
    private String email;
    private String position;
    private String age;
    private Integer employeeId;

    private static int nextEmployeeId = 1;

    public Employee(String firstName, String lastName, String age, String email, String position, Integer employeeId) {
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

    public String getAge() {
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
    public void setAge(String age) {
        this.age = age;
    }
}
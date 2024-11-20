public class Console {


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

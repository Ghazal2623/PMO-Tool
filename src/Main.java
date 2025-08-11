import java.util.*;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Map<Integer, Employee> employees = new HashMap<>();

    public static void main(String[] args) {
        int choice;
        do {
            showMenu();
            choice = getChoice();
            switch (choice) {
                case 1 -> addEmployee();
                case 2 -> viewEmployees();
                case 3 -> searchEmployee();
                case 4 -> deleteEmployee();
                case 5 -> System.out.println("Exiting application. Goodbye!");
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
    }

    private static void showMenu() {
        System.out.println("\n=== Employee Management System ===");
        System.out.println("1. Add Employee");
        System.out.println("2. View All Employees");
        System.out.println("3. Search Employee by ID");
        System.out.println("4. Delete Employee by ID");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    private static int getChoice() {
        while (!scanner.hasNextInt()) {
            System.out.print("Please enter a valid number: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private static void addEmployee() {
        System.out.print("Enter Employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter Employee Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Department: ");
        String department = scanner.nextLine();

        Employee employee = new Employee(id, name, department);
        employees.put(id, employee);
        System.out.println("✅ Employee added successfully.");
    }

    private static void viewEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
        } else {
            System.out.println("\nEmployee List:");
            employees.values().forEach(System.out::println);
        }
    }

    private static void searchEmployee() {
        System.out.print("Enter Employee ID to search: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Employee emp = employees.get(id);
        if (emp != null) {
            System.out.println("Employee Found: " + emp);
        } else {
            System.out.println("❌ Employee not found.");
        }
    }

    private static void deleteEmployee() {
        System.out.print("Enter Employee ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        if (employees.remove(id) != null) {
            System.out.println("✅ Employee deleted successfully.");
        } else {
            System.out.println("❌ Employee not found.");
        }
    }
}

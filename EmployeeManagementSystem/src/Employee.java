import java.io.*;
import java.util.*;

class Employee {
    private int id;
    private String name;
    private double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Salary: " + salary;
    }
}

class EmployeeManagementSystem {
    private List<Employee> employees;
    private static final String FILENAME = "employees.txt";

    public EmployeeManagementSystem() {
        employees = new ArrayList<>();
        loadEmployeesFromFile();
    }

    private void loadEmployeesFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILENAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                String name = data[1];
                double salary = Double.parseDouble(data[2]);
                employees.add(new Employee(id, name, salary));
            }
        } catch (IOException e) {
            // Handle file read error
        }
    }

    public void saveEmployeesToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILENAME))) {
            for (Employee employee : employees) {
                writer.write(employee.getId() + "," + employee.getName() + "," + employee.getSalary());
                writer.newLine();
            }
        } catch (IOException e) {
            // Handle file write error
        }
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
        saveEmployeesToFile();
    }

    public Employee findEmployeeById(int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }

    public void updateEmployee(int id, String newName, double newSalary) {
        Employee employee = findEmployeeById(id);
        if (employee != null) {
            employee.setName(newName);
            employee.setSalary(newSalary);
            saveEmployeesToFile();
        } else {
            System.out.println("Employee not found.");
        }
    }

    public void deleteEmployee(int id) {
        Employee employee = findEmployeeById(id);
        if (employee != null) {
            employees.remove(employee);
            saveEmployeesToFile();
            System.out.println("Employee deleted successfully.");
        } else {
            System.out.println("Employee not found.");
        }
    }

    public void listEmployees() {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EmployeeManagementSystem ems = new EmployeeManagementSystem();

        while (true) {
            System.out.println("1. Add Employee");
            System.out.println("2. List Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter employee ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter employee name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter employee salary: ");
                    double salary = scanner.nextDouble();
                    ems.addEmployee(new Employee(id, name, salary));
                    break;
                case 2:
                    ems.listEmployees();
                    break;
                case 3:
                    System.out.print("Enter employee ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    Employee existingEmployee = ems.findEmployeeById(updateId);
                    if (existingEmployee != null) {
                        System.out.print("Enter new employee name: ");
                        String newName = scanner.nextLine();
                        System.out.print("Enter new employee salary: ");
                        double newSalary = scanner.nextDouble();
                        ems.updateEmployee(updateId, newName, newSalary);
                    } else {
                        System.out.println("Employee not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter employee ID to delete: ");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    ems.deleteEmployee(deleteId);
                    break;
                case 5:
                    ems.saveEmployeesToFile();
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
}

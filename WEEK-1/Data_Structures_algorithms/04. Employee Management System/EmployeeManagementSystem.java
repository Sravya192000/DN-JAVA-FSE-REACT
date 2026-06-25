class Employee {

    int employeeId;
    String name;
    String position;
    double salary;

    public Employee(int employeeId,
            String name,
            String position,
            double salary) {

        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public String toString() {

        return "ID: " + employeeId +
                ", Name: " + name +
                ", Position: " + position +
                ", Salary: Rs." + salary;
    }
}

public class EmployeeManagementSystem {

    static Employee[] employees = new Employee[10];
    static int count = 0;

    // Add Employee

    public static void addEmployee(Employee employee) {

        if (count < employees.length) {

            employees[count] = employee;
            count++;

            System.out.println(
                    "Employee added successfully.");
        } else {

            System.out.println(
                    "Employee array is full.");
        }
    }

    // Search Employee

    public static Employee searchEmployee(
            int employeeId) {

        for (int i = 0; i < count; i++) {

            if (employees[i].employeeId == employeeId) {

                return employees[i];
            }
        }

        return null;
    }

    // Traverse Employees

    public static void traverseEmployees() {

        System.out.println(
                "\nEmployee Records:");

        for (int i = 0; i < count; i++) {

            System.out.println(
                    employees[i]);
        }
    }

    // Delete Employee

    public static void deleteEmployee(
            int employeeId) {

        int index = -1;

        for (int i = 0; i < count; i++) {

            if (employees[i].employeeId == employeeId) {

                index = i;
                break;
            }
        }

        if (index == -1) {

            System.out.println(
                    "Employee not found.");

            return;
        }

        for (int i = index; i < count - 1; i++) {

            employees[i] = employees[i + 1];
        }

        employees[count - 1] = null;
        count--;

        System.out.println(
                "Employee deleted successfully.");
    }

    public static void main(String[] args) {

        addEmployee(
                new Employee(
                        101,
                        "Sravya",
                        "Developer",
                        50000));

        addEmployee(
                new Employee(
                        102,
                        "Rahul",
                        "Tester",
                        40000));

        addEmployee(
                new Employee(
                        103,
                        "Ananya",
                        "Manager",
                        70000));

        traverseEmployees();

        System.out.println(
                "\nSearching Employee ID 102:");

        Employee found = searchEmployee(102);

        if (found != null) {

            System.out.println(found);
        }

        System.out.println(
                "\nDeleting Employee ID 102");

        deleteEmployee(102);

        traverseEmployees();
    }
}
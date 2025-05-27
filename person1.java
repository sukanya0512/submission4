import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

class Person {
    protected String name;

    public Person(String name) {
        this.name = name;
    }

    public void displayPersonName() {
        System.out.println("Name: " + name);
    }

    public void displayAge(String dob) {
        LocalDate birthDate = parseDate(dob);
        LocalDate currentDate = LocalDate.now();
        Period age = Period.between(birthDate, currentDate);
        System.out.println("Age: " + age.getYears() + " years");
    }

    private LocalDate parseDate(String dob) {
        DateTimeFormatter formatter;
        if (dob.matches("\\d{2}-\\d{2}-\\d{4}")) {
            formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        } else if (dob.matches("\\d{4}-\\d{2}-\\d{2}")) {
            formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        } else {
            throw new IllegalArgumentException("Invalid date format.");
        }
        return LocalDate.parse(dob, formatter);
    }
}

class Employee extends Person {
    private int empId;
    private double salary;

    public Employee(String name, int empId, double salary) {
        super(name);
        this.empId = empId;
        this.salary = salary;
    }
     public void displayEmployeeDetails() {
        displayPersonName();
        System.out.println("Employee ID: " + empId);
        System.out.println("Salary: $" + salary);
    }
}
public class person1 {
    public static void main (String[] args) {
        // Hardcoded input using constructors
        String name = "sukanya";
        String dob = "2005-12-05"; 
        int empId = 111;
        double salary = 55000.75;
        Employee emp = new Employee (name, empId, salary);
        emp.displayEmployeeDetails();
        emp.displayAge(dob);
    }
}
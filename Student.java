import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.Scanner;

public class Student {

    private String name;
    private Date dob;

    // Method to read input from user
    public void inputDetails() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter student's name: ");
        name = scanner.nextLine();

        System.out.print("Enter student's date of birth (DD-MM-YYYY or YYYY-MM-DD): ");
        String dobStr = scanner.nextLine();

        dob = parseDob(dobStr);
    }

    // Method to parse date from string
    private Date parseDob(String dobStr) {
        String[] formats = { "dd-MM-yyyy", "yyyy-MM-dd" };
        for (String format : formats) {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat(format);
                sdf.setLenient(false);
                return sdf.parse(dobStr);
            } catch (ParseException ignored) {}
        }
        System.out.println("Invalid date format. Please use DD-MM-YYYY or YYYY-MM-DD.");
        System.exit(1);
        return null; // unreachable, but required
    }

    // Method to calculate age
    public int calculateAge() {
        LocalDate birthDate = dob.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return Period.between(birthDate, LocalDate.now()).getYears();
    }

    // Method to display student info
    public void displayInfo() {
        System.out.println("\n--- Student Information ---");
        System.out.println("Name: " + name);
        System.out.println("Age: " + calculateAge());
    }

    // Main method to run the program
    public static void main(String[] args) {
        Student student = new Student();
        student.inputDetails();
        student.displayInfo();
    }
}

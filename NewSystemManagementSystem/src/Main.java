import java.util.Scanner;

// REMEMBER TO ADD UPDATE FEATURE LATER IN THE FUTURE
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentService service = new StudentService(); // Our "Brain"

        boolean running = true;

        while (running){
            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Delete Students");
            System.out.println("4. Search Students");
            System.out.println("0. Exit");
            System.out.println("Choose an option: ");

            try {               //  ORRR          while  (hasNextInt)
                String stringChoice = sc.nextLine();
                int choice = Integer.parseInt(stringChoice);

                switch (choice) {
                    case 1 -> {
                        try {
                        String name = getValidInput(sc, "Input Name: ");

                        System.out.println("Input Age: ");
                        String ageChoice = sc.nextLine();
                        int age = Integer.parseInt(ageChoice);

                        String course = getValidInput(sc, "Input Course: ");

                        service.addStudent(name, age, course);

                        } catch (NumberFormatException badUserDate){
                            System.out.println("Characters are not allowed in age!!! Try again.");
                        }
                    }
                    case 2 -> service.viewAllStudents();

                    case 3 -> {
                        System.out.print("Enter ID to delete: ");
                        String deleteId = sc.nextLine();
                        service.deleteStudent(deleteId);
                    }

                    case 4 -> {
                        System.out.print("Enter ID to search: ");
                        String searchId = sc.nextLine();
                        service.searchStudent(searchId);
                    }

                    case 0 -> {
                        running = false;
                        System.out.println("Exiting... Goodbye!");
                    }
                    default -> System.out.println("Invalid choice. Try again.");
                }
            } catch (NumberFormatException badUserDate){
                System.out.println("Characters not allowed!!! Try again.");
            }
        }
        sc.close();
    }

    public static String getValidInput(Scanner sc,
                                       String prompt){
        String input;
        while (true){
            System.out.println(prompt); // ex: "Input Name:
            input = sc.nextLine();

            if (input.contains("@@")){
                System.out.println("Error: Wrong input, try again without '@@");
            } else if (input.trim().isEmpty()){
                System.out.println("Error: Input cannot be empty.");
            } else {
                return input; // Success! Return the clean string
            }
        }
    }
}

// ANOTHER WAY TO DO EXCEPTION HANDLING FOR OPTIONS

/* int choice = -1; // Default safe value

System.out.print("Choose an option: ");
String input = sc.nextLine(); // Read the whole input as text

try {
    choice = Integer.parseInt(input); // Try converting text to a number
} catch (NumberFormatException e) {
    // If they typed letters, this block catches it!
    System.out.println("Error: Please enter a valid number, not text.");
    continue; // Skips the switch statement and restarts the loop
}

switch (choice) {
    // Your cases (1, 2, 3, 4, 0) stay exactly the same here!
}*/


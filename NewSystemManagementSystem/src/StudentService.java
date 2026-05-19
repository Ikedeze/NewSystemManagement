import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class StudentService {
    public StudentService() {
        loadStudents();
    }
    private List<Student> students = new ArrayList<>();
    private int nextId = 1;

    public void addStudent(String name, int age, String course){
        String generatedId = "NIIT" + nextId;

        Student newStudent = new Student(name, age, course, generatedId);

        students.add(newStudent);

        nextId++;

        System.out.println("Student added successfully with ID: " + generatedId);

        saveStudents();

    }

    public void viewAllStudents(){
        if (students.isEmpty()) {
            System.out.println("No students found");
        }
        else {
            System.out.println("\n==== STUDENTS LIST ====\n");
            for (int i = 0; i < students.size(); i++){
                Student stn = students.get(i);
                System.out.println("ID: " + stn.getId() +
                        " | Name: " + stn.getName() +
                        " | Course: " + stn.getCourse());
                System.out.println("---------------------" +
                        "--------------------------------------");
            }


        }
    }

    public void deleteStudent(String id) {
        boolean found = false;

        for (int i = 0; i < students.size(); i++){
            if (students.get(i).getId().equalsIgnoreCase(id)) {
                students.remove(i);
                found = true;
                System.out.println("Student with ID " + id + " has been deleted.");
                saveStudents();
                System.out.println("Data saved successfully");
                break;  // Stop looking once we find and delete them
            }
        }
        if (!found){
            System.out.println("Error: Student with ID" + id + " not found.");
        }
    }

    public void searchStudent(String id){
        boolean found = false;

        for (int i = 0; i < students.size(); i++){
            if (students.get(i).getId().equalsIgnoreCase(id)){
                Student stn = students.get(i);
                System.out.println("ID: " + stn.getId() +
                        " | Name: " + stn.getName() +
                        " | Course: " + stn.getCourse());
                found = true;
                break;
            }
        }

        if (!found){
            System.out.println("Error: Student with ID " + id + " not found.");
        }
    }

    public void saveStudents(){
        try (PrintWriter writer = new PrintWriter(new FileWriter("students.txt"))){
            for (Student st : students){
                // Formating the string: name@@age@@course@@id
                String line = st.getName() + "@@" +
                        st.getAge()  + "@@" +
                        st.getCourse() + "@@" +
                        st.getId();
                writer.println(line);
            }
            System.out.println("Data saved successfully to student.txt!");
        } catch (IOException e){
            System.out.println("Error saving to file: " + e.getMessage());
        }
    }

    public void loadStudents(){
        File file = new File("students.txt");

        // If the file doesn't exist yet (first time running),
        // just stop silently
        if (!file.exists()) {
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))){
            String line;
            while ((line = reader.readLine()) != null){
                // Split the line by "@@" into an array of Strings
                String[] data = line.split("@@");

                // data[0] = Name, data[1] = Age, data[2] = Course, data[3] = ID
                String name = data[0];
                int age = Integer.parseInt(data[1]); // Convert String "20" to int 20
                String course = data[2];
                String id = data[3];

                // Rebuild the student object and add it to the list
                Student student = new Student(name, age, course, id);
                students.add(student);

                // Update nextId tracker so new students get the
                // correct next ID number
                // Example: if ID is "NIIT3", extract the "3" and
                //  make nextId = 4
                int idNum = Integer.parseInt(id.replace("NIIT", ""));
                if (idNum >= nextId) {
                    nextId = idNum + 1;
                }
            }
            System.out.println("Data loaded successfully from students.txt!");
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error loading data: " + e.getMessage());
        }
    }

}

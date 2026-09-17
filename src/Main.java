
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentManager mgr = new StudentManager();
        String filename = "students.txt";

        
        mgr.loadFromFile(filename);

        int ch = 0;

        while(ch != 6) {

            System.out.println("\n===== STUDENT GRADE MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student by Roll No");
            System.out.println("4. Delete Student by Roll No");
            System.out.println("5. Save Data to File");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            
            ch = sc.nextInt();

            if(ch == 1) {
                sc.nextLine(); 
                System.out.print("Enter Name: ");
                String name = sc.nextLine();
                System.out.print("Enter Roll No: ");
                int roll = sc.nextInt();

                int marks[] = new int[5];
                System.out.println("Enter marks for 5 subjects (out of 100 each):");
                for(int i=0; i<5; i++) {
                    System.out.print("Subject " + (i+1) + ": ");
                    marks[i] = sc.nextInt();
                }

                Student s = new Student(name, roll, marks);
                mgr.addStudent(s);
            }
            else if(ch == 2) {
                mgr.displayAll();
            }
            else if(ch == 3) {
                System.out.print("Enter roll no to search: ");
                int roll = sc.nextInt();
                Student found = mgr.searchStudent(roll);
                if(found == null) {
                    System.out.println("no student found with that roll no");
                }
                else {
                    found.printInfo();
                    double perc = GradeCalculator.getPercentage(found.marks);
                    System.out.println("Percentage: " + perc + "%");
                    System.out.println("Grade: " + GradeCalculator.getGrade(perc));
                }
            }
            else if(ch == 4) {
                System.out.print("Enter roll no to delete: ");
                int roll = sc.nextInt();
                boolean done = mgr.deleteStudent(roll);
                if(done) {
                    System.out.println("student deleted");
                }
                else {
                    System.out.println("roll no not found, nothing deleted");
                }
            }
            else if(ch == 5) {
                mgr.saveToFile(filename);
            }
            else if(ch == 6) {
                
                mgr.saveToFile(filename);
                System.out.println("saving data and exiting... bye!");
            }
            else {
                System.out.println("invalid choice, try again pls");
            }
        }

        sc.close();
    }
}

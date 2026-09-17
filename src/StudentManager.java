import java.io.*;
import java.util.*;

public class StudentManager {

    Student studentList[] = new Student[100]; 
    int count = 0; 

    
    public void addStudent(Student s) {
        if(count >= 100) {
            System.out.println("sorry list is full cant add more students");
            return;
        }
        studentList[count] = s;
        count++;
        System.out.println("student added successfully!");
    }

    
    public Student searchStudent(int roll) {
        for(int i=0; i<count; i++) {
            if(studentList[i].roll == roll) {
                return studentList[i];
            }
        }
        return null; 
    }

    
    public boolean deleteStudent(int roll) {
        int index = -1;
        for(int i=0; i<count; i++) {
            if(studentList[i].roll == roll) {
                index = i;
                break;
            }
        }
        if(index == -1) {
            return false; 
        }
        
        for(int i=index; i<count-1; i++) {
            studentList[i] = studentList[i+1];
        }
        studentList[count-1] = null;
        count--;
        return true;
    }

    
    public void displayAll() {
        if(count == 0) {
            System.out.println("no students yet, add some first");
            return;
        }
        for(int i=0; i<count; i++) {
            System.out.println("---------------------------");
            studentList[i].printInfo();
            double avg = GradeCalculator.getAverage(studentList[i].marks);
            double perc = GradeCalculator.getPercentage(studentList[i].marks);
            String grade = GradeCalculator.getGrade(perc);
            System.out.println("Average: " + avg);
            System.out.println("Percentage: " + perc + "%");
            System.out.println("Grade: " + grade);
        }
        System.out.println("---------------------------");
    }

    
    public void saveToFile(String filename) {
        try {
            FileWriter fw = new FileWriter(filename);
            BufferedWriter bw = new BufferedWriter(fw);
            for(int i=0; i<count; i++) {
                Student s = studentList[i];
                String line = s.roll + "," + s.name;
                for(int j=0; j<s.marks.length; j++) {
                    line = line + "," + s.marks[j];
                }
                bw.write(line);
                bw.newLine();
            }
            bw.close();
            System.out.println("saved to file: " + filename);
        }
        catch(Exception e) {
            System.out.println("something went wrong while saving file");
            e.printStackTrace();
        }
    }

    
    public void loadFromFile(String filename) {
        File f = new File(filename);
        if(!f.exists()) {
           
            return;
        }
        try {
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while((line = br.readLine()) != null) {
                if(line.trim().equals("")) {
                    continue; 
                }
                String parts[] = line.split(",");
                int roll = Integer.parseInt(parts[0]);
                String name = parts[1];
                int m[] = new int[5];
                for(int i=0; i<5; i++) {
                    m[i] = Integer.parseInt(parts[i+2]);
                }
                Student s = new Student(name, roll, m);
                studentList[count] = s;
                count++;
            }
            br.close();
            System.out.println("loaded existing data from " + filename);
        }
        catch(Exception e) {
            System.out.println("couldnt load file properly, starting fresh");
        }
    }
}

// Student.java
// this class is just for storing student data
// name, roll no, and marks in 5 subjects (fixed for now)

public class Student {

    public String name;
    public int roll;
    public int marks[] = new int[5]; // sub1,sub2,sub3,sub4,sub5

    // constructor
    public Student(String n, int r, int m[]) {
        name = n;
        roll = r;
        for(int i=0; i<5; i++) {
            marks[i] = m[i];
        }
    }

    // just prints student info, didnt bother with toString override properly lol
    public void printInfo() {
        System.out.println("Roll No: " + roll);
        System.out.println("Name: " + name);
        System.out.print("Marks: ");
        for(int i=0; i<marks.length; i++) {
            System.out.print(marks[i] + " ");
        }
        System.out.println();
    }
}

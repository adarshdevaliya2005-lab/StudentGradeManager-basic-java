

public class Student {

    public String name;
    public int roll;
    public int marks[] = new int[5]; 

    
    public Student(String n, int r, int m[]) {
        name = n;
        roll = r;
        for(int i=0; i<5; i++) {
            marks[i] = m[i];
        }
    }

    
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

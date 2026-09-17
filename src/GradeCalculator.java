// GradeCalculator.java
// does the maths for total, avg, percentage and grade

public class GradeCalculator {

    // adds up all marks
    public static int getTotal(int marks[]) {
        int total = 0;
        for(int i=0; i<marks.length; i++) {
            total = total + marks[i];
        }
        return total;
    }

    // gets average marks
    public static double getAverage(int marks[]) {
        int t = getTotal(marks);
        double avg = (double)t / marks.length;
        return avg;
    }

    // percentage out of 100 per subject, assuming each subject max is 100
    public static double getPercentage(int marks[]) {
        int t = getTotal(marks);
        double perc = (t / (double)(marks.length * 100)) * 100;
        return perc;
    }

    // decides the grade letter, using basic if else, nothing fancy
    public static String getGrade(double percentage) {
        String grade = "";
        if(percentage >= 90) {
            grade = "A+";
        }
        else if(percentage >= 80 && percentage < 90) {
            grade = "A";
        }
        else if(percentage >= 70 && percentage < 80) {
            grade = "B";
        }
        else if(percentage >= 60 && percentage < 70) {
            grade = "C";
        }
        else if(percentage >= 50 && percentage < 60) {
            grade = "D";
        }
        else if(percentage >= 40 && percentage < 50) {
            grade = "E";
        }
        else {
            grade = "F";
        }
        return grade;
    }
}

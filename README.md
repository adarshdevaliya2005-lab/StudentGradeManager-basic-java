# Student Grade Management System

A simple command-line Java application to manage student records and grades. Built as a mini project for the "Programming in Java" course.

## What it does

This program lets you:
- Add a new student (name, roll number, marks in 5 subjects)
- View all students along with their average, percentage, and letter grade
- Search for a student by roll number
- Delete a student by roll number
- Save all data to a text file (`students.txt`) so it's not lost when the program closes
- Automatically reload saved data the next time you run the program

It's a plain Java console application — no external libraries, no database, no GUI. Everything runs in the terminal.

## Prerequisites

You need Java installed on your machine (JDK, not just JRE, since we need to compile).

Check if you already have it:
```
java -version
javac -version
```

If those commands don't work, install a JDK (version 8 or higher works fine, this was built and tested on JDK 21):
- Windows/Mac/Linux: download from [Oracle](https://www.oracle.com/java/technologies/downloads/) or use [OpenJDK](https://openjdk.org/)

## How to Clone this Repository

```
git clone https://github.com/yourusername/StudentGradeManager.git
cd StudentGradeManager
```

## How to Compile

From the root of the project folder, run:

```
javac src/*.java -d bin
```

This compiles all the `.java` files from `src/` and puts the compiled `.class` files into a new `bin/` folder.

## How to Run

After compiling, run:

```
java -cp bin Main
```

The menu will show up in your terminal and you can start using it.

## Example Usage

```
===== STUDENT GRADE MANAGEMENT SYSTEM =====
1. Add Student
2. View All Students
3. Search Student by Roll No
4. Delete Student by Roll No
5. Save Data to File
6. Exit
Enter your choice: 1
Enter Name: Riya Sharma
Enter Roll No: 101
Enter marks for 5 subjects (out of 100 each):
Subject 1: 85
Subject 2: 90
Subject 3: 78
Subject 4: 92
Subject 5: 88
student added successfully!
```

Choosing option 2 (View All Students) later shows:

```
---------------------------
Roll No: 101
Name: Riya Sharma
Marks: 85 90 78 92 88
Average: 86.6
Percentage: 86.6%
Grade: A
---------------------------
```

Data is saved automatically when you choose option 6 (Exit), or manually anytime with option 5. The next time you run the program, it will say "loaded existing data from students.txt" and your students will still be there.

## Folder Structure

```
StudentGradeManager/
├── src/
│   ├── Main.java              -> menu loop, program entry point
│   ├── Student.java           -> stores one student's data
│   ├── GradeCalculator.java   -> calculates total, average, percentage, grade
│   └── StudentManager.java    -> handles add/search/delete/display/save/load
├── README.md
└── .gitignore
```

## Features

- Add student records with name, roll number, and marks in 5 subjects
- Automatic calculation of total, average, percentage, and letter grade (A+ to F)
- View all students at once
- Search any student instantly by roll number
- Delete a student record by roll number
- Data is saved to a plain text file (`students.txt`) and reloaded automatically on next run
- Fully runs from the command line, no GUI required

## Notes

- Marks are assumed to be out of 100 per subject.
- This project uses a fixed-size array (max 100 students) instead of a dynamic list, kept simple on purpose for the scope of this assignment.
- No input validation is done on non-numeric input for menu choices/marks (assumes the user enters valid numbers).

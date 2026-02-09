// Lab04BC0506st.java
// The Student Records Program I
// This is the student, starting version of the Lab04A0306 assignment.

import java.io.*;
import java.util.Scanner;
import java.io.PrintWriter;

public class Lab04BC0506st {
    public static void main(String[] args) throws IOException {
        System.out.println("****************************************");
        System.out.println("Lab for Unit 4, Parts B & C, Topics 5-6");
        System.out.println("100 Point Version");
        System.out.println("By: John Smith");   // Substitute your own name here.
        System.out.println("****************************************\n");

        Students myStudents = new Students("students.txt");
        myStudents.displayAll();
        myStudents.displayAverages();
        myStudents.displayYoungest();
        myStudents.displayOldest();
        myStudents.displayValedictorian();
        myStudents.createProbationList();
        myStudents.displayProbationList();
        myStudents.createHonorRoll();
        myStudents.displayHonorRoll();
    }
}


class Students {
    private Student[] students;
    private int numStudents;

    public Students(String fileName) {
        try {
            File textFile  = new File(fileName);
            Scanner scanner = new Scanner(textFile);

            String name = "";
            String age = "";
            String gpa = "";

            while (scanner.hasNextLine())
            {
                name += scanner.nextLine() + ";";
                age += scanner.nextLine() + ";";
                gpa += scanner.nextLine() + ";";
            }
            String[] nameArray = name.split(";");
            String[] ageArray = age.split(";");
            String[] gpaArray = gpa.split(";");
            this.numStudents = nameArray.length;
            this.students = new Student[numStudents];
            for(int i = 0; i < numStudents; i++){
                String studentName = nameArray[i];
                int studentAge = Integer.parseInt(ageArray[i]);
                double studentGpa = Double.parseDouble(gpaArray[i]);
                Student student = new Student(studentName, studentAge, studentGpa);
                this.students[i]= student;
            }
            scanner.close();
        }
        catch(IOException e) {
            System.out.println("Error opening file: " + fileName);
        }
    }

    public void displayAll() {
        System.out.println("\n\nList of All Students");
        System.out.println("====================");
        for (Student student : this.students){
            student.displayStudent();
        }
    }

    public void displayAverages() {
        System.out.println("\n\nAverages");
        System.out.println("========");
        double ageSum = 0.0;
        double gpaSum = 0.0;
        for(int i = 0; i < numStudents; i++){
            int currentStudentAge = students[i].getAge();
            ageSum += currentStudentAge;
            double currentStudentGpa = students[i].getGPA();
            gpaSum += currentStudentGpa;
        }
        double averageAge = ageSum/this.numStudents;
        double averageGpa = gpaSum/this.numStudents;
        System.out.println();
        System.out.printf("Average Age: %.3f\n", averageAge);
        System.out.printf("Average GPA: %.3f\n", averageGpa);

    }

    // Precondition: There is exactly one youngest student.
    public void displayYoungest() {
        System.out.println("\n\nYoungest Student");
        System.out.println("================");
        int youngestIndex = 0;
        for(int i = 1; i < numStudents; i++){
            int youngestIndexAge = students[youngestIndex].getAge();
            int currentIndexAge = students[i].getAge();
            if(currentIndexAge < youngestIndexAge){
                youngestIndex = i;
            }
        }
        students[youngestIndex].displayStudent();
    }

    // Precondition: The is exactly one oldest student.
    public void displayOldest() {
        System.out.println("\n\nOldest Student");
        System.out.println("================");
        int oldestIndex = 0;
        for(int i = 1; i < numStudents; i++){
            int oldestIndexAge = students[oldestIndex].getAge();
            int currentIndexAge = students[i].getAge();
            if(currentIndexAge > oldestIndexAge){
                oldestIndex = i;
            }
        }
        students[oldestIndex].displayStudent();
    }

    // Precondition: The is exactly one Valedictorian.
    public void displayValedictorian() {
        System.out.println("\n\nValedictorian");
        System.out.println("================");
        int valedictorianIndex = 0;
        for(int i = 1; i < numStudents; i++){
            double valedictorianIndexGpa = students[valedictorianIndex].getGPA();
            double currentIndexGpa = students[i].getGPA();
            if(currentIndexGpa > valedictorianIndexGpa){
                valedictorianIndex = i;
            }
        }
        students[valedictorianIndex].displayStudent();
    }

    public void createProbationList() throws IOException {
        File probationList = new File("probationlist.txt");
        PrintWriter printWriter = new PrintWriter(probationList);
        for(int i = 0; i <numStudents; i++){
            Student currentStudent = students[i];
            if(currentStudent.getGPA() < 2.0){
                printWriter.println(currentStudent.getName());
                printWriter.println(currentStudent.getAge());
                printWriter.println(currentStudent.getGPA());
            }
        }
        printWriter.close();
    }

    public void displayProbationList() throws IOException {
        System.out.println("\n\nProbation List");
        System.out.println("==============");
        File probationList  = new File("probationlist.txt");
        Scanner scanner = new Scanner(probationList);
        while (scanner.hasNextLine()){
            System.out.println();
            System.out.println("Name: " + scanner.nextLine());
            System.out.println("Age:  " + scanner.nextLine());
            System.out.println("GPA:  " + scanner.nextLine());
        }
    }

    public void createHonorRoll() throws IOException {
        File honorRoll = new File("honorroll.txt");
        PrintWriter printWriter = new PrintWriter(honorRoll);
        for(int i = 0; i <numStudents; i++){
            Student currentStudent = students[i];
            if(currentStudent.getGPA() >= 3.5){
                printWriter.println(currentStudent.getName());
                printWriter.println(currentStudent.getAge());
                printWriter.println(currentStudent.getGPA());
            }
        }
        printWriter.close();
    }

    public void displayHonorRoll() throws IOException {
        System.out.println("\n\nHonor Roll");
        System.out.println("==========");
        File honorRoll  = new File("honorroll.txt");
        Scanner scanner = new Scanner(honorRoll);
        while (scanner.hasNextLine()){
            System.out.println();
            System.out.println("Name: " + scanner.nextLine());
            System.out.println("Age:  " + scanner.nextLine());
            System.out.println("GPA:  " + scanner.nextLine());
        }
    }
}


class Student {
    private String name;
    private int age;
    private double gpa;

    public Student(String n, int a, double g) {
        name = new String(n);
        age = a;
        gpa = g;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getGPA() {
        return gpa;
    }

    public void displayStudent() {
        System.out.println("\nName: " + name);
        System.out.println("Age:  " + age);
        System.out.println("GPA:  " + gpa);
    }
}
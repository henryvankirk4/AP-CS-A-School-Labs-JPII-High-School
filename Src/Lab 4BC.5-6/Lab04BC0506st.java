// Lab04BC0506st.java
// The Student Records Program I
// This is the student, starting version of the Lab04A0306 assignment.

import java.io.*;
import java.util.Scanner;

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

    }

    public void displayAll() {
        System.out.println("\n\nList of All Students");
        System.out.println("====================");

    }

    public void displayAverages() {
        System.out.println("\n\nAverages");
        System.out.println("========");

    }

    // Precondition: The is exactly one youngest student.
    public void displayYoungest() {
        System.out.println("\n\nYoungest Student");
        System.out.println("================");

    }

    // Precondition: The is exactly one oldest student.
    public void displayOldest() {
        System.out.println("\n\nOldest Student");
        System.out.println("==============");

    }

    // Precondition: The is exactly one Valedictorian.
    public void displayValedictorian() {
        System.out.println("\n\nValedictorian");
        System.out.println("=============");

    }

    public void createProbationList() throws IOException {

    }

    public void displayProbationList() throws IOException {
        System.out.println("\n\nProbation List");
        System.out.println("==============");

    }

    public void createHonorRoll() throws IOException {

    }

    public void displayHonorRoll() throws IOException {
        System.out.println("\n\nHonor Roll");
        System.out.println("==========");

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
   


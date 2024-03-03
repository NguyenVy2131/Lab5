/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.university;

import java.io.Serializable;
import java.util.Scanner;

/**
 *
 * @author LENOVO
 */
public abstract class Student  implements Serializable {
    private String studentNumber;
    private String studentName;
    int credit;
    double averageScore;

    public Student() {
    }

    public Student(String studentNumber, String studentName, int credit, double averageScore) {
        this.studentNumber = studentNumber;
        this.studentName = studentName;
        this.credit = credit;
        this.averageScore = averageScore;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(double averageScore) {
        this.averageScore = averageScore;
    }

    public void InputStudent() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Student number: ");
        studentNumber = sc.next();
        sc.nextLine();
        System.out.print("Student's full name: ");
        studentName = sc.nextLine();
        
        System.out.print("Total number of credits earned: ");
        credit = sc.nextInt();
        sc.nextLine();
        System.out.print("Average score: ");
        averageScore = sc.nextDouble();
    }

    public void OutputStudent() {
        System.out.println(studentNumber + " - " + studentName + " - " + credit + " - " + averageScore);
    }
    public abstract boolean Graduation();
    public abstract int Type();
}

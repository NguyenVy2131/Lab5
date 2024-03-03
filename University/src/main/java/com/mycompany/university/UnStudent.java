/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.university;

import java.util.Scanner;

/**
 *
 * @author LENOVO
 */
public class UnStudent extends Student {
    private String thesisName;
    private double thesisScore;

    public UnStudent() {

    }

    public UnStudent(String thesisName, double thesisScore, String studentNumber, String studentName, int credit, double averageScore) {
        super(studentNumber, studentName, credit, averageScore);
        this.thesisName = thesisName;
        this.thesisScore = thesisScore;
    }

    public String getThesisName() {
        return thesisName;
    }

    public void setThesisName(String thesisName) {
        this.thesisName = thesisName;
    }

    public double getThesisScore() {
        return thesisScore;
    }

    public void setThesisScore(double thesisScore) {
        this.thesisScore = thesisScore;
    }

    @Override
    public void InputStudent() {
        Scanner sc = new Scanner(System.in);
        super.InputStudent();
        System.out.print("The name of thesis: ");
        thesisName = sc.nextLine();
        System.out.print("The thesis score: ");
        thesisScore = sc.nextDouble();
    }

    @Override
    public void OutputStudent() {
        super.OutputStudent();
        System.out.println("The name of thesis: " + thesisName + " - " + "The thesis score: " + thesisScore);
    }
    @Override
    public boolean Graduation(){
        if(credit>=150 && averageScore>=5.0&&thesisScore>=5.0){
            return true;
        }
        return false;
    }
    @Override
    public int Type(){
        return 1;
    }
}

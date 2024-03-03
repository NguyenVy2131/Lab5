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
public class CoStudent extends Student {
    private double graduationScore;

    public CoStudent() {

    }

    public CoStudent(double graduationScore, String studentNumber, String studentName, int credit, double averageScore) {
        super(studentNumber, studentName, credit, averageScore);
        this.graduationScore = graduationScore;
    }

    public double getGraduationScore() {
        return graduationScore;
    }

    public void setGraduationScore(double graduationScore) {
        this.graduationScore = graduationScore;
    }

    @Override
    public void InputStudent() {
        Scanner sc = new Scanner(System.in);
        super.InputStudent();
        System.out.print("Graduation exam scores: ");
        graduationScore = sc.nextDouble();
    }

    @Override
    public void OutputStudent() {
        super.OutputStudent();
        System.out.println("Graduation exam scores: " + graduationScore);
    }
    @Override
    public boolean Graduation(){
        if(credit>=100 && averageScore>=5.0 && graduationScore>=5.0){
            return true;
        }
        return false;
    }
    @Override
    public int Type(){
        return 0;
    }
}

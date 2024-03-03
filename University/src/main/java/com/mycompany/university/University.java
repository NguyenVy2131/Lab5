/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.university;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.*;
import java.io.*;

/**
 *
 * @author LENOVO
 */
public class University {

    public static ArrayList<Student> vec = new ArrayList();
    static Scanner sc = new Scanner(System.in);

    public University() {
       
    }

    public static void main(String[] args) {
//        Student a = new CoStudent(7.0, "004", "Nguyen Van A", 96, 8.0);
//        vec.add(a);
//        Student b = new CoStudent(5.0, "006", "Tran Thi C", 150, 6.0);
//        vec.add(b);
//        Student c = new CoStudent(4.5, "003", "Nguyen Van B", 109, 5.0);
//        vec.add(c);
//        Student d = new UnStudent("Economy", 9.0, "001", "Ly Thi D", 151, 8.2);
//        vec.add(d);
//        Student e = new UnStudent("The environment", 7.5, "002", "Tran Van A", 100, 6.0);
//        vec.add(e);
//        Student f = new UnStudent("The study", 8.8, "005", "Vo Thanh Huy", 180, 8.0);
//        vec.add(f);
        loadStudent();
        Student stu;
        int menu;
        do {
            System.out.printf("\n1: Add a new college student\n"
                    + "2: Add a new university student\n"
                    + "3: Remove a student from the list with the student code entered\n"
                    + "4: Print student list\n"
                    + "5: Print the list of students eligible for graduation and indicate the number of eligible students\n"
                    + "6: Sort the student list ascending\n"
                    + "7: Find student list by student's full name\n"
                    + "8: Exit\nInput ");
            menu = sc.nextInt();
            switch (menu) {
                case 1:
                    stu = new CoStudent();
                    stu.InputStudent();
                    vec.add(stu);
                    saveStudent();
                    break;
                case 2:
                    stu = new UnStudent();
                    stu.InputStudent();
                    vec.add(stu);
                    saveStudent();
                    break;
                case 3:
                    sc.nextLine();
                    System.out.print("The student code you want to remove: ");
                    String code = sc.next();
                    boolean flag = false;
                    for (int i = 0; i < vec.size(); i++) {
                        if (vec.get(i).getStudentNumber().equals(code)) {
                            vec.remove(vec.get(i));
                            flag = true;
                        }
                    }
                    if (!flag) {
                        System.out.print("The university does not have this student number. ");
                    } else {
                        System.out.print("Removed successfully.");
                    }
                    saveStudent();
                    break;
                case 4:
                    output(vec);
                    break;
                case 5:
                    int count = 0;
                    for (Student i : vec) {
                        if (i.Graduation()) {
                            i.OutputStudent();
                            count++;
                        }
                    }
                    System.out.println(" the number of eligible students: " + count);
                    break;
                case 6:
                    Collections.sort(vec, Comparator.comparing(Student::Type).thenComparing(Student::getStudentNumber));
                    for (Student i : vec) {
                        i.OutputStudent();
                    }
                    saveStudent();
                    break;
                case 7:
                    System.out.print("The student's name you want to find: ");
                    sc.nextLine();
                    String namefind = sc.nextLine();
                    for (Student i : vec) {
                        if (i.getStudentName().toUpperCase().contains(namefind.toUpperCase())) {
                            i.OutputStudent();
                        }
                    }
                    break;
                case 8:

            }
        } while (menu != 8);
    }

    public static void output(List<Student> vec) {
        for (int i = 0; i < vec.size(); i++) {
            vec.get(i).OutputStudent();
        }
    }

    public static void saveStudent() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Student.DAT"))) {
            oos.writeObject(vec);
            oos.close();
        } catch (IOException e) {
            System.out.println("Error save file" + e.getMessage());
        }

    }

    public static void loadStudent() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Student.DAT"))) {
            vec = (ArrayList<Student>) ois.readObject();
            ois.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found");
        } catch (IOException e) {
            System.out.println("Error load file");
        }

    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.resortcalculation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.border.Border;

/**
 *
 * @author LENOVO
 */
public class ResortForm extends JFrame {

    private JTextField nameField;
    private JCheckBox breakfast, goft, pool;
    private JComboBox percent;
    private JLabel title, note1, note2, tf;
    private JButton Calculate;

    public ResortForm() {
        setTitle("This is my First Frame");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        JPanel mainPanel = new JPanel(new BorderLayout());

        JPanel input = new JPanel(new GridLayout(7, 1));

        JPanel inputPanel = new JPanel(new GridLayout(2, 1));

        JPanel name = new JPanel(new GridLayout(1, 2, 5, 5));
        JPanel checkbox = new JPanel(new GridLayout(1, 3, 5, 5));
        JPanel last = new JPanel(new GridLayout(1, 2, 5, 5));

        Calculate = new JButton("Calculate");
        tf = new JLabel("");
        Font font3 = new Font("Arial", Font.BOLD, 20);
        tf.setFont(font3);
        Calculate.addActionListener((e) -> {
            Calculate();
        });
        String obj[] = {"Weekend (+30%)", "Week day (-10%)"};
        percent = new JComboBox(obj);
        JLabel title = new JLabel("Resort Price Calculator", (int) CENTER_ALIGNMENT);
        Font font = new Font("Arial", Font.BOLD, 27);
        title.setFont(font);
        JLabel note1 = new JLabel("Base price for a room is $200", (int) CENTER_ALIGNMENT);
        Font font1 = new Font("Arial", Font.BOLD, 18);
        note1.setFont(font1);
        JLabel note2 = new JLabel("Choose option that you want", (int) CENTER_ALIGNMENT);
        note2.setFont(font1);
        nameField = new JTextField();
        breakfast = new JCheckBox("Breakfast $20");
        goft = new JCheckBox("Goft $50");
        pool = new JCheckBox("Pool $15");

        name.add(new JLabel("Guest name:"));
        name.add(nameField);

        checkbox.add(breakfast);
        checkbox.add(goft);
        checkbox.add(pool);

        last.add(percent);
        last.add(Calculate);

        input.add(note1);
        input.add(note2);
        input.add(name);
        input.add(checkbox);
        input.add(last);
        input.add(tf);

        inputPanel.add(title);
        inputPanel.add(input);

        mainPanel.add(inputPanel, BorderLayout.NORTH);

        add(mainPanel);
        setVisible(true);

    }
    public void Calculate() {
                String name = nameField.getText();
                if (nameField.getText().isEmpty()) {
                    setColorBorder(nameField, Color.RED);
                    JOptionPane.showMessageDialog(this, "Please enter your name");
                    nameField.requestFocus();
                }
                double total = 200;
                if (breakfast.isSelected()) {
                    total += 20;
                }
                if (goft.isSelected()) {
                    total += 50;
                }
                if (pool.isSelected()) {
                    total += 15;
                }
                if (percent.getItemAt(percent.getSelectedIndex()).equals("Weekend (+30%)")) {
                    total = total * 130 / 100;
                }
                if (percent.getItemAt(percent.getSelectedIndex()).equals("Week day (-10%)")) {
                    total = total * 90 / 100;
                }

                tf.setText("Hello " + name + " Your payment is: " + "$" + total);
            }
    public void setColorBorder(JTextField textField, Color color) {
        Border newBorder = BorderFactory.createLineBorder(color);
        textField.setBorder(newBorder);
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cdmanagement;

/**
 *
 * @author LENOVO
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;
import java.util.ArrayList;
import javax.swing.border.Border;

public class CdDetailForm extends JFrame {

    JTextField idText, titleText, priceText, yearText;
    JComboBox<String> collectionType;
    ButtonGroup group;
    JRadioButton video, audio;
    JButton add, clear, showAll;
    ArrayList<CDdetail> list = new ArrayList<>();

    public CdDetailForm() {
        setSize(500, 500);
        setTitle("CD Store");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());
        GridBagConstraints gbc;
        //
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.insets = new Insets(10, 0, 10, 0);
        getContentPane().add(new JLabel("CD ID"), gbc);

        idText = new JTextField();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 03, 10, 10);
        getContentPane().add(idText, gbc);
        //
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.insets = new Insets(10, 0, 10, 0);
        getContentPane().add(new JLabel("CD Title"), gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 03, 10, 7);
        titleText = new JTextField();
        getContentPane().add(titleText, gbc);
        //
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.insets = new Insets(10, 0, 10, 0);
        getContentPane().add(new JLabel("CD Collection "), gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        collectionType = new JComboBox<>();
        collectionType.addItem("game");
        collectionType.addItem("movie");
        collectionType.addItem("music");
        getContentPane().add(collectionType, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.insets = new Insets(10, 5, 10, 5);
        getContentPane().add(new JLabel("CD Type "), gbc);

        group = new ButtonGroup();
        video = new JRadioButton("VCD");
        audio = new JRadioButton("CD");
        group.add(video);
        group.add(audio);
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 2;
        getContentPane().add(video, gbc);
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 2;
        getContentPane().add(audio, gbc);
        //
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.insets = new Insets(10, 0, 10, 0);
        getContentPane().add(new JLabel("CD Price "), gbc);

        priceText = new JTextField();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 4;
        gbc.insets = new Insets(10, 03, 10, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        getContentPane().add(priceText, gbc);
        //
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 5;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.insets = new Insets(10, 0, 10, 0);
        getContentPane().add(new JLabel("CD Year of Release"), gbc);
        // 
        yearText = new JTextField();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 4;
        gbc.insets = new Insets(10, 05, 10, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        getContentPane().add(yearText, gbc);

        add = new JButton("Add");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 5;
        gbc.insets = new Insets(10, 0, 10, 5);
        getContentPane().add(add, gbc);
        //

        clear = new JButton("Clear");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.insets = new Insets(10, 0, 10, 3);
        getContentPane().add(clear, gbc);

        showAll = new JButton("Show All");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 3, 10, 0);
        getContentPane().add(showAll, gbc);
        pack();
        add.addActionListener((ActionEvent e) -> {
            addCD(list);
        });
        clear.addActionListener((ActionEvent e) -> {
            resetField();
        });
        showAll.addActionListener((ActionEvent e) -> {
            displayAll(list);
        });
    }

    public void addCD(ArrayList<CDdetail> list) {

        if (idText.getText().isEmpty()) {
            setColorBorder(idText, Color.RED);
            JOptionPane.showMessageDialog(this, "Please enter the CD id");
            idText.requestFocus();
        } else if (titleText.getText().isEmpty()) {
            setColorBorder(titleText, Color.RED);
            JOptionPane.showMessageDialog(this, "Please enter the CD Title");
            titleText.requestFocus();
        } else if (priceText.getText().isEmpty()) {
            setColorBorder(priceText, Color.RED);
            JOptionPane.showMessageDialog(this, "Please enter the CD Price");
            priceText.requestFocus();
        } else if (yearText.getText().isEmpty()) {
            setColorBorder(yearText, Color.RED);
            JOptionPane.showMessageDialog(this, "Please enter the CD year of release");
            yearText.requestFocus();
        } else if (!isNumber(priceText.getText())) {
            setColorBorder(priceText, Color.RED);
            JOptionPane.showMessageDialog(this, "Invalid Number: " + priceText.getText());
            priceText.requestFocus();
        } else if (!isNumber(yearText.getText())) {
            setColorBorder(yearText, Color.RED);
            JOptionPane.showMessageDialog(this, "Invalid Number: " + yearText.getText());
            yearText.requestFocus();
        } else {
            String id = idText.getText();
            String title = titleText.getText();
            String collection = collectionType.getSelectedItem().toString();
            double price = Integer.parseInt(priceText.getText());
            int year = Integer.parseInt(yearText.getText());
            String type;
            if (video.isSelected()) {
                type = "video";
            } else if (audio.isSelected()) {
                type = "audio";
            } else {
                type = "null";
            }
            CDdetail cd = new CDdetail(id, title, collection, type, price, year);
            list.add(cd);
            JOptionPane.showMessageDialog(this, "Successful!");
            resetField();
        }
    }

    public void setColorBorder(JTextField textField, Color color) {
        Border newBorder = BorderFactory.createLineBorder(color);
        textField.setBorder(newBorder);
    }

    public boolean isNumber(String a) {
        try {
            Integer.parseInt(a);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public void resetField() {
        idText.setText("");
        setColorBorder(idText, Color.BLACK);
        titleText.setText("");
        setColorBorder(titleText, Color.BLACK);
        collectionType.setSelectedIndex(-1);
        priceText.setText("");
        setColorBorder(priceText, Color.BLACK);
        yearText.setText("");
        setColorBorder(yearText, Color.BLACK);
        group.clearSelection();
    }

    public void displayAll(ArrayList<CDdetail> list) {
        JFrame CDlist = new JFrame();
        CDlist.setSize(300, 200);
        CDlist.setTitle("All CDs");
        CDlist.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CDlist.setLocationRelativeTo(null);
        StringBuilder sb = new StringBuilder();
        for (CDdetail cd : list) {
            sb.append(cd.getId() + " ").append("_" + cd.getTitle() + " ").append("_" + cd.getCollection() + " ").append("_" + cd.getType() + " ")
                    .append("_" + cd.getPrice() + "$ ").append("_" + cd.getYear() + "\n");
        }
        JTextArea area = new JTextArea(sb.toString());
        CDlist.add(area);
        CDlist.pack();
        CDlist.setVisible(true);
    }

}


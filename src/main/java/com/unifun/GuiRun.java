package com.unifun;

import lombok.extern.java.Log;

import javax.swing.*;
import java.awt.*;

@Log
public class GuiRun {
    public static void main(String[] args) {


        JFrame mainFrame = new JFrame();
        mainFrame.setTitle("Vectors");

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        JPanel headingPanel = new JPanel();
        JLabel headingLabel = new JLabel("Label");
        headingPanel.add(headingLabel);

        JPanel panel = new JPanel(new GridBagLayout());

        GridBagConstraints constr = new GridBagConstraints();
        constr.insets = new Insets(15, 15, 15, 15);
        constr.anchor = GridBagConstraints.WEST;

        // Set the initial grid values to 0,0
        constr.gridx=0;
        constr.gridy=0;

        // Declare the required Labels
        JLabel startPointA = new JLabel("Start point A :");
        JLabel endPointA = new JLabel("End point A :");
        JLabel startPointB = new JLabel("Start point B :");
        JLabel endPointB = new JLabel("End point B :");

        // Declare Text fields
        JTextField txtStartPointA = new JTextField("0,0",5);
        JTextField txtEndPointA = new JTextField("1,1",5);
        JTextField txtStartPointB = new JTextField("2,2",5);
        JTextField txtEndPointB = new JTextField("3,3",5);
        panel.add(startPointA, constr);
        constr.gridx=1;
        panel.add(txtStartPointA, constr);
        constr.gridx=0; constr.gridy=1;

        panel.add(endPointA, constr);
        constr.gridx=1;
        panel.add(txtEndPointA, constr);
        constr.gridx=0; constr.gridy=2;

        panel.add(startPointB, constr);
        constr.gridx=1;
        panel.add(txtStartPointB, constr);
        constr.gridx = 0;constr.gridy=3;

        panel.add(endPointB,constr);
        constr.gridx=1;
        panel.add(txtEndPointB,constr);
        constr.gridy++;


        constr.gridwidth = 2;
        constr.anchor = GridBagConstraints.CENTER;

        // Button with text "Register"
        JButton sumButton = new JButton("Sum");

        JButton diffButton = new JButton("Diff");
        JButton lengthVector = new JButton("Length");

        // Add label and button to panel
        panel.add(sumButton, constr);
        constr.gridx=3;constr.gridy=4;
        panel.add(diffButton, constr);
//        constr.gridx=0 ; constr.gridy=4;
//        panel.add(lengthVector,constr);

        mainPanel.add(headingPanel);
        mainPanel.add(panel);

        // Add panel to frame
        mainFrame.add(mainPanel);
        mainFrame.pack();
        mainFrame.setSize(400, 400);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);

        JFrame frameSum = new JFrame("Sum Frame");
        frameSum.pack();
        frameSum.setSize(250, 100);
        frameSum.setLocationRelativeTo(null);
        frameSum.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        sumButton.addActionListener(action ->
        {


            String[] strings = txtStartPointA.getText().split(",");
            String[] string2 = txtEndPointA.getText().split(",");
            try {
                Integer.parseInt(strings[0]);
                Integer.parseInt(strings[1]);
                Integer.parseInt(string2[0]);
                Integer.parseInt(string2[1]);

                Point startPoint = new Point(Integer.parseInt(strings[0]), Integer.parseInt(strings[1]));
                Point endPoint = new Point(Integer.parseInt(string2[0]), Integer.parseInt(string2[1]));
                Vector vector = new Vector(startPoint, endPoint);

                strings = txtStartPointB.getText().split(",");
                string2 = txtEndPointB.getText().split(",");

                Integer.parseInt(strings[0]);
                Integer.parseInt(strings[1]);
                Integer.parseInt(string2[0]);
                Integer.parseInt(string2[1]);

                endPoint = new Point(Integer.parseInt(string2[0]), Integer.parseInt(string2[1]));
                startPoint = new Point(Integer.parseInt(strings[0]), Integer.parseInt(strings[1]));
                Vector vector1 = new Vector(startPoint, endPoint);
                Vector sum = new Vector();
                try {
                    sum = Vector.sumVector(vector, vector1);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                JLabel jLabel = new JLabel(sum.getStartPoint().toString() + sum.getEndPoint().toString());
                frameSum.getContentPane().removeAll();
                frameSum.add(jLabel);
                frameSum.setVisible(true);

            }
            catch (NumberFormatException exc){
                JOptionPane.showMessageDialog(mainFrame,"Introdu numar!");
            }


        });

        diffButton.addActionListener(action->
        {
                    String[] strings = txtStartPointA.getText().split(",");
                    String[] string2 = txtEndPointA.getText().split(",");
                    try {
                        Integer.parseInt(strings[0]);
                        Integer.parseInt(strings[1]);
                        Integer.parseInt(string2[0]);
                        Integer.parseInt(string2[1]);

                        Point startPoint = new Point(Integer.parseInt(strings[0]), Integer.parseInt(strings[1]));
                        Point endPoint = new Point(Integer.parseInt(string2[0]), Integer.parseInt(string2[1]));
                        Vector vector = new Vector(startPoint, endPoint);

                        strings = txtStartPointB.getText().split(",");
                        string2 = txtEndPointB.getText().split(",");

                        Integer.parseInt(string2[0]);
                        Integer.parseInt(strings[0]);
                        Integer.parseInt(string2[1]);
                        Integer.parseInt(strings[1]);

                        endPoint = new Point(Integer.parseInt(string2[0]), Integer.parseInt(string2[1]));
                        startPoint = new Point(Integer.parseInt(strings[0]), Integer.parseInt(strings[1]));
                        Vector vector1 = new Vector(startPoint, endPoint);
                        Vector diff = new Vector();
                        try {
                            diff = Vector.diffVector(vector, vector1);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        String tempVar1 = diff.getEndPoint().toString();
                        String tempVar = diff.getStartPoint().toString();



                        JLabel jLabel = new JLabel(tempVar + tempVar1);
                        frameSum.getContentPane().removeAll();
                        frameSum.add(jLabel);
                        frameSum.setVisible(true);

                    }catch (NumberFormatException exc){
                        JOptionPane.showMessageDialog(mainFrame,"Introdu numar!!!");
                    }
                });


    }
}


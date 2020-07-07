package com.unifun;

import javax.swing.*;
import java.awt.*;

public class Gui {

    public Gui() {

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
        constr.gridx = 0;
        constr.gridy = 0;

        // Declare the required Labels
        JLabel startPointA = new JLabel("Start point A :");
        JLabel endPointA = new JLabel("End point A :");
        JLabel startPointB = new JLabel("Start point B :");
        JLabel endPointB = new JLabel("End point B :");

        // Declare Text fields
        JTextField txtStartPointA = new JTextField("0,0", 5);
        JTextField txtEndPointA = new JTextField("1,1", 5);
        JTextField txtStartPointB = new JTextField("2,2", 5);
        JTextField txtEndPointB = new JTextField("3,3", 5);

        panel.add(startPointA, constr);
        constr.gridx = 1;
        panel.add(txtStartPointA, constr);
        constr.gridx = 0;
        constr.gridy = 1;

        panel.add(endPointA, constr);
        constr.gridx = 1;
        panel.add(txtEndPointA, constr);
        constr.gridx = 0;
        constr.gridy = 2;

        panel.add(startPointB, constr);
        constr.gridx = 1;
        panel.add(txtStartPointB, constr);
        constr.gridx = 0;
        constr.gridy = 3;

        panel.add(endPointB, constr);
        constr.gridx = 1;
        panel.add(txtEndPointB, constr);
        constr.gridy++;

        constr.gridwidth = 2;
        constr.anchor = GridBagConstraints.CENTER;

        JButton sumButton = new JButton("Sum");
        JButton diffButton = new JButton("Diff");

        panel.add(sumButton, constr);
        constr.gridx = 3;constr.gridy = 4;
        panel.add(diffButton, constr);

        mainPanel.add(headingPanel);
        mainPanel.add(panel);

        // Add panel to frame
        mainFrame.add(mainPanel);
        mainFrame.pack();
        mainFrame.setSize(400, 400);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);

        JFrame frameResult = new JFrame("Sum Frame");
        frameResult.pack();
        frameResult.setSize(250, 100);
        frameResult.setLocationRelativeTo(null);
        frameResult.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        sumButton.addActionListener(action ->
        {
            String points = txtStartPointA.getText()+","+txtEndPointA.getText()+","+txtStartPointB.getText()+","+txtEndPointB.getText();
            String[] strings = points.split(",");

            TryNumbers.tryNumbers(strings,mainFrame);

            Vector sum = new Vector();

            try {
                sum = Vector.sumVector(VectorCreator.returnVector(strings), VectorCreator.returnSecondVector(strings));
            } catch (Exception e) {
                e.printStackTrace();
            }
            GetLabel.newLabel(sum,frameResult);
        });

        diffButton.addActionListener(action ->
        {
            String points = txtStartPointA.getText()+","+txtEndPointA.getText()+","+txtStartPointB.getText()+","+txtEndPointB.getText();
            String[] strings = points.split(",");

            TryNumbers.tryNumbers(strings,mainFrame);

            Vector diff = new Vector();
            try {
                    diff = Vector.diffVector(VectorCreator.returnVector(strings),VectorCreator.returnSecondVector(strings));
                } catch (Exception e) {
                    e.printStackTrace();
                }

                GetLabel.newLabel(diff,frameResult);

        });
    }
}

package com.unifun;

import javax.swing.*;


public class GetLabel {
    public static void newLabel(Vector vector, JFrame frame){
        String tempVar1 = vector.getEndPoint().toString();
        String tempVar = vector.getStartPoint().toString();


        JLabel jLabel = new JLabel(tempVar + tempVar1);
        frame.getContentPane().removeAll();
        frame.add(jLabel);
        frame.setVisible(true);
    }
}

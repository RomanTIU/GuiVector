package com.unifun;

import javax.swing.*;

public class TryNumbers {

    public static void tryNumbers(String[] s,JFrame frame){
        try {
            for (int i = 0; i <s.length ; i++) {
                    Integer.parseInt(s[i]);
            }
        } catch
            (NumberFormatException exc) {
            JOptionPane.showMessageDialog(frame, "Introdu numar!");

        }
    }
}

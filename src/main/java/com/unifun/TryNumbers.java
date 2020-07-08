package com.unifun;

import javax.swing.*;

public class TryNumbers {

    public static void tryNumbers(String[] s,JFrame frame){
        try {
            for (String value : s) {
                Integer.parseInt(value);
            }
        } catch
            (NumberFormatException exc) {
            JOptionPane.showMessageDialog(frame, "Introdu numar!");

        }
    }
}

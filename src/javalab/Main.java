package javalab;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            try{
                new Interface();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}

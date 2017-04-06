package ua.main;

import ua.display.Display;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by alex on 06.04.2017.
 */
public class Main {
    public static void main(String[] args) {

        Display.createWindow("Tanks", 800,600, 0xff00ffff, 3);

        Timer timer = new Timer(1000 / 60, new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                Display.clear();

                Display.swapBuffers();
            }
        });

        timer.setRepeats(true);
        timer.start();
    }
}

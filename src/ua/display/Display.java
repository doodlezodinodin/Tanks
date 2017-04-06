package ua.display;

import javax.swing.*;
import java.awt.*;

/**
 * Created by alex on 06.04.2017.
 */
public abstract class Display {

    public static boolean created = false;
    public static JFrame frame;  //windows
    public static Canvas canvas;  //content

    public static void createWindow(String title, int width, int height){

        //Если окно уже создано - то выход
        if(created){
            return;
        }

        frame = new JFrame(title);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);  //Выход из программы
        canvas = new Canvas();

        Dimension size = new Dimension(width, height);
        canvas.setPreferredSize(size);

        frame.setResizable(false);  // нельзя менять размер окна
        frame.getContentPane().add(canvas);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);



    }
}

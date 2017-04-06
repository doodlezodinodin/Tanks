package ua.display;

import com.sun.corba.se.impl.orbutil.graph.Graph;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.Arrays;

public abstract class Display {

    private static boolean created = false;
    private static JFrame frame;  //windows
    private static Canvas canvas;  //content

    private static BufferedImage bufferImage;
    private static int[] bufferData;
    private static Graphics bufferGraphics;
    private static int bufferClearColor;

    private static BufferStrategy bufferStrategy;


    public static void createWindow(String title, int width, int height, int _bufferClearColor, int numBuffers) {

        //Если окно уже создано - то выход
        if(created) {
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

        bufferClearColor = _bufferClearColor;

        canvas.createBufferStrategy(numBuffers);
        bufferStrategy = canvas.getBufferStrategy();

        bufferImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        bufferData = ((DataBufferInt) bufferImage.getRaster().getDataBuffer()).getData();
        bufferGraphics = bufferImage.getGraphics();
        ((Graphics2D)bufferGraphics).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON) ;

        created = true;
    }

    public static void clear() {
        Arrays.fill(bufferData, bufferClearColor);
    }

    public static void swapBuffers() {
        Graphics graphics = bufferStrategy.getDrawGraphics();
        graphics.drawImage(bufferImage, 0, 0, null);
        bufferStrategy.show();
    }

    public static Graphics2D getGraphics() {
        return (Graphics2D) bufferGraphics;
    }

    public static void destroy() {
        if(!created){
            return;
        }

        frame.dispose();
    }
}

package ua.game;

import ua.display.Display;
import ua.utils.Time;

/**
 * Created by alex on 06.04.2017.
 */
public class Game implements Runnable {

    public static final int    WIDTH              = 800;
    public static final int    HEIGHT             = 600;
    public static final String TITLE              = "Tanks";
    public static final int    BUFFER_CLEAR_COLOR = 0xff000000;
    public static final int    NUB_BUFFERS        = 3;

    public static final float  UPDATE_RATE        = 60.0f;
    public static final float  UPDATE_INTERVAL    = Time.SECOND / UPDATE_RATE;
    public static final long   IDLE_TIME          = 1;

    private boolean running;
    public Thread gameTread;


    public Game() {
        running = false;
        Display.createWindow(TITLE, WIDTH, HEIGHT, BUFFER_CLEAR_COLOR, NUB_BUFFERS);
    }

    public synchronized void start() {

        if(running)
            return;

        running = true;
        gameTread = new Thread(this);
        gameTread.start();
    }

    public synchronized void stop() {

        if(!running)
            return;

        running = false;

        try {
            gameTread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        cleanUp();
    }

    private void update() {

    }

    private void render() {

    }

    public void run() {

    }

    private void cleanUp() {
        Display.destroy();
    }

}

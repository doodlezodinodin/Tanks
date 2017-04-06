package ua.utils;

/**
 * Created by alex on 06.04.2017.
 */
public class Time {
    public static final long SECOND = 1000000000l;

    public static long get(){
        return System.nanoTime();
    }
}

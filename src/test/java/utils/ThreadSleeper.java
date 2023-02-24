package utils;

public class ThreadSleeper {
    public static void ThreadSleep(int seconds){
        try{
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static void sleepSeconds (final int seconds){
        ThreadSleep(seconds);
    }
}

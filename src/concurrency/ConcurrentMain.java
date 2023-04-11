package concurrency;

import static concurrency.ColorScheme.GREEN;
import static concurrency.ColorScheme.YELLOW;

public class ConcurrentMain {

    public static void main(String[] args) {
        SimpleThread th1 = new SimpleThread();
        th1.start();
        SimpleThread th2 = new SimpleThread();
        th2.start();
        th2.interrupt();
        Thread th3 = new Thread(new SimpleThread());
        th3.start();
        new Thread(() -> {
            System.out.println("Hello from lambda Runnable");
        }).start();
        System.out.println("Hello from main");

    }
}

class SimpleThread extends Thread{


    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(YELLOW + "WARN - " + currentThread() + " was interrupted");
            }
            System.out.println(GREEN + " INFO - " + currentThread() + " - " + i);
        }
        if(Thread.interrupted()){
            return;
        }
    }
}

class SimpleRunner implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(YELLOW + "WARN - " + Thread.currentThread() + " was interrupted");
            }
            System.out.println(GREEN + " INFO - Runnable - " + Thread.currentThread() + " - " + i);
        }
    }
}

package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

import static concurrency.ColorScheme.RED;

public class Launcher {
    private static final int POOL_SIZE = 2;

    public static <GCDRunnable> void main(String[] args) throws InterruptedException {
        boolean isDaemon = true;
        System.out.println(RED + "Starting main thread");
        concurrency.GCDRunnable r = new concurrency.GCDRunnable(isDaemon);
        runInOneThread(r, isDaemon);
        runWithExecutors(r, isDaemon);
        Thread.sleep(100);
        System.out.println("Leaving the main thread");
    }

    private static void runWithExecutors(GCDRunnable r, boolean isDaemon) throws InterruptedException {
        ThreadFactory factory = new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                if (isDaemon){
                    thread.setDaemon(true);
                }
                return thread;
            }
        };
        ExecutorService executorService = Executors.newFixedThreadPool(POOL_SIZE, factory);
        for (int i = 0; i < 5; i++) {
            executorService.execute(r);
        }
        executorService.shutdown();
        executorService.awaitTermination(30, TimeUnit.SECONDS);
    }

    private static void runInOneThread(GCDRunnable r, boolean isDaemon){
        Thread th = new Thread(r);
        if (isDaemon){
            th.setDaemon(true);
        }
        th.start();
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        th.interrupt();
    }
}

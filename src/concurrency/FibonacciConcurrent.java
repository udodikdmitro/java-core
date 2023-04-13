package concurrency;

public class FibonacciConcurrent {
    private static int previous = 0;
    private static int current = 1;

    public static void main(String[] args) {
        Thread th1 = new Thread(new FibonacciRunner());
        Thread th2 = new Thread(new FibonacciRunner());
        th1.start();
        th2.start();
    }

    private static synchronized void calcNext(){
        int next = previous + current;
        previous = current;
        current = next;
        System.out.println(current);
    }
    //or use synchronized catch synchronized{ .... code....}

    private static class FibonacciRunner implements Runnable{

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                calcNext();
            }
        }
    }
}

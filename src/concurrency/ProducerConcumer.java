package concurrency;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;

public class ProducerConcumer {
    private static BlockingDeque<String> queve = (BlockingDeque<String>) new ArrayBlockingQueue<String>(5);

    public static void main(String[] args) {
        new Thread(new Producer()).start();
        new Thread(new Consumer()).start();
    }

    private static class Producer implements Runnable{
        String[] messanges = {
                    "Jakarta Activation (JAF) specifies an architecture to extend component ",
                    "Beans by providing data typing and bindings of such types.",
                    "Jakarta Contexts and Dependency Injection (CDI) is",
                    " a specification to provide a dependency injection container;",
                    "Jakarta Enterprise Beans (EJB) specification defines a set of lightweight APIs",
                    " that an object container (the EJB container) will support in order",
                    " to provide transactions (using JTA), remote procedure calls (using RMI or RMI-IIOP),",
                    " concurrency control, dependency injection and access control for business objects. ",
                    "This package contains the Jakarta Enterprise Beans classes and interfaces",
                    " that define the contracts between the enterprise bean and its clients",
                    " and between the enterprise bean and the ejb container.",
                    "Jakarta Persistence (JPA) are specifications",
                    " about object-relational mapping between relation database tables and Java classes.",
                    "Jakarta Transactions (JTA) contains the interfaces",
                    " and annotations to interact with the transaction support offered by Jakarta EE. ",
                    "Even though this API abstracts from the really low-level details,",
                    " the interfaces are also considered somewhat low-level",
                    " and the average application developer in Jakarta EE",
                    " is either assumed to be relying on transparent handling of transactions",
                    " by the higher level EJB abstractions, or using the annotations provided",
                    " by this API in combination with CDI managed beans.",
                    "Jakarta Messaging (JMS) provides a common way for Java programs to create,",
                    " send, receive and read an enterprise messaging system's messages."
        };

        @Override
        public void run() {
            try {
                produce();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        private void produce() throws InterruptedException {
            Random r = new Random();

            for (int i = 0; i < messanges.length ; i++) {
                queve.put(messanges[i]);
                System.out.println("Producing " + messanges[i] + ". Queve's size is " + queve.size());
                Thread.sleep(r.nextInt(1000));
            }
        }
    }

    private static class Consumer implements Runnable{

        @Override
        public void run() {
            try {
                consume();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        private void consume() throws InterruptedException {
            Random r = new Random();

            while (true){
                String message = queve.take();
                System.out.println("Consuming " + message + ". Queve size is " + queve.size());

                if (!"DONE".equals(message)){
                    Thread.sleep(r.nextInt(1000));
                } else {
                    return;
                }
            }
        }
    }
}

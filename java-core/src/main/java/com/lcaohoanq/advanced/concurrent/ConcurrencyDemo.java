package com.lcaohoanq.advanced.concurrent;

import java.util.concurrent.*;
import lombok.Getter;

public class ConcurrencyDemo {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // Simple Thread Creation and Execution
        System.out.println("=== Simple Thread Creation ===");
        Thread thread = new Thread(new SimpleTask());
        thread.start();  // Start the thread
        thread.join();   // Wait for the thread to complete

        // Using ExecutorService for managing multiple threads
        System.out.println("\n=== ExecutorService Example ===");
        ExecutorService executor = Executors.newFixedThreadPool(3);  // Create a thread pool of 3 threads

        // Submitting tasks to the executor for asynchronous execution
        Future<Integer> result1 = executor.submit(new CallableTask(5));
        Future<Integer> result2 = executor.submit(new CallableTask(10));

        // Blocking call to get results of asynchronous tasks
        System.out.println("Result of task 1: " + result1.get());
        System.out.println("Result of task 2: " + result2.get());

        // Shutdown the executor
        executor.shutdown();
        if (executor.awaitTermination(1, TimeUnit.SECONDS)) {
            System.out.println("All tasks finished.");
        } else {
            System.out.println("Timeout! Some tasks are still running.");
        }

        // Demonstration of synchronization
        System.out.println("\n=== Synchronization Example ===");
        SharedResource resource = new SharedResource();

        // Creating multiple threads to access the shared resource concurrently
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                resource.increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                resource.increment();
            }
        });

        // Start both threads
        t1.start();
        t2.start();

        // Wait for both threads to finish
        t1.join();
        t2.join();

        // Output the final value of the shared resource after both threads are done
        System.out.println("Final value of shared resource: " + resource.getValue());

        // Demonstrating volatile keyword usage
        System.out.println("\n=== Volatile Example ===");
        VolatileExample volatileExample = new VolatileExample();
        Thread volatileThread = new Thread(volatileExample);
        volatileThread.start();

        // Let the thread run for a while
        Thread.sleep(1000);

        // Changing the stop flag to stop the volatile thread
        volatileExample.stopRunning();
        volatileThread.join();
        System.out.println("Volatile thread stopped.");
    }

    // Task that demonstrates basic thread usage
    static class SimpleTask implements Runnable {
        @Override
        public void run() {
            System.out.println("Simple Task is running in a separate thread.");
        }
    }

    // Callable task that returns a result
    static class CallableTask implements Callable<Integer> {
        private final int number;

        public CallableTask(int number) {
            this.number = number;
        }

        @Override
        public Integer call() throws Exception {
            System.out.println("Callable task with input " + number + " is running.");
            return number * 2;  // Return some processed value
        }
    }

    // Class that demonstrates synchronized access to a shared resource
    @Getter
    static class SharedResource {
        // Method to get the current value of the shared resource
        private int value = 0;

        // Synchronized method ensures that only one thread can increment at a time
        public synchronized void increment() {
            value++;
        }

    }

    // Class that demonstrates the usage of volatile keyword
    static class VolatileExample implements Runnable {
        // Volatile ensures visibility of changes across threads
        private volatile boolean running = true;

        @Override
        public void run() {
            while (running) {
                System.out.println("Volatile thread is running...");
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();  // Restore interrupted status
                }
            }
            System.out.println("Volatile thread is stopping...");
        }

        // Method to stop the thread by changing the volatile variable
        public void stopRunning() {
            running = false;
        }
    }
}


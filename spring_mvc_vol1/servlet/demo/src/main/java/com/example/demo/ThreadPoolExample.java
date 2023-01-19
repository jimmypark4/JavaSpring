package com.example.demo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExample {

    public static void main(String[] args) {
        // Create a work queue with a capacity of 100 tasks
        ArrayBlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(100);

        // Set the maximum pool size to 10 threads, the core pool size to 5 threads, and the keep-alive time to 60 seconds
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(5, 10, 60, TimeUnit.SECONDS, workQueue);

        // Submit tasks to the thread pool
        for (int i = 0; i < 20; i++) {
            threadPool.execute(new Task(i));
        }

        // Shut down the thread pool
        threadPool.shutdown();
    }

    private static class Task implements Runnable {
        private int taskId;

        public Task(int taskId) {
            this.taskId = taskId;
        }

        @Override
        public void run() {
            System.out.println("Running task " + taskId);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Completed task " + taskId);
        }
    }
}

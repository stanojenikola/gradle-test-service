package com.example.demo.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadsAndTasks {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 100; i++) {
            var taskId = i + 1;
            executorService.submit(new Task(taskId));
        }
    }
}

class Task implements Runnable {
    private int taskId;

    Task(int id) {
        taskId = id;
    }

    @Override
    public void run() {
        System.out.println("task " + taskId);
    }
}

package com.shn.mt;

import org.springframework.util.StopWatch;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

public class ExecutorExample {

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        int totalThread = 3;
        ExecutorExample exec = new ExecutorExample();
        Map<Integer, Double> timeMap = new HashMap<>();
        for (int i = 1; i <= totalThread; i++) {
            ExecutorService executorService = Executors.newFixedThreadPool(i);
            try {
                StopWatch watch = new StopWatch();
                watch.start();
//            executorService.execute(exec.createRunnableTask());
                exec.executeCallabletasks(executorService, exec);
                watch.stop();
                double totalTimeSeconds = watch.getTotalTimeSeconds();
//                System.out.println("Time Elapsed: " + totalTimeSeconds);
                timeMap.put(i, totalTimeSeconds);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                executorService.shutdown();
                try {
                    if (!executorService.awaitTermination(800, TimeUnit.MILLISECONDS)) {
                        executorService.shutdownNow();
                    }
                } catch (InterruptedException e) {
                    executorService.shutdownNow();
                }
            }
        }
        exec.printTimeDifference(timeMap);
    }

    private void printTimeDifference(Map<Integer, Double> timeMap) {
        timeMap.forEach((k, v) -> {
            System.out.println(k + " : " + v);
        });
    }

    private void executeCallabletasks(ExecutorService executorService, ExecutorExample exec) throws InterruptedException {
        List<Future<String>> futures = executorService.invokeAll(exec.createCallableTask(exec));
        for (Future<String> future : futures) {
            try {
                String result = future.get();
                System.out.println("Result : " + result);
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
    }

    private Runnable createRunnableTask() {
        Runnable runnableTask = () -> {
            try {
                printMsgAndReturnDateTime("Runnable Task");
                TimeUnit.MILLISECONDS.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        return runnableTask;
    }

    private List<Callable<String>> createCallableTask(ExecutorExample exec) {
        System.out.println("Executing callable tasks");
        Callable<String> callableTask1 = () -> {
//            TimeUnit.MILLISECONDS.sleep(300);
            return exec.printMsgAndReturnDateTime("Task 1");
        };

        Callable<String> callableTask2 = () -> {
//            TimeUnit.MILLISECONDS.sleep(300);
            return exec.printMsgAndReturnDateTime("Task 2");
        };

        Callable<String> callableTask3 = () -> {
//            TimeUnit.MILLISECONDS.sleep(300);
            return exec.printMsgAndReturnDateTime("Task 3");
        };

        Callable<String> callableTask4 = () -> {
//            TimeUnit.MILLISECONDS.sleep(300);
            return exec.printMsgAndReturnDateTime("Task 4");
        };

        Callable<String> callableTask5 = () -> {
//            TimeUnit.MILLISECONDS.sleep(300);
            return exec.printMsgAndReturnDateTime("Task 5");
        };

        Callable<String> callableTask6 = () -> {
//            TimeUnit.MILLISECONDS.sleep(300);
            return exec.printMsgAndReturnDateTime("Task 6");
        };

        List<Callable<String>> callableTasks = new ArrayList<>();
        callableTasks.add(callableTask1);
        callableTasks.add(callableTask2);
        callableTasks.add(callableTask3);
        callableTasks.add(callableTask4);
        callableTasks.add(callableTask5);
        callableTasks.add(callableTask6);
        return callableTasks;
    }

    private String printMsgAndReturnDateTime(String task) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        for (int i = 0; i < 100000; i++) {
            System.out.println("Hello " + task);
        }
        return task + " --- " + currentDateTime.format(formatter);
    }
}

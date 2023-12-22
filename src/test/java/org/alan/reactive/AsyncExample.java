package org.alan.reactive;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class AsyncExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // Start an asynchronous task to download data
        CompletableFuture<String> downloadFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("Downloading data...");
            // Simulate time-consuming operation with sleep
            try {
                Thread.sleep(10000); // 5 seconds delay
                System.out.println("After 10 secs...");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return "Downloaded Data";
        });

        // Continue with other tasks
        for (int i = 0; i < 10; i++) {
            System.out.println("Doing other task" + i + " while data downloads...");
        }


        // Wait for the download to complete and then use the data
        String result = downloadFuture.get(); // This waits only if the download is not complete
        System.out.println("Task finished");

        System.out.println("Result of the download: " + result);
    }
}


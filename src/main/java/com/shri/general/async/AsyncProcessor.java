package com.shri.general.async;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class AsyncProcessor {

    // The async method that returns a CompletableFuture
    public CompletableFuture<String> processAsync() {

        return CompletableFuture.supplyAsync(() -> {
            // Simulate long-running task
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                return "Task Interrupted";
            }
            return "Task Completed Successfully!";
        });
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        AsyncProcessor processor = new AsyncProcessor();

        // Start async processing and handle the result synchronously
        CompletableFuture<String> futureResult = processor.processAsync();
        System.out.println("Result from Aysnc Task 1 - " + futureResult.join());

        // Start another async processing task and handle the result synchronously
        futureResult = processor.processAsync();
        System.out.println("Result from Aysnc Task 2 - " + futureResult.get());

        // Start another async processing task and handle the result asynchronously
        processor.processAsync().thenAccept(result -> {
            System.out.println("Result from Async Task 3 - " + result);
        }).exceptionally(ex -> {
            System.err.println("Error occurred: " + ex.getMessage());
            return null;
        });

        // End get printed before the the Result from Async Task 3, showing the asynchrnocity of the previous step.
        System.out.println("End");

        // Keep the main thread alive to see the async result
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.err.println("Main thread interrupted: " + e.getMessage());
        }

    }
}

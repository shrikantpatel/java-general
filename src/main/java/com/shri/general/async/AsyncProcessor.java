package com.shri.general.async;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class AsyncProcessor {

    // The async method that takes a callback (Consumer)
    public void processAsync(Consumer<String> callback) {
        CompletableFuture.supplyAsync(() -> {
            // Simulate long-running task
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                return "Task Interrupted";
            }
            return "Task Completed Successfully!";
        }).thenAccept(callback); // Call the handler when done
    }

    public static void main(String[] args) {
        AsyncProcessor processor = new AsyncProcessor();

        // Define the callback handler
        Consumer<String> callback = result -> {
            System.out.println("Callback received: " + result);
        };

        // Start async processing
        System.out.println("Starting async task...");
        processor.processAsync(callback);

        // Keep the main thread alive for demonstration
        try {
            Thread.sleep(3000); // Wait to ensure callback prints
        } catch (InterruptedException ignored) {}
    }
}

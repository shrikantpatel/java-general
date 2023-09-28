package com.shri.general.threading;

public class TestingSynchronizedBlock {

    public static void main(String[] args) {
        TestingSynchronizedBlock t1 = new TestingSynchronizedBlock();

        Thread thread1 = new Thread(() -> {
            try {
                t1.test();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        thread1.start();
        Thread thread2 = new Thread(new Runnable() {

            // Prints thread name and value
            // of the counter variable
            @Override
            public void run() {
                try {
                    t1.test();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        thread2.start();
    }

    public void test() throws InterruptedException {
        synchronized (this) {
            System.out.println("test");
            Thread.sleep(5000);
            System.out.println("test complete");
        }
    }
}

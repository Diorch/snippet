package com.others;

import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 同步队列实现消费者&生产者模型
 *
 * @author dechuye
 */
public class ProducerAndConsumerWithSyncQueue {

    public static void main(String[] args) throws IOException {

        final LinkedBlockingQueue<String> q = new LinkedBlockingQueue<>(100);
        for (int i = 0; i < 10; i++) {
            new Thread(new Consumer(q)).start();
        }
        new Thread(new Producer(q)).start();

        System.in.read();
    }

    static class Producer implements Runnable {

        LinkedBlockingQueue<String> msg;

        public Producer(LinkedBlockingQueue<String> msg) {
            this.msg = msg;
        }

        @Override
        public void run() {
            int i = 0;
            for (; ; ) {
                try {
                    msg.put(i++ + "");
                    TimeUnit.SECONDS.sleep(1L);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    static class Consumer implements Runnable {
        LinkedBlockingQueue<String> msg;

        public Consumer(LinkedBlockingQueue<String> msg) {
            this.msg = msg;
        }

        @Override
        public void run() {
            for (; ; ) {
                try {
                    System.out.println(Thread.currentThread().getName() + ": " + msg.take());
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}



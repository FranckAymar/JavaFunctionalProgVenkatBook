package playground.executeAroundMethodPattern;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Locker {

    public static void runInLockMode(Lock lock, Runnable block){
        lock.lock();

        try {
            block.run();
        }finally {
            lock.unlock();
        }
    }

    static void main() {

       try (ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor()){

           for (int i = 0; i < 1000; i++) {
               executorService.execute(() -> {
                   runInLockMode(new ReentrantLock(), () -> {
                       try {
                           Thread.sleep(1000);
                       } catch (InterruptedException e) {
                           throw new RuntimeException(e);
                       }
                       System.out.println("Test " + Thread.currentThread());
                   });
               });
           }

       }

    }
}

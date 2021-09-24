import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DeadLockMain {
    public static void main(String[] args) {
        new DeadLockMain().run();
    }

    private void run() {
        final int workersCount = 2;
        DeadLock deadLock1 = new DeadLock("09865789065");
        DeadLock deadLock2 = new DeadLock("0698765456789");

        Runnable runnable = () -> {
            deadLock1.printNumber(deadLock2);
            deadLock2.printNumber(deadLock1);

        };
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < workersCount; i++) {
            executor.execute(runnable);
        }
        executor.shutdownNow();
    }
}
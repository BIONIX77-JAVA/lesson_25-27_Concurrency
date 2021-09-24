import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingletonMain {
    public static void main(String[] args) {

        new SingletonMain().run();
    }

    private void run() {
        final int workersCount = 17;

        ExecutorService executor = Executors.newCachedThreadPool();
        CountDownLatch startSignal = new CountDownLatch(1);
        CountDownLatch doneSignal = new CountDownLatch(workersCount);
        for (int i = 0; i < workersCount; i++) {
            executor.execute(new SingletonRunnable(
                    startSignal, doneSignal));
        }
        startSignal.countDown();
        executor.shutdown();

        try {
            doneSignal.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
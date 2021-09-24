import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PointMainVolatile {
    public static void main(String[] args) {
        new PointMainVolatile().run();
    }

    private void run() {
        final int workersCount = 2_000;

        ExecutorService executor = Executors.newCachedThreadPool();
        CountDownLatch startSignal = new CountDownLatch(1);
        CountDownLatch doneSignal = new CountDownLatch(workersCount);
        Point point = new Point();

        for (int i = 0; i < workersCount; i++) {
            executor.execute(new PointRunnable(
                    startSignal, doneSignal, point));
        }
        startSignal.countDown();
        executor.shutdown();
        System.out.println("We are waiting for the completion of the work by all workers ...");
        try {
            doneSignal.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("x: " + point.getX());
        System.out.println("y: " + point.getY());
    }
}
import java.util.concurrent.CountDownLatch;

public class PointAtomicRunnable implements Runnable {
    private final CountDownLatch startSignal;
    private final CountDownLatch doneSignal;
    private final PointAtomic point;

    public PointAtomicRunnable(CountDownLatch startSignal, CountDownLatch doneSignal, PointAtomic point) {
        this.startSignal = startSignal;
        this.doneSignal = doneSignal;
        this.point = point;
    }

    @Override
    public void run() {
        try {
            startSignal.await();
        } catch (InterruptedException e) {
            System.out.println("The task was interrupted from the outside ");
            return;
        }
        point.move(1, 1);
        doneSignal.countDown();
    }
}
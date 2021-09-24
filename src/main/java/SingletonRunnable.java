import java.util.concurrent.CountDownLatch;

public class SingletonRunnable implements Runnable {
    private final CountDownLatch startSignal;
    private final CountDownLatch doneSignal;
    private Singleton singleton;

    public SingletonRunnable(CountDownLatch startSignal, CountDownLatch doneSignal) {
        this.startSignal = startSignal;
        this.doneSignal = doneSignal;
    }

    @Override
    public void run() {

        try {
            startSignal.await();
        } catch (InterruptedException e) {
            System.out.println("The task was interrupted from the outside");
            return;
        }
        System.out.println(Singleton.getInstance());
        doneSignal.countDown();
    }
}
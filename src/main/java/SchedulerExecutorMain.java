import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class SchedulerExecutorMain {
    public static void main(String[] args) {
        new SchedulerExecutorMain().run();
    }

    ScheduledExecutorService scheduler;

    private void run() {
        scheduler = Executors.newScheduledThreadPool(3);

        final Runnable hello = () -> System.out.print("Hello ");

        final Runnable world = () -> System.out.print("World ");

        ScheduledFuture<?> helloTimer =
                scheduler.scheduleAtFixedRate(hello, 10_000, 10_000, TimeUnit.MILLISECONDS);
        ScheduledFuture<?> worldTimer =
                scheduler.scheduleWithFixedDelay(world, 10_000, 9_990, TimeUnit.MILLISECONDS);

        scheduler.schedule(() -> {
            helloTimer.cancel(true);
            worldTimer.cancel(true);
        }, 60, TimeUnit.SECONDS);

        stop(scheduler);
    }

    private void stop(ScheduledExecutorService executor) {

        try {
            if (!executor.awaitTermination(61, TimeUnit.SECONDS)) {
                executor.shutdown();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
import java.util.concurrent.atomic.AtomicInteger;

public class PointAtomic {
    private final AtomicInteger x = new AtomicInteger(0);
    private final AtomicInteger y = new AtomicInteger(0);

    public void move(int dx, int dy) {
        x.addAndGet(dx);
        y.addAndGet(dy);
    }

    public AtomicInteger getX() {
        return x;
    }

    public AtomicInteger getY() {
        return y;
    }
}
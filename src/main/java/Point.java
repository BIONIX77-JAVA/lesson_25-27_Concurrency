public class Point {
    private volatile int x;
    private volatile  int y;

    public void move(int dx, int dy) {
        x += dx;
        y += dy;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

public class DeadLock {
    private final String number;

    public DeadLock(String number) {
        this.number = number;
    }

    public synchronized void printNumber(DeadLock deadLock) {
        System.out.printf("%nCall from number %s to number  %s", this.number, deadLock.getNumber());
        deadLock.printNumberBack(DeadLock.this);
    }

    private synchronized void printNumberBack(DeadLock deadLock) {
        System.out.printf("%n Number %s called back  %s", this.number, deadLock.getNumber());
    }

    public String getNumber() {
        return number;
    }
}

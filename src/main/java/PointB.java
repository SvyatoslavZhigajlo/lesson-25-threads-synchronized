public class PointB {
    public int xB;
    public int yB;
    private final Object lock = new Object();

    public PointB(int xB, int yB) {
        this.xB = xB;
        this.yB = yB;
    }

    public void moveSynchronizedLock1(int dx, int dy){
        synchronized (lock) {
            xB += dx;
            yB += dy;
        }
    }
}

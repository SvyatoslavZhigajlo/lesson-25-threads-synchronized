public class PointC {
    public int xC;
    public int yC;
    private static final Object lock = new Object();

    public PointC(int xC, int yC) {
        this.xC = xC;
        this.yC = yC;
    }

    public static void moveSynchronizedLock2(PointC pointC, int dx, int dy){
        synchronized (lock) {
            pointC.xC += dx;
            pointC.yC += dy;
        }
    }

}

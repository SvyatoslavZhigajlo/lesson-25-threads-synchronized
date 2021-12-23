public class PointBMoving implements Runnable{

    public PointB pointB;

    public PointBMoving(PointB pointB) {
        this.pointB = pointB;
    }

    @Override
    public void run() {
        pointB.moveSynchronizedLock1(1, 1);
    }
}

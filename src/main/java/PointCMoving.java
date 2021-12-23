public class PointCMoving implements Runnable{

    public PointC pointC;

    public PointCMoving(PointC pointC) {
        this.pointC = pointC;
    }

    @Override
    public void run() {
        PointC.moveSynchronizedLock2(pointC, 1,1);
    }
}

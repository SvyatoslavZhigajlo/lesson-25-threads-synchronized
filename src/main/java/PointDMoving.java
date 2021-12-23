public class PointDMoving implements Runnable{

    public PointD pointD;

    public PointDMoving(PointD pointD) {
        this.pointD = pointD;
    }

    @Override
    public void run() {
        pointD.moveSynchronizedX(pointD, 1,1);
    }
}

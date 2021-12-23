public class PointAMoving implements Runnable{

    private PointA pointA;

    public PointAMoving(PointA pointA) {
        this.pointA = pointA;
    }

    @Override
    public void run() {
        pointA.moveSynchronized(1,1);
    }
}

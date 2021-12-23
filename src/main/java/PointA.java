public class PointA {

    public int xA;
    public int yA;

    public PointA(int xA, int yA) {
        this.xA = xA;
        this.yA = yA;
    }

    public synchronized void moveSynchronized(int dx, int dy){
        xA += dx;
        yA += dy;
    }

}

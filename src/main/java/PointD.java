public class PointD {
    public int xD;
    public int yD;

    public PointD(int xD, int yD) {
        this.xD = xD;
        this.yD = yD;
    }

    public static synchronized void moveSynchronizedX(PointD pointD, int dx, int dy){
        pointD.xD +=dx;
        pointD.yD +=dy;
    }
}

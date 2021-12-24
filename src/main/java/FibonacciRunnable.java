import java.math.BigInteger;

public class FibonacciRunnable implements Runnable{
    public BigInteger current = BigInteger.valueOf(1);
    public BigInteger previous = BigInteger.valueOf(0);
    public int fibonacci;

    public FibonacciRunnable(int fibonacci){
        this.fibonacci = fibonacci;
    }

    public void run(){
        BigInteger f2;
        System.out.printf(previous + " " + current + " ");
        for (int i = 2; i <= fibonacci; i++) {
            f2 = previous.add(current);
            System.out.printf(f2 + " ");
            previous = current;
            current = f2;
            if (Thread.currentThread().isInterrupted()){
                break;
            }
        }
    }
}

public class FibonacciThread extends Thread {

    public int current = 1;
    public int previous = 0;
    public int fibonacci;

    public FibonacciThread(int fibonacci){
        this.fibonacci = fibonacci;
    }

    public void run(){
        int f2;
        for (int i = 3; i <= fibonacci; i++) {
            f2 = previous + current;
            System.out.printf(f2 + " ");
            previous = current;
            current = f2;
        }
    }
}

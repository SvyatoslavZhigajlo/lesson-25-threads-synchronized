import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        /*ДЗ 27 Задание 1 - Создать 2000 одновременных задач в Executor, которые двигают единственную двухмерную точку (Point) в
        одном направлении. Подтвердить проблему атомарности и решить ее с помощью ключевого слова synchronized
        (все варианты мониторов).
         */
        int xStart = 0;
        int yStart = 0;
        pointAMovingSynchronize(xStart, yStart);
        pointBMovingSynchronizeLock1(xStart, yStart);
        pointBMovingSynchronizeLock2(xStart, yStart);
        pointBMovingSynchronizeX(xStart, yStart);
        fibonacciThread();
    }

    private void pointAMovingSynchronize(int xStart, int yStart) {
        ExecutorService executor = Executors.newCachedThreadPool();
        PointA sharedPointA = new PointA(xStart, yStart);
        Collection<Future<?>> resultsA = new ArrayList<>();

        for (int i = 0; i < 2000; i++) {
            Future<?> resultA = executor.submit(new PointAMoving(sharedPointA));
            resultsA.add(resultA);
        }
        executor.shutdown();
        try {
            for (Future<?> result : resultsA) {
                result.get();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        ShowInfo.showInfoPointA(sharedPointA);

    }

    private void pointBMovingSynchronizeLock1(int xStart, int yStart) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        PointB sharedPointB = new PointB(xStart, yStart);
        Collection<Future<?>> results = new ArrayList<>();
        for (int i = 0; i < 2000; i++) {
            Future<?> result = executor.submit(new PointBMoving(sharedPointB));
            results.add(result);
        }
        executor.shutdown();
        try {
            for (Future<?> result : results) {
                result.get();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        ShowInfo.showInfoPointB(sharedPointB);
    }

    private void pointBMovingSynchronizeLock2(int xStart, int yStart) {
        ExecutorService executor = Executors.newCachedThreadPool();
        PointC pointC = new PointC(xStart, yStart);
        Collection<Future<?>> results = new ArrayList<>();
        for (int i = 0; i < 2000; i++) {
            Future<?> result = executor.submit(new PointCMoving(pointC));
            results.add(result);
        }
        executor.shutdown();
        try {
            for (Future<?> result : results) {
                result.get();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        ShowInfo.showInfoPointC(pointC);
    }

    private void pointBMovingSynchronizeX(int xStart, int yStart) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        PointD sharedPointD = new PointD(xStart, yStart);
        Collection<Future<?>> results = new ArrayList<>();

        for (int i = 0; i < 2000; i++) {
            Future<?> result = executor.submit(new PointDMoving(sharedPointD));
            results.add(result);
        }
        executor.shutdown();
        try {
            for (Future<?> result : results) {
                result.get();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        ShowInfo.showInfoPointD(sharedPointD);
    }

    private void fibonacciThread() {
        FibonacciThread thread = new FibonacciThread(6);
        thread.start();
        try {
            thread.join();
            System.out.println("Fibonacci " + thread.current);
        } catch (InterruptedException ignored) {
        }
    }

}

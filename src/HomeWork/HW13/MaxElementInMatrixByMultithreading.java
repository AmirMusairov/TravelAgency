package HW13;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MaxElementInMatrixByMultithreading {
    private int[][] mass;
    private int maxInArray;
    private List<Future<Integer>> futureList;

    MaxElementInMatrixByMultithreading(int[][] mass) {
        this.mass = mass;
        futureList = new ArrayList<>();
    }

    public List<Future<Integer>> getFutureList() {
        return futureList;
    }

    private static int[][] getRandomMatrix() {
        int[][] mass = new int[4][100];
        for (int i = 0; i < mass.length; i++) {
            for (int j = 0; j < mass[i].length; j++) {
                mass[i][j] = (int) (Math.random() * 100);
                System.out.print(mass[i][j] + "\t");
            }
            System.out.println();
        }
        return mass;
    }

    private void getMaxValueInOneRow() throws InterruptedException, ExecutionException {
        Callable<Integer>[] arrCallable = new MyThread[mass.length];
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < arrCallable.length; i++) {
            arrCallable[i] = new MyThread(i);
            futureList.add(exec.submit(arrCallable[i]));
        }
        exec.shutdown();
        int max = futureList.get(0).get();
        for (Future<Integer> future : futureList) {
            if (future.get() > max) {
                max = future.get();
            }
        }
        maxInArray = max;
        System.out.println(maxInArray);

    }

    private class MyThread implements Callable<Integer> {
        private int threadElement;
        private int maxOfThread;

        public MyThread(int threadElement) {
            this.threadElement = threadElement;
        }

        @Override
        public Integer call() throws Exception {
            for (int i = 0; i < mass[threadElement].length; i++) {
                if (mass[threadElement][i] > maxOfThread || mass[threadElement][i] == mass[0][0]) {
                    maxOfThread = mass[threadElement][i];
                    Thread.currentThread().sleep(1);
                }
            }
            return maxOfThread;
        }
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        long start = System.nanoTime();
        MaxElementInMatrixByMultithreading maxMulti = new MaxElementInMatrixByMultithreading(
                MaxElementInMatrixByMultithreading.getRandomMatrix());
        maxMulti.getMaxValueInOneRow();
        long finish = System.nanoTime();
        double timeOfMultiThreadingSearch = (finish - start) / 1_000_000_000.0;
        System.out.println(timeOfMultiThreadingSearch);
    }
}

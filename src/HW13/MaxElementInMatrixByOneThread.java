package HW13;

public class MaxElementInMatrixByOneThread {
    private int[][] getRandomMatrix() {
        int[][] mass = new int[4][100];
        for (int i = 0; i < mass.length; i++) {
            for (int j = 0; j < mass[i].length; j++) {
                mass[i][j] = (int) (Math.random() * 100);
            }
        }
        return mass;
    }

    private void printMatrix(int[][] mass) {
        for (int i = 0; i < mass.length; i++) {
            for (int j = 0; j < mass[i].length; j++) {
                System.out.print(mass[i][j] + "\t");
            }
            System.out.println();
        }
    }

    private int getMaxValue(int[][] mass) {
        int max = 0;
        for (int i = 0; i < mass.length; i++) {
            for (int j = 0; j < mass[i].length; j++) {
                if (mass[i][j] > max) {
                    max = mass[i][j];
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        MaxElementInMatrixByOneThread obj = new MaxElementInMatrixByOneThread();
        int[][] mass = obj.getRandomMatrix();

        obj.printMatrix(mass);
        System.out.println(obj.getMaxValue(mass));
        long finish = System.nanoTime();
        double timeOfSingleThreadingSearch = (finish - start) / 1_000_000_000.0;
        System.out.println(timeOfSingleThreadingSearch);
    }
}
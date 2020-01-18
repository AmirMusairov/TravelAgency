package HW8;
import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {

        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 100);
        }

        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] > array[i]) {
                int numberBiggerThanPrevious = array[i - 1];
                array[i - 1] = array[i];
                array[i] = numberBiggerThanPrevious;
                i = 0;
            }
        }
        System.out.println(Arrays.toString(array));
    }
}

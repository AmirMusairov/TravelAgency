package HW3;

public class Random {
    public static void main(String[] args) {
        int[] arr;
        arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = ((int) (Math.random() * 10));
            System.out.print(arr[i] + " ");
        }
        System.out.print("\n");

        int[] arr2;
        arr2 = new int[20];
        for (int i = 0; i < 10; i++) {
            arr2[i] = arr[i];
            arr2[i + 10] = arr[i] * 2;
        }
        for (int i = 0; i < 20; i++) {
            System.out.print(arr2[i] + " ");
        }
    }
}

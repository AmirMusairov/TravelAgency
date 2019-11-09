package HW3;
import java.util.Scanner;

public class Figure {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Введите высоту фигуры: ");
        int height = sc.nextInt();
        int b = 1;
        for (int i = 1; i <= height; ++i) {
            System.out.print("*");
            if (b <= i && b < height) {
                System.out.println();
                b++;
                i = 0;
            }
            if (height == i){
                System.out.println();
                height--;
                i = 0;
            }
        }
    }
}
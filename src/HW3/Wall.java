package HW3;
import java.util.Scanner;

public class Wall {

    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Введите количество полос: ");
            int a = sc.nextInt();
            int i, j;

            for (j = 1; j <= a; j++) {
                for (i = 1; i < 4; i++) {
                    System.out.print("***");
                    System.out.print("+++");
                }
                System.out.println(" ");
            }
    }
}
package HW4;
import java.util.Scanner;

public class Plus {

        public static void drowRectangle(int a, int b) {
            String n = " ";
            String spaces = new String(new char[a - 2]).replace("\0", n);

            for (int i = 0; i < a; i++)
                System.out.print("+");
            System.out.println();
            for (int j = 0; j < (b - 2); j++)
                System.out.println("+" + spaces + "+");
            for (int i = 0; i < a; i++)
                System.out.print("+");
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Введите ширину прямоугольника: ");
            int a = sc.nextInt();
            System.out.println("Введите высоту прямоугольника: ");
            int b = sc.nextInt();
            drowRectangle(a, b);
        }
    }

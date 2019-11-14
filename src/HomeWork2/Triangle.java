package HomeWork2;
import java.util.Scanner;

public class Triangle {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Введите длину стороны треугольника a: ");
        double a = sc.nextDouble();
        System.out.println("Введите длину стороны треугольника b: ");
        double b = sc.nextDouble();
        System.out.println("Введите длину стороны треугольника c: ");
        double c = sc.nextDouble();

        double p = (a + b + c) / 2;
        double s = Math.sqrt(p * (p - a) * (p - b) * (p - c));

        System.out.println("Площадь треугольника равна " + s);
    }
}
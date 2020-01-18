package HW4;
import java.util.Random;

public class ArrayMaxNumber {
        public static void main(String[] args) {
            int[] massive = new int[10];

            Random random = new Random();
            for(int i = 0; i < massive.length; i++){
                massive[i] = random.nextInt(100);
            }
            print(massive);
            System.out.println("\nMax number: " + maxNumber(massive));

        }

        public static int maxNumber(int[] massive){
            int tempMax = 0;
            for(int i = 0; i < massive.length; i++){
                if(massive[i] > tempMax){
                    tempMax = massive[i];
                }
            }
            return tempMax;
        }
        static void print(int[] massive) {
            for(int k:massive){System.out.print(k + " ");}
        }
    }

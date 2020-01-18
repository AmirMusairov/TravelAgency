package HW3;
import java.util.Arrays;

public class Text {
        public static void main(String[] args) {
            String[] strArr = {"ABC", "A", "ABCD", "AB"};
            Arrays.sort(strArr, (str1, str2) -> str2.length() - str1.length());

            System.out.println(Arrays.toString(strArr));

        }
}

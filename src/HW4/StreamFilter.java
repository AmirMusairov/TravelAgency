package HW4;
import java.util.Arrays;

public class StreamFilter {
    public static void main(String[] args) {
        String[] arrayOfStrings  = {"Just", "A", "Eat", "The", "Three", "Symbol", "Worlds"};

        String[] selectStrings = Arrays.stream(arrayOfStrings)
                .filter(s -> s.length() > 3)
                .toArray(String[]:: new);
        System.out.println(Arrays.toString(selectStrings));
    }
}
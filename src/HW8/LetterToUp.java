package HW8;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LetterToUp {
    public static void main(String[] args) {

        String string = "When I was younger, I never needed";

        Pattern pattern = Pattern.compile("\\b[a-z]\\B");

        Matcher matcher = pattern.matcher(string);

        while (matcher.find()) {

            string = string.replaceFirst(pattern.toString(), matcher.group().toUpperCase());
        }
        System.out.println(string);
    }
}
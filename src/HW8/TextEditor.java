package HW8;

import static java.nio.file.StandardOpenOption.CREATE;
import static java.nio.file.StandardOpenOption.APPEND;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class TextEditor {
    private static StringBuilder scan() {
        Scanner scan = new Scanner(System.in);
        System.out.print("File Text: \n");
        StringBuilder textResult = new StringBuilder();

        while (scan.hasNextLine()) {

            String textStop = scan.nextLine();

            textResult.append(textStop  + "\n");

            if( textStop.equals("exit")) {
                break;
            }

        }

        return textResult;
    }

    static File file = new File("src/HW8/TextEditor.txt");
    static Path start = file.toPath();

    private static void writeNio(StringBuilder stringBuilder) throws IOException {
        try {
            Files.write(start, stringBuilder.toString().getBytes(), CREATE, APPEND);
        } catch (IOException e) {
            System.out.println("Do you have a problem?" + e);
        }
    }

    private class Statistics {

        private void showText() throws IOException {

            try (Stream<String> stream = Files.lines(start)) {
                stream.forEach(System.out::println);
            }
            System.out.println("Characters: " + file.length());
        }

        private void showVowel() throws IOException {

            List<String> lines = Files.readAllLines(start);
            int intervalKeeper = 0;
            int result = 0;

            for (int i = 0; i < lines.size(); i++) {
                int count = 0;

                for (int j = 0; j < lines.get(i).length(); j++) {

                    if (lines.get(i).substring(j, j + 1).toLowerCase().matches("[aeiouyàîèå¸ýûóþÿ]")) {
                        count++;
                    }
                }
                if (count > intervalKeeper) {
                    intervalKeeper = count;
                    result = i + 1;
                }
            }

            System.out.println("The biggest number of vowel in line: " + result);
        }

        public void showCountOfWords() throws IOException {

            List<String> lines = Files.readAllLines(start);

            int countWords = 0;

            for (int i = 0; i < lines.size(); i++) {

                if (!lines.get(i).isEmpty()) {

                    for (int j = 0; j < lines.get(i).split("\\s").length; j++) {
                        countWords++;

                    }

                }
            }
            System.out.println("Words count: " + countWords);

        }

    }

    public Statistics createObjectOfStatistics() {
        return new Statistics();
    }

    public static void main(String[] args) throws IOException {

        TextEditor.writeNio(scan());
        TextEditor ste = new TextEditor();
        TextEditor.Statistics stat = ste.createObjectOfStatistics();

        stat.showText();
        stat.showVowel();
        stat.showCountOfWords();
    }
}
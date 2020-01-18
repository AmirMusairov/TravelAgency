package HW8;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class FileFinder extends SimpleFileVisitor<Path> {
    private final static int MAX_DEPTH = 6;
    private static Path absolutePath = Paths.get(new File(" ").getAbsolutePath() + "1");

    private static void showMeThroughStream() throws IOException {
        try (Stream<Path> stream = Files.find(absolutePath, MAX_DEPTH, (path, attr) -> String.valueOf(path).endsWith(".java"))) {
            String joined = stream.sorted().map(String::valueOf).collect(Collectors.joining("; \n"));
            System.out.println("Found: \n" + joined);
        } catch (IOException e) {
            System.err.println("\n" + "Something went wrong in method : showMeThroughStream" + "\n");
            throw new IOException(e);
        } finally {
            System.out.println("\n" + "Method showMeThroughStream have finished its work" + "\n");
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Directory tree starting with " + absolutePath + ":\n");
        showMeThroughStream();
    }
}

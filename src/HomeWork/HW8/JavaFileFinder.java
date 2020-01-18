package HW8;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;


public class JavaFileFinder extends SimpleFileVisitor<Path> {
    private final static int MAX_DEPTH = 6;
    private static Path absolutePath = Paths.get(new File("").getAbsolutePath() + "1");

    @Override
    public FileVisitResult visitFile(Path path, BasicFileAttributes attribs) throws IOException {
        if (String.valueOf(path).endsWith(".java") && path.getNameCount() <=
                MAX_DEPTH) {
            System.out.println(path);
        }

        return FileVisitResult.CONTINUE;
    }

        public static void main (String[] args) throws IOException {
            System.out.println("Directory tree starting with " + absolutePath + ":\n");

            try {
                Files.walkFileTree(absolutePath, new JavaFileFinder());
            } catch (IOException e) {
                System.err.println("\n" + "Something went wrong in method : showMeThroughStream" + "\n");
                throw new IOException(e);
            } finally {
                System.out.println("\n" + "Method walkFileTree have finished its work" + "\n");
            }
        }
}

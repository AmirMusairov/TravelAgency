package HW13;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class BufferedReaderWriter {
    public static String str;
    private static AtomicInteger regulator = new AtomicInteger();

    private static class Writer implements Runnable {
        private int index;
        private String[] massStr = { "FIRST STRING", "SECOND STRING", "THIRD STRING" };
        @Override
        public void run() {
            while (true) {
                if (regulator.get() == 4) {
                    regulator.set(0);
                }
                if (regulator.get() == 0) {
                    if (index == 3) {
                        break;
                    }
                    System.out.println("Wrote: " + massStr[index]);
                    str = massStr[index];
                    index++;
                    regulator.set(1);
                }
            }
        }
    }

    private static class Reader implements Runnable {
        private Writer writer;
        private String previousStr = "";
        public Reader(Writer writer) {
            this.writer = writer;
        }
        @Override
        public void run() {
            while (true) {
                if (regulator.get() >= 1 && !previousStr.equals(str)) {
                    System.out.println(Thread.currentThread().getName() + str);
                    regulator.incrementAndGet();
                    previousStr = str;
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Writer writer = new Writer();
        Thread threadWriter = new Thread(writer);

        ArrayList<Reader> listReaders = new ArrayList<>();
        ArrayList<Thread> listThreads = new ArrayList<>(listReaders.size());

        threadWriter.start();
        for(int i = 0; i < 3; i++) {
            listReaders.add(new Reader(writer));
            listThreads.add(new Thread(listReaders.get(i)));
            listThreads.get(i).setDaemon(true);
            listThreads.get(i).setName("Reader-" + i + " read: ");
            listThreads.get(i).start();
        }
        threadWriter.join();
    }
}
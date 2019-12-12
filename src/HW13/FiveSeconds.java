package HW13;

import java.util.concurrent.TimeUnit;

public class FiveSeconds {

        public static void main(String [] args) throws InterruptedException {

            DaughterThread daughterThread = new DaughterThread();
            daughterThread.start();

            TimeUnit.SECONDS.sleep(5);

            daughterThread.interrupt();
            System.out.println(Thread.currentThread().getName() + " Stop");
        }
    }

    class DaughterThread extends Thread {

        @Override
        public void run() {
            try {
                int i = 0;
                while(true) {
                    Thread.sleep(500);
                    System.out.println(this.getName() + " iteration -" + i++);}
            } catch (InterruptedException e) {
                System.out.println(this.getName() + " Stop");;
            }
        }
    }
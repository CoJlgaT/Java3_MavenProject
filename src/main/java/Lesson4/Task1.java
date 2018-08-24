package Lesson4;

public class Task1 {
    static Object mon = new Object();
    static volatile char currentL = 'A';

    public static void startTask1() {
        new Thread(new Runnable() {
            public void run() {
                try {
                    for (int i = 0; i < 5; i++) {
                        synchronized (mon) {
                            while (currentL != 'A') {
                                mon.wait();
                            }
                            System.out.print("A");
                            currentL = 'B';
                            mon.notifyAll();
                        }

                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                try {
                    for (int i = 0; i < 5; i++) {
                        synchronized (mon) {
                            while (currentL != 'B') {
                                mon.wait();
                            }
                            System.out.print("B");
                            currentL = 'C';
                            mon.notifyAll();
                        }

                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                try {
                    for (int i = 0; i < 5; i++) {
                        synchronized (mon) {
                            while (currentL != 'C') {
                                mon.wait();
                            }
                            System.out.print("C");
                            currentL = 'A';
                            mon.notifyAll();
                        }

                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

}

package Lesson4;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Task2 {
    static DataOutputStream dos;

    public static void startTask2() {
        try {
            dos = new DataOutputStream(new FileOutputStream("lesson4_task2.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Thread t1=new Thread(new Runnable() {
            public void run() {
                try {
                    for (int i = 0; i < 10; i++) {
                        synchronized (dos) {
                            dos.writeBytes("hello 1 \r\n");
                            Thread.sleep(20);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2=new Thread(new Runnable() {
            public void run() {
                try {
                    for (int i = 0; i < 10; i++) {
                        synchronized (dos) {
                            dos.writeBytes("hi 2 \r\n");
                            Thread.sleep(20);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t3= new Thread(new Runnable() {
            public void run() {
                try {
                    for (int i = 0; i < 10; i++) {
                        synchronized (dos) {
                            dos.writeBytes("good day 3 \r\n");
                            Thread.sleep(20);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        t2.start();
        t3.start();
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            dos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

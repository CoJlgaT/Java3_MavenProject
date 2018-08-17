package lesson3;


    import java.io .*;
    import java.util.ArrayList;
    import java.util.Collections;

    public class Main {
        public static void main(String[] args) throws IOException {
            ////Task1
//        try (FileInputStream in = new FileInputStream("test.txt")) {
//            byte[] arr = new byte[512];
//            int x;
//            while ((x = in.read(arr)) != -1) {
//                System.out.println(new String(arr, 0, x));
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
// Task2
//        ArrayList<InputStream> ali = new ArrayList<>();
//        try {
//            ali.add(new FileInputStream("1.txt"));
//            ali.add(new FileInputStream("2.txt"));
//            ali.add(new FileInputStream("3.txt"));
//            ali.add(new FileInputStream("4.txt"));
//            ali.add(new FileInputStream("5.txt"));
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        SequenceInputStream in = new SequenceInputStream((Collections.enumeration(ali)));
//        int x;
//        while ((x = in.read()) != -1) {
//            System.out.print((char) x);
//        }
// Task3
            long t = System.currentTimeMillis();
            readPage("6.txt", 689);
            System.out.println();
            System.out.println(System.currentTimeMillis() - t);
        }

        public static void readPage(String filename, int page) {
            try (RandomAccessFile raf = new RandomAccessFile(filename, "r")) {
                long length = raf.length();
                long start = 1800 * (page - 1);
                raf.seek(start);
                if (start > length) {
                    System.out.println("Вылетели за границы файла");
                } else if (start + 1800 > length) {
                    for (int i = 0; i < length - start; i++) {
                        System.out.print((char) raf.read());
                    }
                } else {
                    for (int i = 0; i < 1800; i++) {
                        System.out.print((char) raf.read());
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


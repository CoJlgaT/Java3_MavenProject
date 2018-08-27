package lesson6;

import java.util.Arrays;

public class MainClass  {
    public static int[] task1(int... input) throws RuntimeException {

        int start = input.length;
        for (int i = input.length-1; i >=0 ; i--) {
            if (input[i]==4) {
                start=i;
                break;
            }
        }
        if (start==input.length) {
            throw new RuntimeException("Нет четверок во входном массиве");
        }
        int[] output= new int[input.length-start-1];
        for (int i = start+1; i < input.length; i++) {
            output[i-start-1] = input[i];
        }

        return output;
    }

    public static void main(String[] args)  {
//        System.out.println(Arrays.toString(task1(1,2,3,4,5,6,7)));
//        System.out.println(Arrays.toString(task1(1,4,3,4,5,4,7)));
//        System.out.println(Arrays.toString(task1(1,2,3,4,5,6,4)));
//        System.out.println(Arrays.toString(task1(1,2,3,7,5,6,0)));

        System.out.println(task2(1,2,3,4,5,6,7));
        System.out.println(task2(1,4,4,4,4,1,1));

        System.out.println(task2(1));
        System.out.println(task2());
    }

    public static boolean task2(int... input){
        boolean flag = false;
        for (int i = 0; i < input.length; i++) {
            if(input[i]==1 || input[i]==4) {
                flag = true;
            } else return false;
        }
        return flag;
    }

}

package Lesson_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
////Task 1
//        Integer[] arrInt = new Integer[10];
//        for (int i = 0; i < 10; i++) {
//            arrInt[i] = i + 10;
//        }
//
//        System.out.println(Arrays.toString(arrInt));
//        ArrayGeneric<Integer> arrayGeneric = new ArrayGeneric<Integer>(arrInt);
//
//        arrInt = arrayGeneric.change(3, 5);
//
//        System.out.println(Arrays.toString(arrInt));
////Task2
//        ArrayList<Integer> aL = arrayGeneric.toArrayList();
//
//        System.out.println(aL.toString());

//Task3
        Apple ap1 = new Apple();
        Orange or1 = new Orange();

        Box<Apple> box1 = new Box<Apple>();

        box1.add(ap1);
        System.out.println("Box1: " +box1.getWeight());
        box1.add(ap1);
        System.out.println("Box1: " +box1.getWeight());


        Box<Orange> box2 = new Box<Orange>();
        box2.add(or1);
        System.out.println("Box2: " +box2.getWeight());
        box2.add(or1);
        System.out.println("Box2: " +box2.getWeight());


        System.out.println(box1.compare(box2));
        box1.add(ap1);
        System.out.println("Box1: " +box1.getWeight());
        System.out.println(box1.compare(box2));

        Box<Orange> box3 = new Box<Orange>();
        box3.add(or1);
        System.out.println("Box3: " +box3.getWeight());

        box3.changeBox(box2);
        System.out.println("Box3: " +box3.getWeight());
        System.out.println("Box2: " +box2.getWeight());

    }

}


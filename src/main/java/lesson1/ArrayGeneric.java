package Lesson_1;

import java.util.ArrayList;
import java.util.Collections;

class ArrayGeneric<T> {
    private T[] arr;

    public ArrayGeneric(T... arr) {
        this.arr = arr;
    }

    public T[] getArr() {
        return arr;
    }

    public void setArr(T[] arr) {
        this.arr = arr;
    }

    public T[] change(int a, int b) {
        if ((a >= arr.length) || (b >= arr.length)) {
            System.out.println("неверные данные");
            return arr;
        }

        T tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
        return arr;
    }

    public ArrayList<T> toArrayList() {
        ArrayList<T> arrList = new ArrayList<T>();
        Collections.addAll(arrList, arr);
        return arrList;
    }
}

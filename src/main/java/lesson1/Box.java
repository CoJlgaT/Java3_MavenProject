package Lesson_1;

import java.util.ArrayList;

class Box<T extends Fruit> {
    ArrayList<T> box;

    public Box() {
        this.box = new ArrayList<T>();
    }

    public Box(ArrayList<T> box) {
        this.box = box;
    }

    public float getWeight() {
        if (box.size()==0){return 0;}
        return box.size() * box.get(0).getWeight();
    }

    public boolean compare(Box box2) {
        return this.getWeight() == box2.getWeight();
    }

    public void add(T fruit) {
        box.add(fruit);
    }

    public void add(ArrayList<T> fruits) {
        box.addAll(fruits);
    }

    public T get() {
        if (box.size() == 0) {
            System.out.println("коробка пуста");
            return null;
        }
        return box.remove(box.size() - 1);
    }

    public ArrayList<T> getAll() {
        ArrayList<T> temp = box;
        box = new ArrayList<T>();
        return temp;
    }

    public void changeBox(Box<T> box2) {
        box.addAll(box2.getAll());
    }

}

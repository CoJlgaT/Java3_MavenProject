package lesson7;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        start(TestClass.class);
    }

    static void start(Class Class) {
        checkBeforeAndAfter(Class);
        Method[] metods = Class.getDeclaredMethods();
        for (Method m : metods) {
            if (m.isAnnotationPresent(BeforeSuite.class)) {
                try {
                    m.invoke(null);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }

        for (int i = 10; i >= 1; i--) {
            for (Method m : metods) {
                if (m.isAnnotationPresent(Test.class)) {
                    if (m.getAnnotation(Test.class).prio() == i) {
                        try {
                            m.invoke(null);
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        for (Method m : metods) {
            if (m.isAnnotationPresent(AfterSuite.class)) {
                try {
                    m.invoke(null);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    private static void checkBeforeAndAfter(Class Class) {
        Method[] metods = Class.getDeclaredMethods();
        int after = 0;
        int before = 0;
        for (Method m : metods) {
            if (m.isAnnotationPresent(AfterSuite.class)) {
                after++;
            }
            if (m.isAnnotationPresent(BeforeSuite.class)) {
                before++;
            }
        }
        if (after != 1 || before != 1) {
            throw new RuntimeException("Аннотация для конца или начала не единственная");
        }
    }


}

package lesson7;

public class TestClass {
    @Test (prio = 6)
    static void prio6_1() {
        System.out.println("Приоритет 6 (1)");
    }
    @Test (prio = 6)
    static void prio6_2() {
        System.out.println("Приоритет 6 (2)");
    }

    @Test (prio = 1)
    static void prio1() {
        System.out.println("Приоритет 1");
    }
    @Test
    static void prio5_1() {
        System.out.println("Приоритет по умолчанию (1)");
    }
    @Test (prio = 3)
    static void prio3_1() {
        System.out.println("Приоритет 3 (1)");
    }

    @Test (prio = 9)
    static void prio9() {
        System.out.println("Приоритет 9");
    }

    @Test (prio = 6)
    static void prio5_2() {
        System.out.println("Приоритет по умолчанию (2)");
    }

    @Test (prio = 3)
    static void prio3_2() {
        System.out.println("Приоритет 3 (2)");
    }

    @Test
    static void prio5_3() {
        System.out.println("Приоритет по умолчанию (3)");
    }

    @BeforeSuite
    static void before(){
        System.out.println("Start program test");
    }
    @AfterSuite
    static void after(){
        System.out.println("End program test");
    }
//    @AfterSuite
//    static void after1(){
//        System.out.println("End program test");
//    }

}

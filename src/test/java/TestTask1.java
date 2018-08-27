import org.junit.Assert;
import org.junit.Test;

public class TestTask1 {

    @Test
    public void test1() {
        int[] actualsArray1 = {5, 6, 7};
        Assert.assertArrayEquals(lesson6.MainClass.task1(1, 2, 3, 4, 5, 6, 7), actualsArray1);
    }


    @Test
    public void test2() {
        int[] actualsArray2 = {7};
        Assert.assertArrayEquals(lesson6.MainClass.task1(1, 4, 3, 4, 5, 4, 7), actualsArray2);
    }

    @Test
    public void test3() {
        int[] actualsArray3 = {};
        Assert.assertArrayEquals(lesson6.MainClass.task1(1, 2, 3, 4, 5, 6, 4), actualsArray3);
    }

    @Test
    public void test4() {
        int[] actualsArray4 = {1, 2, 3, 7, 5, 6, 0};
        Assert.assertArrayEquals(lesson6.MainClass.task1(4, 1, 2, 3, 7, 5, 6, 0), actualsArray4);
    }

    @Test(expected = RuntimeException.class)
    public void test5() {
        lesson6.MainClass.task1(1, 1, 2, 3, 7, 5, 6, 0);
    }

    @Test(expected = RuntimeException.class)
    public void test6() {
        lesson6.MainClass.task1(1, 1, 4, 3, 7, 5, 6, 0);
    }


}


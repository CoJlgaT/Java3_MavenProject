import org.junit.Assert;
import org.junit.Test;

public class TestTask2 {


    @Test
    public void test1() {
        int[] actualsArray1 = {4, 1, 2, 3, 7, 5, 6, 0};
        Assert.assertFalse(lesson6.MainClass.task2(actualsArray1));
    }
    @Test
    public void test2() {
        int[] actualsArray2 = {1,2,3,4,5,6,7};
        Assert.assertFalse(lesson6.MainClass.task2(actualsArray2));
    }
    @Test
    public void test3() {
        int[] actualsArray3 = {1};
        Assert.assertTrue(lesson6.MainClass.task2(actualsArray3));
    }
    @Test
    public void test4() {
        int[] actualsArray4 = {};
        Assert.assertFalse(lesson6.MainClass.task2(actualsArray4));
    }
    @Test
    public void test5() {
        int[] actualsArray5 = {};
        Assert.assertTrue(lesson6.MainClass.task2(actualsArray5));
    }

}

import duy.poly.ontapkkiemthu.testOne.tinhTong;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class tongTest {

    tinhTong tong = new tinhTong();

    @Test
    public void test1(){
        int act = tong.tong(new int[0]);
        int exp = 0;
        assertEquals(exp,act);
    }

    @Test
    public void test2(){
        int[] arr = new int[1000000000];
        Arrays.fill(arr,1);
        int act = tong.tong(arr);
        int exp = 1000000000;
        assertEquals(exp,act);
    }

    @Test
    public void test3(){
        Assertions.assertThrows(
                NullPointerException.class ,()->tong.tong(null)
        );
    }

    @Test
    public void test4(){
        int[] arr = {7};
        int act = tong.tong(arr);
        int exp = 7;
        assertEquals(exp,act);
    }

    @Test
    public void test5(){
        int[] arr = {1,7,7,0,1,3};
        int act = tong.tong(arr);
        int exp = 19;
        assertEquals(exp,act);
    }

    @Test
    public void test6(){
        int[] arr = {-1,-2,-3,-4,-5};
        int act = tong.tong(arr);
        int exp = -15;
        assertEquals(exp,act);
    }

    @Test
    public void test7(){
        int[] arr = {Integer.MAX_VALUE};
        int act = tong.tong(arr);
        int exp = Integer.MAX_VALUE;
        assertEquals(exp,act);
    }

    @Test
    public void test8(){
        int[] arr = {Integer.MIN_VALUE};
        int act = tong.tong(arr);
        int exp = Integer.MIN_VALUE;
        assertEquals(exp,act);
    }

    @Test
    public void test9(){
        int[] arr = {Integer.MAX_VALUE, Integer.MAX_VALUE};
        Assertions.assertThrows(ArithmeticException.class, () -> tong.tong(arr));
    }

    @Test
    public void test10(){
        int[] arr = {Integer.MIN_VALUE, Integer.MIN_VALUE};
        Assertions.assertThrows(ArithmeticException.class, () -> tong.tong(arr));
    }
}

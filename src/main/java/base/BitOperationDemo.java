package base;

/**
 * @author hzzhou
 * @since 2022-01-05
 */
public class BitOperationDemo {
    public static void main(String[] args) {
        test_1();
    }

    private static void test_1() {
        int i = 1<<0;
        int j = 1<<2;
        int k = 1<<3;
        int l = 1<<4;
        System.out.println("左移位运算" + i);
        System.out.println("左移位运算" + j);
        System.out.println("左移位运算" + k);
        System.out.println("左移位运算" + l);
    }
}

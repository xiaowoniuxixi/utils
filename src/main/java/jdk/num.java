package jdk;

/**
 * @author hzzhou
 * @since 2022-02-08
 */
public class num {
    private static final long TIMEOUT_MS = 10_000;

    public static void main(String[] args) {
        test_1();
    }

    private static void test_1() {
        System.out.println("TIMEOUT_MS:" + TIMEOUT_MS);
    }
}

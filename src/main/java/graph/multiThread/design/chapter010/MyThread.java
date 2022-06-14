package graph.multiThread.design.chapter010;

/**
 * @author hzzhou
 * @since 2022-05-23
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            System.out.print("Nice!");
        }
    }
}

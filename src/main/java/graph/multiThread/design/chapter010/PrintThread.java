package graph.multiThread.design.chapter010;

/**
 * @author hzzhou
 * @since 2022-05-23
 */
public class PrintThread extends Thread{
    private String message;

    public PrintThread(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.print(message);
        }
    }
}

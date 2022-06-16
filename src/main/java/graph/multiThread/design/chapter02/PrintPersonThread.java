package graph.multiThread.design.chapter02;

/**
 * @author hzzhou
 * @since 2022-06-14
 */
public class PrintPersonThread extends Thread {
    private Person person;

    public PrintPersonThread(Person person) {
        this.person = person;
    }

    public void run() {
        while (true) {
            System.out.println(Thread.currentThread().getName() + " prints " + person);
        }
    }
}

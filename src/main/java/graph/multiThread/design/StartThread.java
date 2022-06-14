package graph.multiThread.design;

import graph.multiThread.design.chapter010.Bank;
import graph.multiThread.design.chapter010.ClientThread;

/**
 * @author hzzhou
 * @since 2022-05-23
 */
public class StartThread {
    /**
     * 1-4
     * @param args
     */
//    public static void main(String[] args) {
//        MyThread t = new MyThread();
//        t.start();
//        for (int i = 0; i < 10000; i++) {
//            System.out.print("Good!");
//        }
//
//    }

    /**
     * 1-11
     * @param args
     */
//    public static void main(String[] args) {
//        new PrintThread("*").run();
//        new PrintThread("+").run();
//
//    }

    public static void main(String[] args) {
        Bank bank = new Bank("A Bad Bank", 1000);
        new ClientThread(bank).start();
        new ClientThread(bank).start();

    }
}

package graph.multiThread.design;

import graph.multiThread.design.chapter01.EaterThread;
import graph.multiThread.design.chapter01.Gate;
import graph.multiThread.design.chapter01.Tool;
import graph.multiThread.design.chapter01.UserThread;

/**
 * @author hzzhou
 * @since 2022-05-23
 */
public class Chapter01Main {

    public static void main(String[] args) {
        func6();
    }

    // 习题1-6
    public static void func6() {
        System.out.println("Testing EaterThread, hit CRTL+C to exit");
        Tool spoon = new Tool("Spoon");
        Tool fork = new Tool("Fork");
        new EaterThread("Alice", spoon, fork).start();
        new EaterThread("Bobby", fork, spoon).start();
    }

    // 习题1-1
    public static void func1() {
        System.out.println("Testing Gate, hit CRTL+C to exit");
        Gate gate = new Gate();
        new UserThread(gate, "Alice", "Alaska").start();
        new UserThread(gate, "Bobby", "Brazil").start();
        new UserThread(gate, "Chris", "Canada").start();
    }

}

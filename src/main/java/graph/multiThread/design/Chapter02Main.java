package graph.multiThread.design;

import graph.multiThread.design.chapter01.EaterThread;
import graph.multiThread.design.chapter01.Gate;
import graph.multiThread.design.chapter01.Tool;
import graph.multiThread.design.chapter01.UserThread;
import graph.multiThread.design.chapter02.Person;
import graph.multiThread.design.chapter02.PrintPersonThread;

/**
 * @author hzzhou
 * @since 2022-05-23
 */
public class Chapter02Main {

    public static void main(String[] args) {
        Person alice = new Person("Alice", "Alaska");
        new PrintPersonThread(alice).start();
        new PrintPersonThread(alice).start();
        new PrintPersonThread(alice).start();
    }

}

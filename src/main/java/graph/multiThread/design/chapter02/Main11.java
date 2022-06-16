package graph.multiThread.design.chapter02;

/**
 * @author hzzhou
 * @since 2022-06-15
 */
public class Main11 {
    //习题2-3
    private static final long Call_count = 1000000000L;

    public static void main(String args[]) {
        trial("NotSynch", Call_count, new NotSynch());
        trial("Synch", Call_count, new Synch());
    }

    private static void trial(String msg, long count, Object obj) {
        System.out.println(msg + " : begin");
        long start_time = System.currentTimeMillis();
        for (long i = 0; i < count; i++) {
            obj.toString();
        }
        System.out.println(msg + " : end");
        System.out.println("Elapsed time =" + (System.currentTimeMillis() - start_time) + " msec.");
    }
}

class NotSynch {
    private final String name = "NotSynch";

    public String toString() {
        return "[" + name + "]";
    }
}

class Synch {
    private final String name = "NotSynch";

    public synchronized String toString() {
        return "[" + name + "]";
    }
}

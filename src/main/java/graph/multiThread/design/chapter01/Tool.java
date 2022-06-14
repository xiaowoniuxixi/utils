package graph.multiThread.design.chapter01;

/**
 * @author hzzhou
 * @since 2022-06-14
 */
public class Tool {
    private final String name;

    public Tool(String name) {
        this.name = name;
    }

    public String toString() {
        return "[ " + name + " ]";
    }
}

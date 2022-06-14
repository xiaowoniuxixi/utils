package nettyStudy;

/**
 * @author hzzhou
 * @since 2021-12-09
 */
public class EchoClient {
    private final String host;
    private final int port;
    private final int sendNumber;

    public EchoClient(String host, int port, int sendNumber) {
        this.host = host;
        this.port = port;
        this.sendNumber = sendNumber;
    }

    public void run() throws Exception {
//        EventLoopGroup group = new NioEventLoopGroup();

    }
}

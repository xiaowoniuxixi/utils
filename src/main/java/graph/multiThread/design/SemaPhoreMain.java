package graph.multiThread.design;

import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 * @author hzzhou
 * @since 2022-06-09
 */

class Log {
    public static void println(String s) {
        System.out.println(Thread.currentThread().getName() + ":" + s);
    }
}

class BoundedResource {
    private final Semaphore semaphore;
    private final int permints;
    private final static Random random = new Random(314159);

    public BoundedResource(int permints) {
        this.semaphore = new Semaphore(permints);
        this.permints = permints;
    }
    public void ues() throws InterruptedException {
        semaphore.acquire();
        try {
            doUse();
        } finally {
            semaphore.release();
        }
    }
    protected void doUse() throws InterruptedException {
        Log.println("Begin: used = " + (permints - semaphore.availablePermits()));
        Thread.sleep(random.nextInt(500));
        Log.println("End: used = " + (permints - semaphore.availablePermits()));

    }
}

class UserThread extends Thread {
    private final static Random random = new Random(26535);
    private final BoundedResource resource;

    public UserThread(BoundedResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        try {
            while (true) {
                resource.ues();
                Thread.sleep(random.nextInt(3000));
            }
        } catch (InterruptedException e) {

        }
    }
}

public class SemaPhoreMain {
    public static void main(String args[]) {
        BoundedResource resource = new BoundedResource(3);
        for (int i = 0; i < 10; i++) {
            new UserThread(resource).start();
        }
    }

}

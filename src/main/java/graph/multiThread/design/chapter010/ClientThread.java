package graph.multiThread.design.chapter010;

/**
 * @author hzzhou
 * @since 2022-05-23
 */
public class ClientThread extends Thread {
    private Bank bank;

    public ClientThread (Bank bank) {
        this.bank = bank;
    }

    public void run() {
        while (true) {
            boolean ok = bank.withdraw(1000);
            if (ok) {
                bank.deposit(1000);
            }
        }
    }
}

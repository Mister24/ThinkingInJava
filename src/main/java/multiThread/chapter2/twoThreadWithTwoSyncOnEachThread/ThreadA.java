package multiThread.chapter2.twoThreadWithTwoSyncOnEachThread;

/**
 * @author mr.24
 * @version Id: ThreadA, v 1.0 2019-06-16 15:35 Exp $$
 */
public class ThreadA extends Thread {
    private HasSelfPrivateNum numRef;

    public ThreadA(HasSelfPrivateNum numRef) {
        super();
        this.numRef = numRef;
    }

    @Override
    public void run() {
        super.run();
        numRef.add("a");
    }
}

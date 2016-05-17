package multhithreading;

/**
 * What the fundamental differences are between a synchronized block and a synchronized method?
 */
public class MethodSyncVsBlockSync {

    public static void main(String args[]) {

    }

    /**
     * someMethodA and someMethodB are the same! The synch in methodB is on this, in methodA it's
     * eventually the same, the sleeping in done on object instance.
     *
     * PROBLEM: synchronizing on this because that would allow everybody from the outside who had a reference to
     * that object to block my synchronization. Instead, create local synchronization object (couple of paragraph later)
     */
    public synchronized void someMethodA() {
        // ...code here
    }

    public void someMethodB() {
        synchronized (this) {
            // ...code here
        }
    }

    /**
     * With synchronized block you can choose what to synchronize on.
     * Local sync object:
     */
    private final Object syncObjectWithData = new Object();

    public void getCount() {
        synchronized (syncObjectWithData) {
            // ...code here
        }
    }
}
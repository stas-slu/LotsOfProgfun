package multhithreading;

/**
 * Example from here:
 *
 * http://www.tutorialspoint.com/java/java_thread_synchronization.htm
 */
public class ThreadStas {

    public static void main(String args[]) {

        PrintDemo pd = new PrintDemo();

        ThreadExample thread1 = new ThreadExample( "Thread - 1 ", pd );
        ThreadExample thread2 = new ThreadExample( "Thread - 2 ", pd );

        thread1.start();
        thread2.start();

        // wait for threads to end
        try {
            thread1.join();
            thread2.join();
        } catch( Exception e) {
            System.out.println("Interrupted");
        }
    }
}

class PrintDemo {
    public void printCount(){
        try {
            for(int i = 5; i > 0; i--) {
                System.out.println("Counter   ---   "  + i );
            }
        } catch (Exception e) {
            System.out.println("Thread  interrupted.");
        }
    }

}

class ThreadExample extends Thread {
    private Thread t;
    private String threadName;
    PrintDemo printer;

    ThreadExample(String name, PrintDemo printer){
        threadName = name;
        this.printer = printer;
    }

    /**
     * It's the unsynchronized version. Each time the print will be in different order.
     */
    @Override
    public void run() {
        printer.printCount();
        System.out.println("Thread " +  threadName + " exiting.");
    }

    /**
     * It's the synchronized version. Each time the print will be in same order.
     */
    /*@Override
    public void run() {
        synchronized(printer) {
            printer.printCount();
        }
        System.out.println("Thread " +  threadName + " exiting.");
    }*/

    @Override
    public void start ()
    { //this is the part that starts the thread with the Runnable
        System.out.println("Starting " +  threadName );
        if (t == null)
        {
            t = new Thread (this, threadName);
            t.start ();
        }
    }

}


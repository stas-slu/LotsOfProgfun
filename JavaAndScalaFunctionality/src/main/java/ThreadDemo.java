public class ThreadDemo implements Runnable {

    Thread thread;

    ThreadDemo() {
        thread = new Thread(this);

        // this will call run() function
        thread.start();
    }

    public void run() {
        // returns the context ClassLoader for this Thread
        ClassLoader c = thread.getContextClassLoader();

        // sets the context ClassLoader for this Thread
        thread.setContextClassLoader(c);
        System.out.println("Class = " + c.getClass());
        System.out.println("Parent = " + c.getParent());

        Thread.currentThread().getContextClassLoader().getResource("");
    }

    public static void main(String args[]) {
        new ThreadDemo();
    }
} 
package basicjava;

public class FinalizeAndFinallyExamples {

    public static void main(String[] args) {
        for(int i=1; i <= 3; i++) {
            startNewThread();
        }
    }

    private static void startNewThread() {
        new Thread(new FinalizeAndFinallyRunnable()).start();
    }
}

class FinalizeAndFinallyRunnable implements Runnable {

    private void blockTryCatchFinally() throws InterruptedException {
        try {
            System.out.println("Now in try block...");
            throw new NullPointerException();
        } catch (NullPointerException npe) {
            System.out.println("Now in catch block...");
        } finally {
            System.out.println("Now in FINALLY block...");
        }
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Now in FINALIZE block..."); //Never called!
        super.finalize();
    }

    @Override
    public void run() {
        try {
            blockTryCatchFinally();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
package queues;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{

    private BlockingQueue<Message> queue;

    public Consumer(BlockingQueue<Message> q){
        this.queue=q;
    }

    @Override
    public void run() {
        try{
            Message msg;
            //consuming messages until exit message is received
            while(!Objects.equals((msg = queue.take()).getMsg(), "exit")){
                Thread.sleep(10);
                System.out.println("Consumed "+msg.getMsg());
            }
            if(msg.equals("exit")) {
                System.out.println("Exit message!");
            }
        }catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}
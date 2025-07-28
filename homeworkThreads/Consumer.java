package homeworkThreads;
import java.util.LinkedList;

public class Consumer implements Runnable {
    LinkedList<Integer> items;

    public Consumer(LinkedList<Integer> items) {
        this.items = items;
    }

    public boolean isEmpty(){
        if (items.size() == 0){
            return true;
        }
        return false;
    }

    // Don’t forget adding synchronized (items) block
    public synchronized void consume() throws InterruptedException {
        // It should wait when list is empty
        while (this.isEmpty() == false) {
            int val = items.removeFirst();
            // After consuming it should notify producer
            notifyAll();
            System.out.println("Consumer consumed - " + val);
            Thread.sleep(1000);
        }
        wait();
    }

    @Override
    public void run(){
        try {
            this.consume();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("This code is running in a consumer - thread");
        
    }
}


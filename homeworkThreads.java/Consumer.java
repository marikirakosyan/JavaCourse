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
    public void consume() throws InterruptedException {
        while (true){
        synchronized(items){
            // It should wait when list is empty
            // list is nogt empty
            if (this.isEmpty() == true) {
                items.wait();
                
            }
        int val = items.removeFirst();
        System.out.println("Consumer consumed - " + val);
        // After consuming it should notify producer
        items.notifyAll();

        Thread.sleep(1000);
        
        }
        
   
    }
    
    }

    // The consumer thread calls consumer.consume() method.
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


package homeworkThreads;

import java.util.LinkedList;

public class Producer implements Runnable{
    LinkedList<Integer> items;
    int capacity = 5;

    public Producer(LinkedList<Integer> items) {
        this.items = items;
    }

    public boolean capacity(){
        if(items.size() >= capacity){
            return false;
        }
        return true;
    }

    // It should wait when list.size is at capacity. 
    // Don’t forget about adding synchronized (items) block
    public synchronized void produce() throws InterruptedException {
        int value = 0;
        while (capacity() != false) {
            System.out.println("Producer produced - " + value);
            items.add(value++);
            // After adding in a list it should notify consumer.
            notifyAll();
            Thread.sleep(1000);
        }
        wait();
        
    }


    @Override
    public void run(){
        try {
            this.produce();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("This code is running in a producer - thread");
        
    }

}

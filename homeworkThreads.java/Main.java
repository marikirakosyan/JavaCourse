package homeworkThreads;

import java.util.LinkedList;

public class Main implements Runnable{

    public static void main(String[] args) {

        // Create a new LinkedList in main method
        LinkedList<Integer> linkedList = new LinkedList<>();
        // making 
        linkedList.add(100);
        linkedList.add(50);
        linkedList.add(20);
        linkedList.add(10);
        linkedList.add(2);

        System.out.println(linkedList);
        

        // Create producer and consumer and pass the same list you have created
        Producer p = new Producer(linkedList);
        Consumer c = new Consumer(linkedList);

        // Create 2 threads one for consumer and one for producer
        // we create thread , its to execute for the producer and consumer
        // it creates an instance of the object thread wich takes an instance of what is should run for
        Thread pT = new Thread(p);
        Thread cT= new Thread(c);
       
        // Start both threads.
        cT.start();
        pT.start();
        

    }

    @Override
    public void run(){
        System.out.println("This code is running in a thread");
    }


    
}

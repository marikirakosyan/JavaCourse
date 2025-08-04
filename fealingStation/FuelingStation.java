import java.util.ArrayList;

public class FuelingStation{
    // fealing station amount
    int fuelAmount = 100;
    Object lock = new Object();

    public FuelingStation(){
        
    }
    
    // Print meaningful log messages for each action
    // Use synchronized keyword (can be method-level or block-level).
   
    // adds fuel (e.g., refilling the station).
    public void addFuel(int amount){
        synchronized(lock){
            fuelAmount += amount;
            lock.notifyAll();
            System.out.println("have successfully added fuel! Fuel amount left: "+ fuelAmount);
        }

    }

    public void consumeFuel(int amount) throws InterruptedException {
        // Only allow refueling if enough fuel is available.

        synchronized(lock){
            if(fuelAmount<amount){
                System.out.println("waiting, fuel amount is: "+ fuelAmount);
                lock.wait(); // the object you have synchronised is the one you wait for

            }
            fuelAmount-= amount;

             // successful
            System.out.println("have successfully consumed! Fuel amount left: "+ fuelAmount);
       
        }


    }

    public static void main(String[] args) throws InterruptedException { 
        FuelingStation fs = new FuelingStation();
        // this is the main thread
        // new and implement right away
        // anonym. inner class, cannot throw with anonym. inner class
        Thread t1 = new Thread(new Runnable() {
            public void run(){
                try {
                    fs.consumeFuel(50);
                    fs.consumeFuel(1000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
                    
        });

        t1.start();

        Thread.sleep(1000);

        new Thread(new Runnable() {

            @Override
            public void run() {
               fs.addFuel(1);
               fs.addFuel(1000);
            }
            
        } ) .start(); // we make new and start the thread all at once

    
    }


}
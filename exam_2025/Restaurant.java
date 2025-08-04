package exam_2025;

public class Restaurant {
    myCollection<Table> resTables = new myCollection<>(15); // making a list of all 15 tables
    myCollection<Employee> employees = new myCollection<>(25);

    public Restaurant(){
        for( int i = 0; i<= 14;i++){
            Table t = new Table(i+4); // just making a suggested amount of seats here
            resTables.insert(t); // since it is set 15 tables in restaurant , we go forward with creating these tables and setting in the restuarant from beggining
        }

    }

    public Waiter findLeastBusy(boolean isWineWaiter){
        Waiter minServWaiter = null;
        int minGuestServ= Integer.MAX_VALUE; // the largest integer possible // could have written 25 * 10 , most tables waiter can serve
        for(Employee e : employees){
            if(!(e instanceof Waiter)){
                continue;
            }
            if(isWineWaiter && !(e instanceof WineWaiter)){
                continue;
            }
        }

        return minServWaiter;
    }


    /* 
    // commenting this out for the sake of threads task

    public void receiveGuests(GuestGroup group){
        // find an available group with enough seats
        Table availableTable = null;
        for(Table t: resTables){
            if(!(t.inUse)){
                availableTable = t;
                t.inUse= true;
            }
        
        // find the waiter that has the least to do, find the right waiter- wine waiter if someone wants wine
        // wants wine
        if(availableTable.gg.someoneWantsWine()){
            Waiter w =  findLeastBusy(true);
        }
        // does not want wine
        Waiter w = findLeastBusy(false);


        availableTable.gg = group;
        availableTable.waiter = w;
        
        }
    }

    */

    public void threadsRecieveGuest(GuestGroup group)throws InterruptedException{
        // if not any tables available with enough spots
        for(Table t: resTables){
            synchronized(t){
            while(((t.inUse) || group.size()>t.seats) ){
                // not enough seats at table - condition
                t.wait(); // jumps out of synchronized??

            }
            t.inUse = true;
            t.notifyAll();
            
        
            }
        Thread.sleep(1000);
        }
        
    }

    public void releaseTable(Table table){
        table.inUse = false;
        table.gg = null;

    }



    
    

}

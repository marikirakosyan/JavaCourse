package exam_2025;

public class RestaurantMonitor {
    myCollection<Table> resTables = new myCollection<>(15); // making a list of all 15 tables
    myCollection<Employee> employees = new myCollection<>(25);

    public RestaurantMonitor(){
        for( int i = 0; i<= 14;i++){
            Table t = new Table(i+4); // just making a suggested amount of seats here
            resTables.insert(t); // since it is set 15 tables in restaurant , we go forward with creating these tables and setting in the restuarant from beggining
        }

    }

    public Waiter findLeastBusy(boolean isWineWaiter){
        Waiter minServWaiter = null;
        int minGuestServ= Integer.MAX_VALUE; // the largest integer possible // could have written 25 * 10 , most tables waiter can serve
        for(Employee e : employees){
            // filtering out here with if and continue for those options that are not relevant
            if(!(e instanceof Waiter)){
                continue;
            }
            if(isWineWaiter && !(e instanceof WineWaiter)){
                continue;
            }
            // we cast , we know for sure here that it is a waiter bc or else it would have continues
            Waiter w = (Waiter) e; // casting synthax
            int servingGuests = w.numGuestServing();
            if (servingGuests < minGuestServ){
                minGuestServ = servingGuests;
                minServWaiter = w;
            }
        }

        return minServWaiter;
    }


    
    // commenting this out for the sake of threads task

    public Table receiveGuests(GuestGroup group){
        // find an available group with enough seats
        Table availableTable = null;
        for (Table t : resTables) {
            if (t != null && !t.inUse && t.seats >= group.size()) {
                availableTable = t;
            }
        }
            
        
        // find the waiter that has the least to do, find the right waiter- wine waiter if someone wants wine
        // wants wine
     
        Waiter w =  findLeastBusy(availableTable.gg.someoneWantsWine());
       
        availableTable.gg = group;
        availableTable.waiter = w;
        availableTable.inUse = true;

        w.serving.insert(availableTable);

        return availableTable;
        
    }

    
    // what we choose to lock is the monitor - here - this - restaurant
    public synchronized Table threadsRecieveGuest(GuestGroup group)throws InterruptedException{ // this.wait();

        // find an available group with enough seats
        Table availableTable = null;
        while(availableTable == null){
            for (Table t : resTables) {
                if (t != null && !t.inUse && t.seats >= group.size()) {
                    availableTable = t; // if comes to this - when next while occurs will jump out
                }
            }
            // couldnt find an available table
            // have to wait
            if(availableTable == null){
                wait(); // will only go out if wait if notify or notifyAll, when wakes up - goes to while (next line in code to run)
            }
        }
        
        // find the waiter that has the least to do, find the right waiter- wine waiter if someone wants wine
        // wants wine
     
        Waiter w =  findLeastBusy(availableTable.gg.someoneWantsWine());
       
        availableTable.gg = group;
        availableTable.waiter = w;
        availableTable.inUse = true;

        w.serving.insert(availableTable);

        return availableTable;

    }

    public synchronized void releaseTable(Table table){ // notify has to happen in synchronized 
        table.inUse = false;
        table.waiter.serving.remove(table);
        table.waiter = null;
        table.gg = null;

        notifyAll(); // tells waiting threads to wake up.

    }

   
    

}

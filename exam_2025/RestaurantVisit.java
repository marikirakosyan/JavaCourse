package exam_2025;

public class RestaurantVisit implements Runnable {
    Restaurant r;
    GuestGroup gg;
    Table t;
    // registers that table is empty
    public RestaurantVisit(Restaurant r, GuestGroup g){
        this.r = r;
        this.gg = gg;
        
    }

    @Override
    public void run() {
       try {
        r.threadsRecieveGuest(gg);
        //gg.eat;
        r.releaseTable(); // how should i add the table
       } catch (InterruptedException e) {
        e.printStackTrace();
       }
    }
    
}

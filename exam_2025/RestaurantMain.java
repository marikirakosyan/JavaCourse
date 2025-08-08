package exam_2025;

public class RestaurantMain {

    public static void main(String[] args) {
        RestaurantMonitor rm = new RestaurantMonitor(); // our Restaurant
        GuestGroup gg1 = new GuestGroup();
        GuestGroup gg2 = new GuestGroup();

        // we make two threads, to gg wants to enter restaurant with each their own
        // threads : 

        // as we know these are runnable we send in threads that we make
        RestaurantVisit rv1 = new RestaurantVisit(rm, gg1);
        RestaurantVisit rv2 = new RestaurantVisit(rm, gg2);

        rv1.run(); // wont make a new thread, just run in main thread

        Thread t1 = new Thread(rv1);
        Thread t2 = new Thread(rv2);

        t1.start();
        t2.start();


    }

}

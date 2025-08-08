package exam_2025;

import java.util.Iterator;

public class GuestGroup {
    myCollection<Guest> guests = new myCollection(20);

    public boolean someoneWantsWine(){
        Iterator<Guest> it = guests.iterator();
        while(it.hasNext()){
            Guest g = it.next();
            if(g.wantsWine()){
                return true;
            }
        }
        return false;
    }

    public int size(){
        return guests.count();
    }

    public void eat() throws InterruptedException{
        System.out.println("eating...");
        Thread.sleep(1000);
    }
}


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

    public Integer size(){
        int size = 0;
        for(Guest g: guests){
            if(g!= null){
                size++;
            }
        }
        return size;
    }
}


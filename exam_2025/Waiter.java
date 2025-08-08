package exam_2025;

public class Waiter extends Employee {

    // max tables to serve
    myCollection<Table> serving = new myCollection<>(10);

    public int numGuestServing(){
        int guests = 0;
        for(Table t: serving){
            if(t!=null){
               guests += t.gg.guests.count();
            }
        }
        return guests;
    }

    
}

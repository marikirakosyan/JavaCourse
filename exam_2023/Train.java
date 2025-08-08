package exam_2023;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class Train implements Iterable<RailVehicle> {
    private RailVehicle first;
    private RailVehicle last;

    public Train(){
        super();
    }

    public void add(RailVehicle rv) {
        if (last == null) {
            // no first or last
            first = rv;
            last = rv;
        } else {
            // appends using last
            last.next = rv;
            rv.prev= last;
            last = rv;
        }

    }

    public RailVehicle remove(RailVehicle rv){
        RailVehicle current = first;
        while(current != last){
            if(current == rv){ // we put != null first to avoid nullpointerexpetrion while checking current.data.equals(ref) 
                RailVehicle next = current.next;
                RailVehicle prev = current.prev;
                if(next != null){
                    next.prev = prev;
                }else{
                    // last element
                    last = prev;
                }
                if(prev != null){
                    prev.next = next;
                }else{
                    // first element
                    first = next;
                }

                return current;
                
            }

            current = current.next;
        }
        return null;

    }

    public RailVehicle findAndRemove(String id){
        // to find wich object has the specific id , i have to iterate over all of the object and find the specific one
        RailVehicle current = first;
        while(current != last){
            if(current.id == id){ // we put != null first to avoid nullpointerexpetrion while checking current.data.equals(ref) 
                RailVehicle next = current.next;
                RailVehicle prev = current.prev;
                if(next != null){
                    next.prev = prev;
                }else{
                    // last element
                    last = prev;
                }
                if(prev != null){
                    prev.next = next;
                }else{
                    // first element
                    first = next;
                }
                return current;
            }
            current = current.next;
        }

        return null;

    }

    public void insertBefore(RailVehicle existing, RailVehicle newRv) {
        RailVehicle current = first;
        while (current != null && current != last) {
            if (current == existing) {
                if (current.prev != null) {
                    current.prev.next = newRv;
                }else{
                    first = newRv;
                }
                newRv.next = current;
                newRv.prev = current.prev;
                current.prev = newRv;

            }
            current = current.next;
        }

    }

    public PassengerWagon[] getPassengerWagons(){
        int count = 0;
        for(RailVehicle r : this) {
            // we count here to know how large arraylist to make
            if (r instanceof PassengerWagon){
                count++;
            }
        }
        // declaring Array with chosen amount 
        int index = 0;
        PassengerWagon[] passengerWagons = new PassengerWagon[count];
        for(RailVehicle r : this) {
            // we count here to know how large arraylist to make
            if (r instanceof PassengerWagon){
                // when Arrays always choose index to insert on
                passengerWagons[index] = (PassengerWagon)r; // we cast down 
                index++; 
            }
        }
        return passengerWagons;
    }

    public void checkGauge() throws InvalidGaugeException {
        if (first == null) return; 
        // iterates over train to check that every vehicles getTrackGauge() matches the
        // first
        for (RailVehicle rv : this) {

            // if wrong boolean we throw exception
            if (first.getTrackGauge() != rv.getTrackGauge()) {
                throw new InvalidGaugeException();
            }

        }

    }


    public void addSafe(RailVehicle rv) throws InvalidGaugeException{
        if (first == null) return; 
        try{
            add(rv);
            checkGauge();

        }catch(InvalidGaugeException e){
            System.out.println("can not add safely!");
            remove(rv);
        }
        
    }

    public void recCheckGauge(){
        if (first == null) return; 
    }

    
    @Override
    public Iterator<RailVehicle> iterator() {
        // iterable interface forces us to implement iterator(), that has to override hasNext and next wich is implemented by reurning an iterator
        return new Iterator<RailVehicle>() {

            RailVehicle current = first;
            

            @Override
            public boolean hasNext() {
                // next should check if current == null
                return current != null;
                // now we know that we can return this
            }

            @Override
            public RailVehicle next() {
                if (!hasNext()) throw new NoSuchElementException();
                RailVehicle v = current;  // ta vare på nåværende
                current = current.next;   // flytt pekeren
                return v;                 // returner
            }
            
        };
    }


}



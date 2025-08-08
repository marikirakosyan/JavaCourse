package exam_2023;

public abstract class RailVehicle { // assuming abstraction here
    String id;
    int trackGauge;
    RailVehicle next;
    RailVehicle prev;

    public RailVehicle(String id,int trackGauge){
        this.id = id;
        this.trackGauge = trackGauge;

    }

    public String getId(){ // returns unique identifier
        return id;
    }

    public int getTrackGauge() { // returns track size
        return trackGauge;
    }
    
}

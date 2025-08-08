package exam_2023;

public class PassengerWagon extends RailCar{
    int maxPassengers;
    public PassengerWagon(String id, int trackGauge,int lengthCm,int maxPassengers){
        super(id,trackGauge,lengthCm);
        this.maxPassengers = maxPassengers;
    }
}

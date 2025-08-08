package exam_2023;


public abstract class RailCar extends RailVehicle { // are either FreightWagon or PassengerWagon

    int lengthCm; 

    public RailCar(String id, int trackGauge,int lengthCm1){
        super(id,trackGauge);
        this.lengthCm = lengthCm1;
    }
}

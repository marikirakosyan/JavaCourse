package exam_2023;

public class FreightWagon extends RailCar{
    double maxLoadKg;
    public FreightWagon(String id, int trackGauge,int lengthCm,double maxLoadKg){
        super(id,trackGauge,lengthCm);
        this.maxLoadKg = maxLoadKg;
    }
}

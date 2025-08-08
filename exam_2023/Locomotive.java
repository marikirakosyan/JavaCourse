package exam_2023;

public class Locomotive extends RailVehicle implements MotorPower{
    boolean usesFossilFuel;
    int getPower;

    public Locomotive(String id, int trackGauge,boolean usesFossilFuel, int getPower){
        super(id,trackGauge);
        this.usesFossilFuel = usesFossilFuel;
        this.getPower = getPower;
    }

    public boolean usesFossilFuel(){
        return usesFossilFuel;
    }

    public int getPower(){
        return getPower;
    }
}


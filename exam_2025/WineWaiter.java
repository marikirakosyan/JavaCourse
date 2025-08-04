package exam_2025;

public class WineWaiter extends Waiter implements Sommelier{
    @Override
    public String specialty(){
        return "WINE";
    }
}

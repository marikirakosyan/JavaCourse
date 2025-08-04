package exam_2025;

public class Table {
    int seats;
    // When a table is in use, it should have a reference to the GuestGroup seated there and to the Waiter serving them.
    boolean inUse;
    GuestGroup gg;
    Waiter waiter;


    public Table(int seats){
        this.seats = seats;
    }




}

package MovieTicket;

public class TicketCounter {
    int available= 5;

    public TicketCounter(){

    }

    public synchronized void bookTicket() {
        if (available > 0){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            available--;
            System.out.println("here is your tickets, remaining tickets: "+ (available+ 1));
        }else{
            System.out.println("no more available tickets!");
        }
    }

    public static void main(String[] args) {
        TicketCounter tc= new TicketCounter();

        for(int i = 0; i <= 9; i++){
            Thread t = new Thread(new Runnable()
            {
                @Override // implementing an interface and overriding the run
                public void run() {
                    // TODO Auto-generated method stub
                    tc.bookTicket();
                }
                
            });

            t.start();
        }

    }
    
}

class Printer{
    public synchronized void print(String user, int copyNo){
        System.out.println(user+" Using the Printer, No of copy: "+copyNo);
    }
}

class Users extends  Thread{
    Printer printer;
    int noOfCopies;

    Users(Printer printer, int noOfCopies){
        this.printer=printer;
        this.noOfCopies=noOfCopies;
    }

    @Override
    public void run(){
        for (int i=1; i<=noOfCopies; i++) {
            printer.print(Thread.currentThread().getName(), i);
            try {
                sleep(250);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

public class PrinterExample1 {
    public static void main(String[] args) {
        Printer printer = new Printer();

        Users user1 = new Users(printer, 20);
        Users user2 = new Users(printer, 20);
        Users user3 = new Users(printer, 20);

        user1.setName("Alya");
        user2.setName("Radhika");
        user3.setName("Mr. Kulkarni");

        user1.start();
        user2.start();
        user3.start();

        try {
            user1.join();
            user2.join();
            user3.join();
        } catch (InterruptedException e) {
            System.err.println("[Error] Thread interrupted: " + e.getMessage());
        }
    }
}

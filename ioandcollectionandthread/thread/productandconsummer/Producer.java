package thread.productandconsummer;

public class Producer implements Runnable{
    private Box b;
    @Override
    public void run() {
        for (int i =1; i<=30; i++){
            b.put(i);
        }
    }
    public Producer(Box b){
        this.b = b;
    }
}

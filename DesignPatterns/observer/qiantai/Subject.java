package observer.qiantai;

public interface Subject {
    public void Attch(Observer observer);
    public void Detach(Observer observer);
    public void Notify();


}

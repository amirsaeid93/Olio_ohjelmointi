import java.util.ArrayList;
import java.util.List;

public class ThreadSafeArrayList<T> {
    private final List<T> list = new ArrayList<>();


    public synchronized void addElement(T element) {
        list.add(element);
        System.out.println(Thread.currentThread().getName() + " added: " + element);
    }


    public synchronized int getSize() {
        return list.size();
    }


    public synchronized boolean removeElement(T element) {
        boolean removed = list.remove(element);
        if (removed) {
            System.out.println(Thread.currentThread().getName() + " removed: " + element);
        } else {
            System.out.println(Thread.currentThread().getName() + " failed to remove: " + element);
        }
        return removed;
    }
}
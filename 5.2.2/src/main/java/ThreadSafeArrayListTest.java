public class ThreadSafeArrayListTest {
    public static void main(String[] args) {
        ThreadSafeArrayList<String> threadSafeList = new ThreadSafeArrayList<>();


        Thread t1 = new Thread(() -> {
            threadSafeList.addElement("Element1");
            threadSafeList.addElement("Element2");
            System.out.println(Thread.currentThread().getName() + " size: " + threadSafeList.getSize());
        });

        Thread t2 = new Thread(() -> {
            threadSafeList.addElement("Element3");
            threadSafeList.removeElement("Element1");
            System.out.println(Thread.currentThread().getName() + " size: " + threadSafeList.getSize());
        });

        Thread t3 = new Thread(() -> {
            threadSafeList.addElement("Element4");
            threadSafeList.removeElement("Element5");
            System.out.println(Thread.currentThread().getName() + " size: " + threadSafeList.getSize());
        });


        t1.start();
        t2.start();
        t3.start();


        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Final size of the list: " + threadSafeList.getSize());
    }
}
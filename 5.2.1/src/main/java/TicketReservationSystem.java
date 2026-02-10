import java.util.Random;

class Theater {
    private int availableSeats;

    public Theater(int totalSeats) {
        this.availableSeats = totalSeats;
    }

    public synchronized boolean reserveSeats(int customerId, int seatsRequested) {
        if (seatsRequested <= availableSeats) {
            availableSeats -= seatsRequested;
            System.out.println("Customer " + customerId + " reserved " + seatsRequested + " tickets.");
            return true;
        } else {
            System.out.println("Customer " + customerId + " couldn't reserve " + seatsRequested + " tickets.");
            return false;
        }
    }
}

class Customer implements Runnable {
    private final Theater theater;
    private final int customerId;

    public Customer(Theater theater, int customerId) {
        this.theater = theater;
        this.customerId = customerId;
    }

    @Override
    public void run() {
        Random random = new Random();
        int seatsRequested = random.nextInt(4) + 1;
        theater.reserveSeats(customerId, seatsRequested);
    }
}

public class TicketReservationSystem {
    public static void main(String[] args) {
        int totalSeats = 10;
        Theater theater = new Theater(totalSeats);

        int totalCustomers = 15;
        Thread[] customerThreads = new Thread[totalCustomers];

        for (int i = 0; i < totalCustomers; i++) {
            customerThreads[i] = new Thread(new Customer(theater, i + 1));
            customerThreads[i].start();
        }

        for (Thread thread : customerThreads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("All customers have attempted to reserve tickets.");
    }
}
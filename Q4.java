class Ticket {
    private int ticketNumber;
    private String customerName;
    private int seatNumber;

    public Ticket(int ticketNumber, String customerName, int seatNumber) {
        this.ticketNumber = ticketNumber;
        this.customerName = customerName;
        this.seatNumber = seatNumber;
    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public String toString() {
        return "TicketNumber: " + ticketNumber + ", Customer: " + customerName + ", Seat: " + seatNumber;
    }
}

class BookingSystem {
    private Ticket[] tickets;
    private final int MAX_SEATS = 10;

    public BookingSystem() {
        tickets = new Ticket[MAX_SEATS];
    }

    public boolean bookTicket(int ticketNumber, String customerName, int seatNumber) {
        if (seatNumber < 1 || seatNumber > MAX_SEATS) {
            System.out.println("Invalid seat number. Seat must be between 1 and 10.");
            return false;
        }
        if (tickets[seatNumber - 1] != null) {
            System.out.println("Seat " + seatNumber + " is already booked.");
            return false;
        }
        tickets[seatNumber - 1] = new Ticket(ticketNumber, customerName, seatNumber);
        System.out.println("Ticket booked for " + customerName + " at seat " + seatNumber + ".");
        return true;
    }

    public boolean cancelTicket(int ticketNumber) {
        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i] != null && tickets[i].getTicketNumber() == ticketNumber) {
                System.out.println("Cancelling ticket #" + ticketNumber + " at seat " + tickets[i].getSeatNumber());
                tickets[i] = null;
                return true;
            }
        }
        System.out.println("Ticket number " + ticketNumber + " not found.");
        return false;
    }

    public void displayBookings() {
        System.out.println("Current Bookings:");
        boolean hasBookings = false;
        for (Ticket ticket : tickets) {
            if (ticket != null) {
                System.out.println(ticket);
                hasBookings = true;
            }
        }
        if (!hasBookings) {
            System.out.println("No tickets booked.");
        }
    }
}

class CinemaBookingApp {
    public static void main(String[] args) {
        BookingSystem system = new BookingSystem();

        system.bookTicket(1, "Alice", 1);
        system.bookTicket(2, "Bob", 2);
        system.bookTicket(3, "Charlie", 3);

        system.cancelTicket(2);
		
        system.bookTicket(4, "David", 2);
		
        system.displayBookings();
    }
}
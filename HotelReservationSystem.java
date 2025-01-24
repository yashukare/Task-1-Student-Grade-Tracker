import java.util.*;

class Room {
    int roomNumber;
    String category;
    boolean isAvailable;

    public Room(int roomNumber, String category) {
        this.roomNumber = roomNumber;
        this.category = category;
        this.isAvailable = true;
    }

    @Override
    public String toString() {
        return "Room Number: " + roomNumber + ", Category: " + category + ", Available: " + isAvailable;
    }
}

class Reservation {
    int reservationId;
    String guestName;
    int roomNumber;
    String category;
    double amountPaid;

    public Reservation(int reservationId, String guestName, int roomNumber, String category, double amountPaid) {
        this.reservationId = reservationId;
        this.guestName = guestName;
        this.roomNumber = roomNumber;
        this.category = category;
        this.amountPaid = amountPaid;
    }

    @Override
    public String toString() {
        return "Reservation ID: " + reservationId + "\nGuest Name: " + guestName + "\nRoom Number: " + roomNumber +
                "\nCategory: " + category + "\nAmount Paid: $" + amountPaid;
    }
}

public class HotelReservationSystem {
    private static List<Room> rooms = new ArrayList<>();
    private static List<Reservation> reservations = new ArrayList<>();
    private static int reservationCounter = 1;

    public static void main(String[] args) {
        initializeRooms();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Hotel Reservation System ===");
            System.out.println("1. View Available Rooms");
            System.out.println("2. Make a Reservation");
            System.out.println("3. View Reservations");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    viewAvailableRooms();
                    break;
                case 2:
                    makeReservation(scanner);
                    break;
                case 3:
                    viewReservations();
                    break;
                case 4:
                    System.out.println("Thank you for using the Hotel Reservation System!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void initializeRooms() {
        rooms.add(new Room(101, "Single"));
        rooms.add(new Room(102, "Single"));
        rooms.add(new Room(201, "Double"));
        rooms.add(new Room(202, "Double"));
        rooms.add(new Room(301, "Suite"));
        rooms.add(new Room(302, "Suite"));
    }

    private static void viewAvailableRooms() {
        System.out.println("\nAvailable Rooms:");
        boolean availableFound = false;
        for (Room room : rooms) {
            if (room.isAvailable) {
                System.out.println(room);
                availableFound = true;
            }
        }
        if (!availableFound) {
            System.out.println("No rooms available.");
        }
    }

    private static void makeReservation(Scanner scanner) {
        System.out.println("\nEnter your name: ");
        String guestName = scanner.nextLine();

        System.out.println("Enter room category (Single, Double, Suite): ");
        String category = scanner.nextLine();

        Room availableRoom = null;
        for (Room room : rooms) {
            if (room.isAvailable && room.category.equalsIgnoreCase(category)) {
                availableRoom = room;
                break;
            }
        }

        if (availableRoom == null) {
            System.out.println("No available rooms in the selected category.");
            return;
        }

        System.out.println("Enter payment amount: ");
        double amountPaid = scanner.nextDouble();

        availableRoom.isAvailable = false;
        Reservation reservation = new Reservation(reservationCounter++, guestName, availableRoom.roomNumber, category,
                amountPaid);
        reservations.add(reservation);

        System.out.println("Reservation successful! Your details:");
        System.out.println(reservation);
    }

    private static void viewReservations() {
        if (reservations.isEmpty()) {
            System.out.println("\nNo reservations found.");
            return;
        }

        System.out.println("\nReservations:");
        for (Reservation reservation : reservations) {
            System.out.println(reservation);
            System.out.println("-------------------------");
        }
    }
}

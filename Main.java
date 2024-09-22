
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ParkingLot parkingLot = new ParkingLot(10, 10);

        int option;
        System.out.println("***Parking Lot System***");

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Park a Vehicle");
            System.out.println("2. Unpark a Vehicle");
            System.out.println("3. Display Occupied Slots");
            System.out.println("4. Display Open Slots");
            System.out.println("5. Relocation of vehicle");
            System.out.println("6. EXIT");
            System.out.print("Choose an option (1-6): ");
            option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    System.out.print("Enter vehicle type (car/truck/bike): ");
                    String vehicleType = scanner.nextLine().toLowerCase();
                    System.out.print("Enter vehicle registration number: ");
                    String registrationNumber = scanner.nextLine();
                    System.out.print("Enter owner name: ");
                    String ownerName = scanner.nextLine();

                    String ticket = parkingLot.parkVehicle(registrationNumber, ownerName, vehicleType);
                    System.out.println(ticket);
                    break;

                case 2:
                    System.out.print("Enter vehicle registration number to unpark: ");
                    String regToUnpark = scanner.nextLine();
                    System.out.print("Enter owner's name: ");
                    String ownerToUnpark = scanner.nextLine();
                    parkingLot.unPark(regToUnpark, ownerToUnpark);
                    break;

                case 3:
                    parkingLot.displayOccupiedSlots();
                    break;

                case 4:
                    parkingLot.displayOpenSlots();
                    break;

                case 5:
                    // Relocate a vehicle
                    System.out.print("Enter vehicle registration number to relocate: ");
                    String registrationToRelocate = scanner.nextLine();
                    System.out.print("Enter owner's name: ");
                    String ownerToRelocate = scanner.nextLine();
                    System.out.print("Enter new floor number: ");
                    int newFloor = scanner.nextInt();
                    System.out.print("Enter new slot number: ");
                    int newSlot = scanner.nextInt();
                    parkingLot.relocateVehicle(registrationToRelocate, ownerToRelocate, newFloor, newSlot);
                    break;

                case 6:
                    System.out.println("Exiting Parking Lot System. Thank you!");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }

        } while (option != 6); // Repeat until user chooses to exit

        scanner.close();
    }
}


import java.util.*;

public class ParkingLot {
    private HashMap<String, Vehicle> parkedVehicles;
    private int totalFloors;
    private int totalSlots; // Total slots for all types
    private boolean[][] slots; // [floor][slot]

    public ParkingLot(int floors, int slotsPerFloor) {
        parkedVehicles = new HashMap<>();
        this.totalFloors = floors;
        this.totalSlots = slotsPerFloor;
        this.slots = new boolean[floors][slotsPerFloor]; // Track all slots
    }

    // Park a vehicle
    public String parkVehicle(String registrationNumber, String ownerName, String vehicleType) {
        int assignedFloor = -1;
        int assignedSlot = -1;

        // Find the next available slot across all vehicle types
        for (int floor = 0; floor < totalFloors; floor++) {
            for (int slot = 0; slot < totalSlots; slot++) {
                if (!slots[floor][slot]) {
                    assignedFloor = floor + 1; // 1-indexed
                    assignedSlot = slot + 1; // 1-indexed
                    slots[floor][slot] = true; // Mark slot as occupied
                    break;
                }
            }
            if (assignedSlot != -1)
                break;
        }

        if (assignedFloor == -1 || assignedSlot == -1) {
            return "No available slots for " + vehicleType + ".";
        }

        Vehicle vehicle = new Vehicle(ownerName, vehicleType, registrationNumber, assignedFloor, assignedSlot);
        parkedVehicles.put(generateVehicleKey(registrationNumber, ownerName), vehicle);
        return "Vehicle parked. Ticket: " + registrationNumber + " on Floor " + assignedFloor + " at Slot "
                + assignedSlot;
    }

    // Unpark a vehicle
    public void unPark(String registrationNumber, String ownerName) {
        String key = generateVehicleKey(registrationNumber, ownerName);
        Vehicle vehicle = parkedVehicles.remove(key);

        if (vehicle != null) {
            int floor = vehicle.getFloor() - 1; // Convert to 0-indexed
            int slot = vehicle.getSlot() - 1; // Convert to 0-indexed
            slots[floor][slot] = false; // Mark slot as free
            System.out.println("Vehicle with registration " + registrationNumber + " unparked successfully.");
        } else {
            System.out.println(
                    "No vehicle found with registration number " + registrationNumber + " for owner " + ownerName);
        }
    }

    // Display occupied slots
    public void displayOccupiedSlots() {
        if (parkedVehicles.isEmpty()) {
            System.out.println("No vehicles are currently parked.");
            return;
        }

        System.out.println("Occupied slots:");
        for (Vehicle vehicle : parkedVehicles.values()) {
            System.out.println("Type: " + vehicle.getType() + ", Registration: " + vehicle.getRegNumber() +
                    ", Owner: " + vehicle.getOwnerName() +
                    ", Floor: " + vehicle.getFloor() + ", Slot: " + vehicle.getSlot());
        }
    }

    // Display open slots
    public void displayOpenSlots() {
        int openSlots = 0;

        for (boolean[] floors : slots) {
            for (boolean slot : floors)
                if (!slot)
                    openSlots++;
        }

        System.out.println("Open slots: " + openSlots);
    }

    private String generateVehicleKey(String registrationNumber, String ownerName) {
        return registrationNumber + "-" + ownerName; // Unique key for each vehicle
    }

    // Relocate a vehicle
    public void relocateVehicle(String registrationNumber, String ownerName, int newFloor, int newSlot) {
        String key = generateVehicleKey(registrationNumber, ownerName);
        Vehicle vehicle = parkedVehicles.get(key);

        if (vehicle == null) {
            System.out.println(
                    "No vehicle found with registration number " + registrationNumber + " for owner " + ownerName);
            return;
        }

        int currentFloor = vehicle.getFloor();
        int currentSlot = vehicle.getSlot();

        // Check if the new floor and slot are valid and available
        if (newFloor < 1 || newFloor > totalFloors || newSlot < 1 || newSlot > totalSlots) {
            System.out.println("Invalid floor or slot number.");
            return;
        }

        // Convert to 0-indexed
        newFloor -= 1;
        newSlot -= 1;

        // Check if the new slot is available
        if (slots[newFloor][newSlot]) {
            System.out.println("The new slot is already occupied. Relocation failed.");
            return;
        }

        // Free the current slot
        slots[currentFloor - 1][currentSlot - 1] = false;

        // Update the vehicle's floor and slot
        vehicle.setFloor(newFloor + 1); // Store as 1-indexed
        vehicle.setSlot(newSlot + 1); // Store as 1-indexed

        // Mark the new slot as occupied
        slots[newFloor][newSlot] = true;

        System.out.println("Vehicle relocated to Floor " + vehicle.getFloor() + " at Slot " + vehicle.getSlot());
    }

}
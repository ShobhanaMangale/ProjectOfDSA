

public class Vehicle {
    String ownerName;
    String type;
    String regNumber;
    int floor;
    int slot;

    // Constructor
    public Vehicle(String ownerName, String type, String regNumber, int floor, int slot) {
        this.ownerName = ownerName;
        this.type = type;
        this.regNumber = regNumber;
        this.floor = floor;
        this.slot = slot;
    }

    // Getters and setters for floor and slot
    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

}

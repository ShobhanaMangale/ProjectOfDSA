public class Slot {

    String type;
    Vehicle vehicle;
    String ticketID;// Id for approval of getting a slot

    public Slot(String type) {
        this.type = type;
        this.vehicle = null;
        this.ticketID = null;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public String getTicketID() {
        return ticketID;
    }

    public void setTicketID(String ticketId) {
        this.ticketID = ticketId;
    }

}

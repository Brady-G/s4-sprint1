package brady.green.sprint1.models;

public class AirCraft {

    private final int id;
    private String type;
    private String airline;
    private int passengers;

    public AirCraft(int id, String type, String airline, int passengers) {
        this.id = id;
        this.type = type;
        this.airline = airline;
        this.passengers = passengers;
    }

    public int id() {
        return id;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public int getPassengers() {
        return passengers;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }
}

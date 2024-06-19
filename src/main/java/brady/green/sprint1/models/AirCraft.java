package brady.green.sprint1.models;

public record AirCraft(int id, String type, String airline, int capacity) {

    public AirCraft(int id, Body body) {
        this(id, body.type(), body.airline(), body.capacity());
    }

    public record Body(String type, String airline, int capacity) { }
}

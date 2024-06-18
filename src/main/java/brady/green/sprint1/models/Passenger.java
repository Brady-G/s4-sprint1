package brady.green.sprint1.models;

public record Passenger(int id, String firstName, String lastName, String phoneNumber) {

    public Passenger(int id, Body body) {
        this(id, body.firstName(), body.lastName(), body.phoneNumber());
    }

    public record Body(String firstName, String lastName, String phoneNumber) {
    }
}

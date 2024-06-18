package brady.green.sprint1.models;

public record Route(
    int id,
    int airCraft,
    int startingAirport,
    int endingAirport
) {

    public Route(int id, Body body) {
        this(id, body.airCraft(), body.startingAirport(), body.endingAirport());
    }

    public record Body(
        int airCraft,
        int startingAirport,
        int endingAirport
    ) {
    }
}

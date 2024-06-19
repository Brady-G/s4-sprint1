package brady.green.sprint1.models;

public record Route(
    int id,
    int airCraft,
    int origin,
    int destination
) {

    public Route(int id, Body body) {
        this(id, body.airCraft(), body.origin(), body.destination());
    }

    public record Body(
        int airCraft,
        int origin,
        int destination
    ) {
    }
}

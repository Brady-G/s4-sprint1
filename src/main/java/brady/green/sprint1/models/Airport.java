package brady.green.sprint1.models;

public record Airport(int id, String code, int city, String name) {

    public Airport(int id, Body body) {
        this(id, body.code(), body.city(), body.name());
    }

    public record Body(String code, int city, String name) {
    }
}

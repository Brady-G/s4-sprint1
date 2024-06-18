package brady.green.sprint1.models;

public record City(int id, String name, String state, long population) {

    public City(int id, Body body) {
        this(id, body.name(), body.state(), body.population());
    }

    public record Body(String name, String state, long population) {
    }
}

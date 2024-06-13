package brady.green.sprint1.models;

public class City {

    private final int id;
    private String name;
    private String state;
    private long population;

    public City(int id, String name, String state, long population) {
        this.id = id;
        this.name = name;
        this.state = state;
        this.population = population;
    }

    public int id() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }
}

package brady.green.sprint1.models;

public class Airport {

    private final int id;
    private final String code;
    private final int city;
    private String name;

    public Airport(int id, String code, int city, String name) {
        this.id = id;
        this.code = code;
        this.city = city;
        this.name = name;
    }

    public int id() {
        return id;
    }

    public String code() {
        return code;
    }

    public int city() {
        return city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

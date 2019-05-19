package uieng.businessapplication.service;

public class SomeDTO {
    private final long   id;
    private final String name;

    public SomeDTO(String... args) {
        id   = Long.parseLong(args[0]);
        name = args[1];
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
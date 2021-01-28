package calculadoradivisas.model;

public class Currency {
    private final String id;
    private final String name;
    private final String icon;

    public Currency(String id, String name, String icon) {
        this.id = id;
        this.name = name;
        this.icon = icon;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getIcon() {
        return icon;
    }

    @Override
    public String toString() {
        return id;
    }
    
    
    
}

package calculadoradivisas.model;

public class Currency {
    private final String code;
    private final String name;
    private final String sign;

    public Currency(String code, String name, String sign) {
        this.code = code;
        this.name = name;
        this.sign = sign;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getSign() {
        return sign;
    }

    @Override
    public String toString() {
        return code;
    }
    
    
}

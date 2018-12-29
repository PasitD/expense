public class History {
    private String type;
    private String money;
    private String description;

    public History(String type, String money, String description) {
        this.type = type;
        this.money = money;
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public String getMoney() {
        return money;
    }

    public String getDescription() {
        return description;
    }

}

public class AccountRecord {
    private double money;
    private String description;
    private char symbol;

    public  AccountRecord(double money,String description,char symbol){
        this.money = money;
        this.description = description;
        this.symbol = symbol;
    }

    public double getMoney() {
        return money;
    }

    public String getDescription() {
        return description;
    }

    public char getSymbol() {
        return symbol;
    }
}

import java.util.ArrayList;

public class Account {
    private double balance;
    private double income;
    private double expense;

    ArrayList<AccountRecord> accountRecords = new ArrayList<>();

    public Account(){
        this.balance = 0;
    }

    public Account(double initialMoney){
        this.balance = initialMoney;
    }

    public double getBalance(){
        return balance;
    }

    public void income(double money, String description){
        this.balance += money;
        this.income += money;
        accountRecords.add(new AccountRecord(money,description,'+'));
    }

    public void expense(double money, String description){
        this.balance -= money;
        this.expense -= money;
        accountRecords.add(new AccountRecord(money,description,'-'));
    }

    public String getHistory(){
        String temp = "";
        for(int i=0;i<accountRecords.size();i++){
            temp += accountRecords.get(i).getSymbol() + "" + accountRecords.get(i).getMoney() + " : " + accountRecords.get(i).getDescription() + "\n";

            if(accountRecords.get(i).getSymbol() == '+'){
                income += accountRecords.get(i).getMoney();
            }else{
                expense += accountRecords.get(i).getMoney();
            }
        }
        temp += "\n|Income : " + income +"|"+ "\n|Expense : " + expense +"|";
        return temp;
    }

    public double getIncome() {
        return income;
    }

    public double getExpense() {
        return expense;
    }
}

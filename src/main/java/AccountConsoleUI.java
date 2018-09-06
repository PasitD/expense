import java.util.Scanner;

public class AccountConsoleUI {
    public void start(){
        Account account = new Account();
        Scanner in = new Scanner(System.in);
        boolean process = true;

        while(process!=false){
            System.out.println("<<<Balance = " + account.getBalance()+">>>");
            System.out.println("Menu");
            System.out.print("A = Income, B = Expense, C = History, D = Exit: ");
            String menu = in.next();

            if(menu.equals("a") || menu.equals("A")){
                System.out.print("Income: ");
                double money = in.nextDouble();
                System.out.print("Description: ");
                in.useDelimiter("\n");
                String description = in.next();
                account.income(money, description);
                System.out.println();
            }
            else if(menu.equals("b") || menu.equals("B")){
                System.out.print("Expense: ");
                double money = in.nextDouble();
                System.out.print("Description: ");
                in.useDelimiter("\n");
                String description = in.next();
                account.expense(money, description);
                System.out.println();
            }
            else if(menu.equals("c") || menu.equals("C")){
                System.out.println(account.getHistory());
                System.out.println();
            }
            else if(menu.equals("d") || menu.equals("D")){
                process = false;
            }else{
                System.out.println("You can only input A B C D");
            }
        }
    }
}

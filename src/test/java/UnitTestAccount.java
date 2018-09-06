import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UnitTestAccount {
    Account account;
    double initialBalance = 100;

    @BeforeEach
    void init(){
        account = new Account(initialBalance);
    }

    @Test
    void testIncome(){
        account.income(50, "sell pencil");
        assertEquals(150,account.getBalance());
        assertEquals(50,account.getIncome());

    }

    @Test
    void testExpense(){
        account.expense(100,"buy game");
        assertEquals(0,account.getBalance());
        assertEquals(-100,account.getExpense());
    }


}

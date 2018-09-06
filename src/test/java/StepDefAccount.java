import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StepDefAccount {
    Account account;

    @Before
    public void init(){

        account = new Account();
    }

    @Given("a user have balance (\\d+) exists")
    public void a_user_have_balance_exists(int balance){
        account = new Account(balance);

    }

    @When("I earned (\\d+) from (.*)")
    public void i_earned_from(int income, String desc){
        account.income(income, desc);
    }



    @When("I spend (\\d+) for buy (.*)")
    public void i_spend_for_buy(int expense, String desc){
        account.expense(expense, desc);
    }


    @Then("balance is (.*)")
    public void balance_is_minus(int balance){
        assertEquals(balance, account.getBalance());
    }

}

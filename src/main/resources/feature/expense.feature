Feature: expense
        As a user
        I can add expense to ledger
        so that I can view balance

Scenario: Normal Expense
            Given a user have balance 200 exists
            When I spend 300 for buy egg
            Then balance is -100

#Scenario: Over Expense
#            Given a user have balance 200 exists
#            When I spend 300 over for buy shampoo
#            Then balance is -100.00

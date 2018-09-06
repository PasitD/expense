
Feature: income
      As a user
      I can add income to ledger
      so that I can view balance

Scenario: Normal income
            Given a user have balance 200 exists
            When I earned 100 from work
            Then balance is 300

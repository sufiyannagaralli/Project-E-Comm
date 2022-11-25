
@tag
Feature: Purchase the Order from E-COM Website
  I want to use this template for my feature file

 
  
  Background: 
  Given I  Landed On ECom Website Page

    

  @Regression
  Scenario Outline: Positing testcasses for submit order
    Given Logged in with username<email> and password<passwords>
    When add product <productName> to cart
    Then Checkout <productName> and submit order
    
    Examples: 
      | email             | passwords  | productName     |
      | sufiyan@gmail.com | Sufiyan12 | ADIDAS ORIGINAL |
      

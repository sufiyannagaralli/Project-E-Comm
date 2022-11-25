
@tag
Feature: Buying Product From EComm WebSite Ussing Negative Data
  I want to use this template for my feature file

  @ErrorValidation
  Scenario Outline: Title of your scenario outline
  Given I  Landed On ECom Website Page
  When Logged in with username<email> and password<passwords>
  Then  "Incorrect email or password." You should get invalid message 
   

       Examples: 
      | email            |passwords  | 
      | sufiya@gmail.com | Sufiyan123 | 

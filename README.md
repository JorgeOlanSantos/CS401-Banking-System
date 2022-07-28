# CS401 Group Project - Banking System

## Group Members
Michael Conant<br>
Jorge Olan Santos<br>
Matthew Knight<br>
Terilyn Truong<br>
Louie Vargas<br>

# Project Summary

## Requirements
- There should be a banking system as well as an ATM system.
- Bank employees and customers must be able to log in with their account ID and password.
- Bank customers should be able to perform basic bank functions (i.e deposit, withdraw, and transfers).
- Bank employees should be able to create accounts and delete accounts.
- A GUI should be provided so that actions can be performed.

## Special Challenges
- First time implementing we tried to use Vectors, but we ended up moving to ArrayList because it was more practical and easier to implement
- We wanted to create two clients, a bank teller client and a ATM client. We were getting difficulties having both clients communicate with the server.
- We did not have enough time to fully integrate the GUI
- Hard to understand how classes work without visual aid
- The UML diagrams required multiple revisions
- Communicating ideas can be difficult
- Had to implement a new class topic soon after learning about it
- Essential keywords were forgotten at times (public, package)

## Hindsight Lessons
- Working with GUI elements is more complicated than anticipated
- Expect UML diagrams to change as the project progresses
- Take care to ensure the proper keywords/package are included in the code
- Start working on the project sooner

# UML Diagrams

## Core Classes
![](pictures/Banking%20System.png)

### Core Classes Details
- BankingSystem is the main class that handles received Requests by the client.
- Account is the actual bank account that holds the balance and the Customer IDS that have access to the account.
  - Because of this Accounts are not tied to one specific customer.
- Customers can also have access to multiple accounts.


## Request Classes
![](pictures/Request.png)

### Request Classes Details
- Request is the base class that we use to send and receive messages between the client and server.
- Other requests types have their own class that extend Request
- On the server end we then use polymorphism to handle the request.
- The server receives general request and with a switch statement we handle each type.
- This allows us to have specialized date and methods for each request type.

# GUI Templates
- These are images that show how we image the GUI will look like.

## ATM GUI
![](pictures/atm%20login.png)
![](pictures/atm%20options.png)

## Teller GUI
![](pictures/teller%20login.png)
![](pictures/teller%20customer%20login.png)
![](pictures/teller%20options.png)

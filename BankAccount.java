//Ashab Naveed
//Computer Science 20
//Henry Wise Wood High School
//2022-2023 Semester 2

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class BankAccount {
  private static final DecimalFormat df = new DecimalFormat("0.00");
  //defining the instance variables, sets the initial balance to $0.00
  String accountNumber;
  double balance = 0;
  double withdrawalFee;
  double annualInterestRate;

  private ArrayList <Transaction> transactionList = new ArrayList<Transaction>(); //initializes transactionList from the transaction class

  //constructor functions, the first one takes in two parameters of an account number and an initial balance, setting the withdrawal fee and annual interest rate to 0.
  public BankAccount (String accountNum) {
    accountNumber = accountNum;
  }

  public BankAccount (String accountNum, double initialBalance) {
    accountNumber = accountNum;
    balance = initialBalance;
  }

  public BankAccount (String accountNum, double initialBalance, double fee, double annualInterest) {
    accountNumber = accountNum;
    balance = initialBalance;
    withdrawalFee = fee;
    annualInterestRate = annualInterest;
  }

//accessors for returning each variable
  public String getAccountNumber () {
    return accountNumber;
  }

  public double getBalance () {
    return balance;
  }
  
  public double getWithdrawalFee () {
    return withdrawalFee;
  }

  public double getAnnualInterestRate () {
    return annualInterestRate;
  }


//mutators that modify variables of annual interest rate and withdrawal fee
  public void setAnnualInterestRate (double rate) {
    annualInterestRate = rate;
  }

  public void setWithdrawalFee (double fee) {
    withdrawalFee = fee;
  }

  //adds an amount to the balance inputting an amount
  public void deposit (double amount) {
    balance += amount; //adds to the amount

    int index = -1;  //sets the index to -1

    Transaction deposit = new Transaction (amount, null); //initalizes deposit with the amount and null for the description
    if (transactionList.size() == 0) { //if the size of the transaction list is zeo, add the deposit
      transactionList.add(deposit);
    } else {
      for (int i = 0; i < transactionList.size(); i++) { //checks for while the variable i is less than the size of the transaction list

        Transaction currentElement = transactionList.get(i); //creates current element which gets the transaction list @ i
        if (deposit.transactionTime.isBefore(currentElement.transactionTime) == true) { //if the deposit transaction time is before the current elements transaction time, sets the index to i and breaks.
          index = i;
          break;
        }
      }

      //if the index is still -1, adds the deposit to the transaction list
      if (index == -1){ 
        transactionList.add(deposit);
      } else {
        transactionList.add(index, deposit); //if the index is more than -1, the index and deposit is added
      }
    }
  }
  

  public void deposit (LocalDateTime transactionTime, double amount, String description) { //desposit with paramaters of transaction time, amount, and description
    balance += amount; //adds to the amount

    int index = -1;

    Transaction deposit = new Transaction (transactionTime, amount, description); //same logic as other deposit method, but creates a deposit with all 3 parameters
    if (transactionList.size() == 0) {
      transactionList.add(deposit);
    } else {
      for (int i = 0; i < transactionList.size(); i++) {

        Transaction currentElement = transactionList.get(i);
        if (deposit.transactionTime.isBefore(currentElement.transactionTime) == true) {
          index = i;
          break;
        }
      }

      if (index == -1){
        transactionList.add(deposit);
      } else {
        transactionList.add(index, deposit);
      }
    }
    
  }

  //deposit with amount and descriptiom
  public void deposit (double amount, String description) {
    balance += amount;

    int index = -1;

    //creates the deposit with an amount and description
    Transaction deposit = new Transaction (amount, description);
    if (transactionList.size() == 0) {
      transactionList.add(deposit);
    } else {
      for (int i = 0; i < transactionList.size(); i++) { //same logic as other deposit methods

        Transaction currentElement = transactionList.get(i);
        if (deposit.transactionTime.isBefore(currentElement.transactionTime) == true) {
          index = i;
          break;
        }
      }

      if (index == -1){
        transactionList.add(deposit);
      } else {
        transactionList.add(index, deposit);
      }
    }
  }

//withdraws an about from the balance, while taking into account the withdrawal fee. Takes in the parameter amount
  public void withdraw (double amount) {
    balance -= (amount + withdrawalFee);

    int index = -1;

    Transaction withdrawal = new Transaction (amount, null); //same logic as the deposit, checks if the size is 0, adds to the list, or else iterates through a loop of the transaction size 
    if (transactionList.size() == 0) {
      transactionList.add(withdrawal);
    } else {
      for (int i = 0; i < transactionList.size(); i++) {

        Transaction currentElement = transactionList.get(i);
        if (withdrawal.transactionTime.isBefore(currentElement.transactionTime) == true) {
          index = i;
          break;
        }
      }

      //same logic, adds to the list with an index if the index is not -1
      if (index == -1){
        transactionList.add(withdrawal);
      } else {
        transactionList.add(index, withdrawal);
      }
    }
    
  }

  //withdrawal with same logic but parameters of time, amount, and description
  public void withdraw (LocalDateTime transactionTime, double amount, String description) {
    balance -= (amount + withdrawalFee);

    int index = -1;

    Transaction withdrawal = new Transaction (transactionTime, amount, description);
    if (transactionList.size() == 0) {
      transactionList.add(withdrawal);
    } else {
      for (int i = 0; i < transactionList.size(); i++) {

        Transaction currentElement = transactionList.get(i);
        if (withdrawal.transactionTime.isBefore(currentElement.transactionTime) == true) {
          index = i;
          break;
        }
      }

      if (index == -1){
        transactionList.add(withdrawal);
      } else {
        transactionList.add(index, withdrawal);
      }
    }
  }

  //withdrawal, same logic, different parameters of amount and description
  public void withdraw (double amount, String description) {
    balance -= (amount + withdrawalFee);

    int index = -1;

    Transaction withdrawal = new Transaction (amount, description);
    if (transactionList.size() == 0) {
      transactionList.add(withdrawal);
    } else {
      for (int i = 0; i < transactionList.size(); i++) {

        Transaction currentElement = transactionList.get(i);
        if (withdrawal.transactionTime.isBefore(currentElement.transactionTime) == true) {
          index = i;
          break;
        }
      }

      if (index == -1){
        transactionList.add(withdrawal);
      } else {
        transactionList.add(index, withdrawal);
      }
    }
  }

//checks if the balance is over drawn be seeing if it is below 0. Returns true if it is, or else false.
  public boolean isOverDrawn () {
    if (balance < 0) {
      return true;
    } else {
      return false;
    }
  }

public String toString (){
  String res; //initialize the variable
  if (balance < 0) { //if the balance is less than 0, multiply the balance by -1 to make it a positive value, adds brackets, and rounds.
    res = "BankAccount " + accountNumber + ": ($" + df.format(-1*balance) + ")";  
    System.out.println(res); }
  else if (balance > 0) { //if the balance is greater than 0, rounds and formats
    res = "BankAccount " + accountNumber + ": $" + df.format(balance);
    System.out.println(res);
  }
  else { //if the balance equals 0, string res is set so that the balance is $0.00.
    res = "BankAccount " + accountNumber + ": $0.00";
    System.out.println(res);
  }
  return res;
}


  public ArrayList <Transaction> getTransactions(LocalDateTime start, LocalDateTime end) { //gets the transactions and takes parameters of the start time and end time

    int counter = 0; //starts a counter at 0

    ArrayList<Transaction> returnList = new ArrayList<Transaction>(); //creates object (array) return list from transaction

    for (int i = 0; i < transactionList.size(); i++) { 
      returnList.add(transactionList.get(i)); //adds the transaction after getting the transaction stored at the i value of the loop.
    }

    ArrayList<Transaction> list = new ArrayList<Transaction>(); //creates an array called list

    for (int i = 0; i < transactionList.size(); i++) { 
      Transaction currentElement = transactionList.get(i); 
     
      
      if (start == null && end != null) { //if the start is empty and the end is not, checks if the time is after the end time, then adds the transaction at i.
        if (currentElement.transactionTime.isAfter(end) == true) {
          list.add(transactionList.get(i)); 
        }
      } else if (start != null && end == null) { //if start is not null and end is null, then checks if the time is before the start and adds the transaction at i.
        if (currentElement.transactionTime.isBefore(start) == true) {
          list.add(transactionList.get(i));
        }
      } else if (start != null && end != null) { //if both values are null, checks if the time is before the start and after the end, adds the transaction at i.
        if (currentElement.transactionTime.isBefore(start) == true || currentElement.transactionTime.isAfter(end) == true) {
          list.add(transactionList.get(i)); 
        }
      }


    }


 //iterates through the list size i, and gets then removes the list item on the return list.
    for (int i = 0; i < list.size(); i++) { 
      returnList.remove(list.get(i));
    }

    
    return returnList; //returns return list
    
  }
}
   

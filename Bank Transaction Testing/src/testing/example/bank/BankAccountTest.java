package testing.example.bank;
import static org.junit.Assert.*;

import org.junit.Test;

 public class BankAccountTest {

	 @Test
	  public void testIdIsAutomaticallyAssignedAsPositiveNumber() {
	  // setup
	  BankAccount bankAccount = new BankAccount();
	  // verify
	 assertTrue("Id should be positive", bankAccount.getId() > 0);
	 }
	 
	 @Test
	  public void testIdsAreIncremental() {
	  BankAccount firstAccount = new BankAccount();
	  BankAccount secondAccount = new BankAccount();
	  assertTrue("Ids should be incremental",
	  firstAccount.getId() < secondAccount.getId());
	  }
	 
	/*
	 wrong test 
	 *  public void testIdsAreIncremental() {
		  BankAccount firstAccount = new BankAccount();
		  BankAccount secondAccount = new BankAccount();
		  assertEquals(1, firstAccount.getId());
		  assertEquals(2, secondAccount.getId());
		  }*/
	 
	 @Test
	  public void testDepositWhenAmountIsCorrectShouldIncreaseBalance() {
	  // setup
	  BankAccount bankAccount = new BankAccount();
	  // exercise
	  bankAccount.deposit(10);
	  // verify
	  assertEquals(10, bankAccount.getBalance(), 0);
	 }
	 
	 
	 @Test
	  public void testDepositWhenAmountIsNegativeShouldThrow() {
	  // setup
	  BankAccount bankAccount = new BankAccount();
	  try {
	  // exercise
	  bankAccount.deposit(-1);
	  fail("Expected an IllegalArgumentException to be thrown");
	  } catch (IllegalArgumentException e) {
	  // verify
	  assertEquals("Negative amount: -1", e.getMessage());
	  assertEquals(0, bankAccount.getBalance(), 0);
	  }
	  }
	 
	 @Test(expected = IllegalArgumentException.class)
	  public void testDepositWhenAmountIsNegativeShouldThrowWithExpected() {
	  BankAccount bankAccount = new BankAccount();
	  bankAccount.deposit(-1);
	 }



 }
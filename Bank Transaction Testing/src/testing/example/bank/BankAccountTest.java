package testing.example.bank;
import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


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
	  assertEquals("Negative amount: -1.0", e.getMessage());  
	  //assertEquals("Negative amount: -1", e.getMessage());
	  assertEquals(0, bankAccount.getBalance(), 0);
	  }
	  }
	 
	/* @Test(expected = IllegalArgumentException.class)
	  public void testDepositWhenAmountIsNegativeShouldThrowWithExpected() {
	  BankAccount bankAccount = new BankAccount();
	  bankAccount.deposit(-1);
	 }
	 */
	 /*
	 @Test(expected = IllegalArgumentException.class)
	 public void testDepositWhenAmountIsNegativeShouldThrowWithExpected() {
	     BankAccount bankAccount = new BankAccount();
	     System.getProperty(""); // throws IllegalArgumentException
	     bankAccount.deposit(10); // this does not throw
	 }
	 */
	 
	 @Rule
	 public ExpectedException thrown = ExpectedException.none();

	 @Test
	 public void testDepositWhenAmountIsNegativeShouldThrowWithExpectedException() {
	     BankAccount bankAccount = new BankAccount();
	     
	     thrown.expect(IllegalArgumentException.class);
	     thrown.expectMessage("Negative amount: -1.0");
	     
	     bankAccount.deposit(-1);
	     // But we can't perform further assertions...
	 }
	 
	 
	 @Test
	 public void testWithdrawWhenAmountIsNegativeShouldThrow() {
	     BankAccount bankAccount = new BankAccount();
	     
	     IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
	         () -> bankAccount.withdraw(-1)); // Trying to withdraw a negative amount
	     
	     assertEquals("Negative amount: -1.0", e.getMessage());
	     assertEquals(0, bankAccount.getBalance(), 0); // Balance should remain unchanged
	 }
	 
	 @Test
	 public void testWithdrawWhenBalanceIsUnsufficientShouldThrow() {
	     BankAccount bankAccount = new BankAccount();
	     
	     IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
	         () -> bankAccount.withdraw(10)); // Trying to withdraw more than the balance
	     
	     assertEquals("Cannot withdraw 10.0 from 0.0", e.getMessage());
	     assertEquals(0, bankAccount.getBalance(), 0); // Balance should remain unchanged
	 }

	 
 }
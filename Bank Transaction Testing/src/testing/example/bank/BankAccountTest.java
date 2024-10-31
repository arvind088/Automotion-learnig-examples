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


 }
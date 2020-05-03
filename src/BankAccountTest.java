import org.junit.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static junit.framework.TestCase.*;


public class BankAccountTest {

  private BankAccount account;

  @BeforeClass
  public static void beforeCalass() {
    System.out.println("... before class ...");
  }

  @Before
  public void setUp() {
    account = new BankAccount("Antonio", "Cassano", 1000.00, BankAccount.CHECKING);
    System.out.println("setup... " + account);
  }

  @After
  public void tearDown() {
    System.out.println("teardown...");
  }

  @Test
  public void toStringTest() {
    assertEquals("BankAccount{firstName='Antonio', lastName='Cassano', balance=1000.0, accountType=1}",
            account.toString());
  }

  @Test
  public void deposit() {
    double balance = account.deposit(200.00, true);
    assertEquals(1200.00, balance, 0);
  }

  @Test
  public void withdraw_branch() {
    double balance = account.withdraw(600.00, true);
    assertEquals(400.00, balance, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void withdraw_notBranch() {
    account.withdraw(600.00, false);
  }

  @Test
  public void getBalance_deposit() {
    account.deposit(200.00, true);
    assertEquals(1200.00, account.getBalance(), 0);
  }

  @Test
  public void getBalance_withdraw() {
    account.withdraw(200.00, true);
    assertEquals(800.00, account.getBalance(), 0);
  }

  @Test
  public void isChecking_true() {
    assertTrue("Not a checking account", account.isChecking());
  }

  @AfterClass
  public static void afterClass() {
    System.out.println("... after class ...");
  }
}
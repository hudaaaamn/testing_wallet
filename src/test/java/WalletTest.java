import org.example.Wallet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WalletTest {
    private Wallet wallet;
    @BeforeEach
    public void setUp() {
        wallet = new Wallet("Anon");
    }
    @Test
    public void testOwnerChange() {
        Assertions.assertEquals("Anon", wallet.getOwner());
        wallet.setOwner("Gibran");
        Assertions.assertEquals("Gibran", wallet.getOwner());}
    @Test
    public void testCardManagement() {
        wallet.addCard("KTM");
        Assertions.assertTrue(wallet.getCards().contains("KTM"));
        wallet.addCard("KTP");
        wallet.addCard("Credit Card");
        Assertions.assertFalse(wallet.getCards().contains("SIM"));}
    @Test
    public void testCoinAdditionAndRemoval() {
        wallet.addCoin(300);
        wallet.addCoin(50);
        wallet.addCoin(3000);
        wallet.addCoin(3000);
        wallet.addCoin(300);
        wallet.addCoin(3000);
        Assertions.assertEquals(1, wallet.getCoins().get(50));
        Assertions.assertEquals(2, wallet.getCoins().get(300));
        Assertions.assertEquals(3, wallet.getCoins().get(3000));
        wallet.takeCoin(50);
        wallet.takeCoin(300);
        wallet.takeCoin(3000);
        Assertions.assertEquals(0, wallet.getCoins().get(50));
        Assertions.assertEquals(1, wallet.getCoins().get(300));
        Assertions.assertEquals(2, wallet.getCoins().get(3000));}

    @Test
    public void testMoneyAdditionAndRemoval() {
        wallet.addMoney(2000);
        wallet.addMoney(2000);
        Assertions.assertEquals(2, wallet.getMoneys().get(2000));

        wallet.addMoney(4000);
        Assertions.assertNull(wallet.getMoneys().get(4000));

        wallet.addMoney(5000);
        wallet.addMoney(100000);
        wallet.addMoney(20000);

        wallet.takeMoney(100000);
        Assertions.assertEquals(0, wallet.getMoneys().get(100000));

        wallet.addMoney(10000);
        wallet.takeMoney(5000);
        Assertions.assertEquals(0, wallet.getMoneys().get(5000));
    }

    @Test
    public void testTotalCoinsAndMoneys() {
        wallet.addCoin(300);
        wallet.addCoin(50);
        wallet.addCoin(3000);
        wallet.addCoin(3000);
        wallet.addCoin(300);
        wallet.addCoin(3000);
        int totalCoins = wallet.calculateCoins();
        Assertions.assertEquals(9650, totalCoins);
        wallet.addMoney(5000);
        wallet.addMoney(100000);
        wallet.addMoney(20000);
        wallet.addMoney(10000);
        wallet.addMoney(5000);
        wallet.addMoney(50000);
        wallet.addMoney(30000);
        int totalMoneys = wallet.calculateMoneys();
        Assertions.assertEquals(190000, totalMoneys);
        Assertions.assertNull(wallet.getMoneys().get(30000));
    }

    @Test
    public void testTotalMoneyAvailable() {
        wallet.addMoney(5000);
        wallet.addMoney(100000);
        wallet.addMoney(20000);
        wallet.addMoney(10000);
        wallet.addMoney(5000);
        wallet.addMoney(50000);
        wallet.addMoney(30000);
        wallet.addCoin(300);
        wallet.addCoin(50);
        wallet.addCoin(3000);
        wallet.addCoin(3000);
        wallet.addCoin(300);
        wallet.addCoin(3000);

        int total = wallet.getMoneyAvailable();
        Assertions.assertEquals(199650, total);
    }
}

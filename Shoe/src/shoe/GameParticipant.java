package shoe;

/**
 *
 * @author Claude
 * @author Ali
 */
public class GameParticipant {
    private String name;
    protected Hand hand;
    int balance = 100000;

//Constructor that will only take nae
    public GameParticipant(String name) {
        this.name = name;
        hand = new Hand();
    }

//constructor that takes name and balance
    public GameParticipant(String name, int balance) {
        this.name = name;
        this.balance = balance;
        hand = new Hand();
    }

    public void drawCard(Card dealtCard) {
        hand.drawCard(dealtCard);
    }

    public String getHand() {
        return hand.toString();
    }

    public int getTotal() {
        return hand.getTotal();
    }

    public void clear() {
        hand.clear();
    }

    public String getName() {
        return name;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    @Override//to string method needs to be addressed
    public String toString() {
        return String.format("%s", hand);
    }
}

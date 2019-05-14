package shoe;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Claude
 * @author Ali
 */
public class GameParticipant {
    private String name;
    protected List<Hand> hands;
    protected Hand hand;
    int index = 0;
    
    int balance = 100000;

//Constructor that will only take nae
    public GameParticipant(String name) {
        this.name = name;
        
        hands = new ArrayList<>();
        
        hand = new Hand();
        hands.add(hand);
    }

//constructor that takes name and balance
    public GameParticipant(String name, int balance) {
        this.name = name;
        this.balance = balance;
        
        hands = new ArrayList<>();
        
        hand = new Hand();
        hands.add(hand);
    }

    public void drawCard(Card dealtCard) {
        hand.drawCard(dealtCard);       
    }

    public String getHand() {
        return hand.toString();
    }
    
    public String getHands() {
        return hands.toString();
    }

    public int getTotal() {
        return hand.getTotal();
    }

    public void clear() {
        hands.clear();
        hand = new Hand();
        hands.add(hand);
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

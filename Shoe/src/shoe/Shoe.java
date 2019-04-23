package shoe;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.security.SecureRandom;

/**
 * @author Claude
 * @author Ali
 */
public class Shoe {

    public List<Card> myShoeCard;
    private int numberOfDecks;
    private int cutCardPosition;
    private int counterOfCardsPulled;
    private int hiLowCounter;

    public Shoe() {
        myShoeCard = new ArrayList<>();
    }

    //creating init method to initialize card
    public void init(int numberOfDecks) {
        this.numberOfDecks = numberOfDecks;
        while (numberOfDecks > 0) {
            for (Card.Suit myCard : Card.Suit.values()) {
                for (int i = 2; i < 15; i++) {
                    Card shoeCard = new Card(myCard, i);
                    myShoeCard.add(shoeCard);
                }
            }
            numberOfDecks--;
        }
    }

    public void shuffleShoeCard() {
        Collections.shuffle(myShoeCard);
    }

    public void cutShoe() {
        SecureRandom randomCut = new SecureRandom();        
        cutCardPosition = 51 + randomCut.nextInt((numberOfDecks - 1) * 52);
        
        while (cutCardPosition >= 0) {
            myShoeCard.add(myShoeCard.remove(0));
            cutCardPosition--;
        }
        
        cutCardPosition = (numberOfDecks * 52) - 52;
    }

    public Card drawCard() {        
        counterOfCardsPulled++;
        cardCounter();
        return myShoeCard.remove(0);
    }

    public Card seeDrawCard() {
        return myShoeCard.get(0);
    }

    public int shoeCardSize() {
        return myShoeCard.size();
    }

    public int getCutCardPosition() {
        return cutCardPosition;
    }

    public boolean hasCutCardBeenPulled() {
        return cutCardPosition <= counterOfCardsPulled;
    }

    public void shoeInit(int numberOfDecks) {
        init(numberOfDecks);
        shuffleShoeCard();
        cutShoe();
    }
    
    public void cardCounter(){
        int cardCounterValue = myShoeCard.get(0).getRank();
        if(cardCounterValue<7)
            hiLowCounter++;
        else if(cardCounterValue>9)        
            hiLowCounter--;
    }

    @Override
    public String toString() {
        return String.format("%d %d", shoeCardSize(), getCutCardPosition());
    }
}

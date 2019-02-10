/**
* Implementation of Deck    
*/

package shoe;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
*   A Class representing a Deck of Cards
*/
public class Deck {
   
    /**
     *  List of Cards
     */
    private List<Card> myCards;
    
    /**
     * Card Constructor
     * initializes myCards as ArrayList
     */    
    public Deck() {
        
        myCards = new ArrayList<>();        
    }
    
    /**
     *  Initializes the Deck arrayList with Cards 
     */    
    public void init() {        
        for(Card.Suit c : Card.Suit.values())
            for(int i = 2; i<15; i++){                
                Card card = new Card(c,i);
                myCards.add(card);
            }        
    }
    
    /**
     * counts the number of Cards
     * 
     * @return the size
     */
    public int counter() {
        return myCards.size();
    }
    
    /**
     * Shuffles the card arrayList
     */
    public void shuffler() {
        Collections.shuffle(myCards);
    }
    
    /**
     * Gets the Card
     * 
     * @param i     the index
     * @return      the Card
     */
    public Card getMyCard(int i) {
        return myCards.get(i);
    }
    
    /**
     * Convert the Deck to a printable string.
     * 
     * @return  The String representation of the Deck 
     */
    @Override
    public String toString() {
        return String.format("%s", myCards.toString());
    }    
}
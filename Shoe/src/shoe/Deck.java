package shoe;

import java.util.List;
import java.util.ArrayList;

/**
 * @author Claude
 * @author Ali
 */
public class Deck {
    //private Card card;
    private List<Card> myCards;
    
    public Deck(){
        myCards = new ArrayList<>();        
    }
    
    public void init(){
        
        //int indexes = 0;
        for(Card.Suit c : Card.Suit.values())
            for(int i = 2; i<15; i++){
                //System.out.println("the card is: " + i + c);
                Card card = new Card(c,i);
                myCards.add(card);
            }        
    }
    public int counter(){
        return myCards.size();
    }
    @Override
    public String toString(){
        return String.format("%s", myCards.toString());
    }

    
    
    
}

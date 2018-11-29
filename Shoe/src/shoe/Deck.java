package shoe;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

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
    //method to initialize deck of cards
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
    public void shuffler(){
        Collections.shuffle(myCards);
    }
    
    public Card getMyCard(int i){
        return myCards.get(i);
    }
    
    @Override
    public String toString(){
        return String.format("%s", myCards.toString());
    }

    
    
    
}

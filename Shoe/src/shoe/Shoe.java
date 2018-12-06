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
    public List <Card> myShoeCard;
    private int numberOfDecks;
    private int finalPosition;
    
    public Shoe(){        
        myShoeCard = new ArrayList<>();    
    };
    
    //creating init method to initialize card
    public void init(int numberOfDecks){
        this.numberOfDecks = numberOfDecks;
        this.finalPosition = (numberOfDecks * 52) - 52;
        while(numberOfDecks >0){
            for(Card.Suit myCard : Card.Suit.values()){
                for(int i =2; i<15; i++){
                    Card shoeCard = new Card(myCard, i);
                    myShoeCard.add(shoeCard);
                }
            }
            numberOfDecks--;            
        }
    }
    
    public void shuffleShoeCard(){
        Collections.shuffle(myShoeCard);
    }
    
    public void cutShoe(){
        SecureRandom randomCut = new SecureRandom();
        int cutCard = 51 + randomCut.nextInt((numberOfDecks-1) *52);
        
        //this println may change
        System.out.println("The cut card is at index: " + cutCard);
        
        while(cutCard>=0){
           myShoeCard.add(myShoeCard.remove(0));
           cutCard--;
        }      
    }
    
    public Card drawCard(){
        return myShoeCard.remove(0);
    }
    
    public int shoeCardSize(){
        return myShoeCard.size();
    }
    
    public int getFinalPosition(){
         return finalPosition;
    }
    
    public void shoeInit(int numberOfDecks){
        init(numberOfDecks);
        shuffleShoeCard();
        cutShoe();
    }    
    
        
    @Override
    public String toString(){
        return String.format("%d %d", shoeCardSize(), getFinalPosition());
    }
    
}

package shoe;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Claude
 * @author Ali
 */
public class Hand {
    
    private List <Card> cardValue = new ArrayList<>();
    
    public void setHand(Card dealt){
        cardValue.add(dealt);
    }
    
    public int getTotal(){
        int total=0;
        while(cardValue.size() > 0){
            for(int i =0; i<cardValue.size(); i++){
                int temp = cardValue.get(i).getRank();
                if(temp > 9 && temp < 14)
                    total+=10;
                else if(temp==14)
                    total+=11;
                else
                    total+= temp;
            }
            break;            
        }
        return total;
    }
    
    //added this to display cards
    public void showCard(int numCardsToShow){
        for(int i = 0; i< numCardsToShow; i++){
            System.out.println(cardValue.get(i));
        }        
    }
    
    
    
    @Override
    public String toString(){
        return String.format("%s", cardValue);
    }
}

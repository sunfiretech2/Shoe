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
    
    public boolean hasBlackjack() {
        return (cardValue.size() == 2 && getTotal() == 21);
    }
    
    public int getTotal() {
        int total = 0;
        boolean hasAce = false;

        for (int i = 0; i < cardValue.size(); ++i) {
            int rank = cardValue.get(i).getRank();
            
            if (rank > 9 && rank < 14) {
                total += 10;
            } else if (rank == 14) {
                if (hasAce) {
                    total += 1;
                } else {
                    total += 11;
                }
                hasAce = true;
            } else {
                total += rank;
            }
        }
        
        // If there is an ace in the hand and the total is over 21
        // then treat the ace as a one instead of an eleven by subtracting
        // ten from the total.
        if (hasAce && total > 21) {
            total -= 10;
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

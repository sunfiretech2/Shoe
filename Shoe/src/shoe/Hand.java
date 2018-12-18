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
    
    private int total = 0;
    private boolean isBlackjack = false;
    private boolean isSoft = false;
    
    public void setHand(Card dealt){
        cardValue.add(dealt);
        calcTotal();
    }
    
    public int getTotal() { return total; }
    public boolean isBlackjack() { return isBlackjack; }
    public boolean isSoft() { return isSoft; }
    
    private void calcTotal() {
        total = 0;
        isSoft = false;
        isBlackjack = false;

        for (int i = 0; i < cardValue.size(); ++i) {
            int rank = cardValue.get(i).getRank();
            
            if (rank > 9 && rank < 14) {
                total += 10;
            } else if (rank == 14) {
                if (isSoft) {
                    total += 1;
                } else {
                    total += 11;
                }
                isSoft = true;
            } else {
                total += rank;
            }
        }
        
        if (isSoft) {
            if (total > 21) {
                // If there is an ace in the hand and the total is over 21
                // then treat the ace as a one instead of an eleven by subtracting
                // ten from the total.
                total -= 10;
                
                isSoft = false;
            } else {
                if ((total == 21) && (cardValue.size() == 2)) {
                    isBlackjack = true;
                }
            }
        }
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

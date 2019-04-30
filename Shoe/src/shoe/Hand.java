package shoe;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Claude
 * @author Ali
 */
public class Hand {

    //need to change back
    private List<Card> cardValue = new ArrayList<>();

    private int total = 0;
    private boolean isBlackjack = false;
    private boolean isSoft = false;
    private boolean isDouble = false;

    //create isBusted in here
    public void drawCard(Card dealt) {
        cardValue.add(dealt);
        calcTotal();
    }
    
    public void doubleDown(Card dealt) {
        isDouble = true;
        drawCard(dealt);
    }
    
    public Card removeLastCard() {
        Card c = cardValue.remove(1);
        return c;
    }

    public int getTotal() {
        return total;
    }

    public boolean isBlackjack() {
        return isBlackjack;
    }

    public boolean isSoft() {
        return isSoft;
    }

    public boolean hasHit() {
        return (cardValue.size() > 2);
    }
    
    public boolean canDoubleDown() {
        return !hasHit();
    }

    public boolean canSplit() {
        Card[] cards = new Card[cardValue.size()];
        cards = cardValue.toArray(new Card[0]);
        return (cardValue.size() == 2) && (cards[0].getRank() == cards[1].getRank());
    }
        
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
    public Card getHoleCard() {
        return cardValue.get(0);
    }

    public boolean isBusted() {
        return total > 21;
    }

    public void clear() {
        cardValue.clear();
        total = 0;
        isBlackjack = false;
        isSoft = false;
        isDouble = false;
    }

    @Override
    public String toString() {
        return String.format("%s", cardValue);
    }

}

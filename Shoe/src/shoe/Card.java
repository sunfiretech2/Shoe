/**
 * Implementation of Card.
 */

package shoe;

/**
 * A class representing a card.
 */
public class Card {

    /** 
     * The four possible suits of a card.
     */    
    public enum Suit {
        C, // CLUB
        S, // SPADE
        D, // DIAMOND
        H  // HEART
    };

    /** 
     * The suit of the Card.
     */
    private Suit suit;
    
    /** 
     * The rank of the Card.
     */
    private int rank;
    
    /**
     * Card constructor.
     *
     * @param     suit  the suit.
     * @param     rank  the rank.
     */
    public Card(Suit suit, int rank) {
        this.suit = suit;
        this.rank = rank;
    }

    /**
     * Gets the suit.
     *
     * @return    the suit.
     */
    public Suit getSuit() {
        return suit;
    }

    /**
     * Gets the rank.
     *
     * @return    the rank.
     */
    public int getRank() {
        return rank;
    }

    /**
     * Convert the suit to it's equivalent character symbol.
     *
     * @return    the suit symbol.
     */
    public char suitSymbol() {
        char suitSymbol = '?';
        switch (suit) {
            case C:
                suitSymbol = '\u2663';
                break;
            case D:
                suitSymbol = '\u2666';
                break;
            case H:
                suitSymbol = '\u2764';
                break;
            case S:
                suitSymbol = '\u2660';
                break;
            default:
                break;
        }
        return suitSymbol;
    }

    /**
     * Convert the rank to it's equivalent character symbol.
     *
     * @return    the rank symbol.
     */
    public char rankSymbol() {
        char rankSymbol = '?';
        if (rank > 1 && rank < 10) {
            rankSymbol = Character.forDigit(rank, 10);
        } else {
            switch (rank) {
                case 10:
                    rankSymbol = 'T';
                    break;
                case 11:
                    rankSymbol = 'J';
                    break;
                case 12:
                    rankSymbol = 'Q';
                    break;
                case 13:
                    rankSymbol = 'K';
                    break;
                case 14:
                    rankSymbol = 'A';
                    break;
                default:
                    break;
            }
        }
        return rankSymbol;
    }

    /**
     * Convert the Card to a printable string.
     *
     * @return    the string representation of the Card.
     */
    @Override
    public String toString() {
        return String.format("%c%c", rankSymbol(), suitSymbol());
    }
}

/*
The card class creates the suit and rank

*/
package shoe;

/**
 * @author Claude
 * @author Ali
 */
public class Card {
    
//There are 4 suits in a deck of cards.  Using Enum  to create the suits.    
    public enum Suit {
        C, // CLUB
        S, // SPADE
        D, // DIAMOND
        H  // HEART
    };

//instance variables of the card class
    private Suit suit;
    private int rank;

//This constructor may not be needed.    
    public Card(){
        
    }
//This constructor is used.  construct suit using card dot suit.    
    public Card(Suit suit, int rank){
        this.suit = suit;
        this.rank = rank;        
    }
    
    //getter for suits of card
    public Suit getSuit(){
        return suit;
    }
    //getter for face value of card
    public int getRank(){
        return rank;
    }
    //this method will convert the suit card to it's equivalent character symbol
    public char suitSymbol(){
        char suitSymbol ='?';
        switch(suit){
            case C:     suitSymbol = '\u2663';
                break;
            case D:     suitSymbol = '\u2666';
                break;
            case H:     suitSymbol = '\u2764';
                break;
            case S:     suitSymbol = '\u2660';
                break;
            default:
                break;
        }
        return suitSymbol;
    }
    
    //this method will convert the rank variable to an assigned character
    public char rankSymbol(){
        char rankSymbol = '?';
        if(rank>1 && rank<10){
            rankSymbol = Character.forDigit(rank, 10);
        }
        else{
            switch(rank){
                case 10:    rankSymbol = 'T';
                    break;
                case 11:    rankSymbol = 'J';
                    break;
                case 12:    rankSymbol = 'Q';
                    break;
                case 13:    rankSymbol = 'K';
                    break;
                case 14:    rankSymbol = 'A';
                    break;
                default:
                    break;  
            }
        }
        return rankSymbol;
    }
    
    //create the to string for card
    @Override
    public String toString(){
        return String.format("%c%c", rankSymbol(), suitSymbol());
    }
}

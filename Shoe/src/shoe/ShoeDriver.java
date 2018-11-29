package shoe;

/**
 *
 * @author Ali
 */
public class ShoeDriver {

    public static void main(String[] args) {
        
        Card cards = new Card(Card.Suit.S, 14);
        
        System.out.println(cards.getRank()+""+cards.getSuit());
        System.out.println(cards.toString());
        
        Deck decks = new Deck();
        decks.init();
        
        System.out.println(decks.toString());
        //System.out.println(decks.);
        System.out.println(decks.counter());
        
    }
    
}

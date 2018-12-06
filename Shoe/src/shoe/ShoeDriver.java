package shoe;

/**
 *
 * @author Ali
 */
public class ShoeDriver {

    public static void main(String[] args) {
        /*
        Card cards = new Card(Card.Suit.S, 14);
        
        System.out.println(cards.getRank()+""+cards.getSuit());
        System.out.println(cards.toString());
        
        Deck decks = new Deck();
        decks.init();
        
        System.out.println(decks.toString());
        System.out.println(decks.getMyCard(3));
        decks.shuffler();
        System.out.println(decks.toString());
        System.out.println(decks.getMyCard(3));
        
        //System.out.println(decks.);
        System.out.println(decks.counter());
        */
        
        Shoe shoe = new Shoe();
        shoe.shoeInit(2);
       
        
       
        //shoe.shuffleShoeCard();
        //System.out.println(shoe.myShoeCard);
        //System.out.println(shoe.myShoeCard.size());
        
        System.out.println(shoe.drawCard());
        System.out.println(shoe.toString());
        
    }
    
}

package shoe;

import java.util.Scanner;

/**
 * @author Claude
 * @author Ali
 */
public class ShoeDriver {

    public static void main(String[] args) {
       
        //creating  blackjack game
        BlackJackGame game = new BlackJackGame();
        System.out.println(game.shoe.myShoeCard.size());
        while(true){
            game.startGame();
            
            //revised hand class arraylist to protected
            //revised blackjackgame player, dealer, shoe to protected
            game.player.hand.cardValue.clear();
            game.dealer.hand.cardValue.clear();
            System.out.println(game.shoe.myShoeCard.size());        
        }
        
    }
}
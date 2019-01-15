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
            
            // ALI 01/14/2019
            // Let's rename startGame to playGame and at the end of playGame,
            // call a method gameEnd() and move clearing the hands to that
            // method.
            game.startGame();
            
            //revised hand class arraylist to protected
            //revised blackjackgame player, dealer, shoe to protected
            game.player.hand.cardValue.clear();
            game.dealer.hand.cardValue.clear();
            System.out.println(game.shoe.myShoeCard.size());        
        }
        
    }
}
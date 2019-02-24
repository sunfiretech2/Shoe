package shoe;

import java.util.Scanner;

/**
 * @author Claude
 * @author Ali
 */
public class ShoeDriver {

    public static void main(String[] args) { 
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter number of decks in shoe:  ");
        int numDecks = input.nextInt();
       
        // Create an instance of blackjack game
        BlackJackGame game = new BlackJackGame(numDecks);         
        
        boolean exitGame = false;
        
        // Continue to play unti the end of the shoe
        while(!exitGame){
            exitGame = game.playGame();                
        }
        
        System.out.println(game.getStats());
        System.out.println("End of shoe, Thanks for playing!");
    }
}

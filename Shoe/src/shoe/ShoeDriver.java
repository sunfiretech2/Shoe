package shoe;

import java.util.Scanner;

/**
 * @author Claude
 * @author Ali
 */
public class ShoeDriver {

    public static void main(String[] args) { 
        Scanner input = new Scanner(System.in);
        
        int numShoes = 1;
        boolean autoPlay = false;
        
        System.out.print("Will this be for auto play?  (Y/N):  ");
        String autoPlayInput = input.nextLine().toUpperCase();
        
        if(autoPlayInput.equals("Y")) {
            System.out.print("Enter number of shoes to play: ");
            numShoes = input.nextInt();
            autoPlay = true;
        }
        
        System.out.print("Enter number of decks in shoe:  ");
        int numDecks = input.nextInt();
       
        // Create an instance of blackjack game
        BlackJackGame game = new BlackJackGame(numDecks, autoPlay);         
        
        boolean exitGame = false;
        
        //used to set number of shoes to play
        for(int i = 0; i < numShoes; i++ ) {  
            //for auto play.  Will only create a new shoe, bypassing constructor            
            if(i>0){                
                exitGame = false;
                game.autoPlayGame(numDecks);
            }
            // Continue to play until the end of the shoe
            while(!exitGame){
                exitGame = game.playGame();                
            }
        }
        
        System.out.println(game.getStats());
        System.out.println("End of shoe, Thanks for playing!");
    }
}

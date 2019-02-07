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
       
        //creating instance of blackjack game
        BlackJackGame game = new BlackJackGame(numDecks);         
        
        while(true){
            game.playGame();                
        }   
    }
}

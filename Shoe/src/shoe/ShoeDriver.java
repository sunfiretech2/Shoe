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
        //System.out.println(game.shoe.myShoeCard.size());
        while(true){
            game.playGame();                
        }
        
        /*
        #1  printing to file
            function to print to file
        #2  comment out files using java documentation
        #3  header info for files
        #4  cut card solution
        #5  game statistics repository
        
        --track wins/loss/push
            #of wlp, amount of wlp, average of wlp
        --max amount, min amount of dollars
        
        */
       
    
    }
}
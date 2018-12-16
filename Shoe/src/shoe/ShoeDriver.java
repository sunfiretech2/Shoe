package shoe;

import java.util.Scanner;

/**
 * @author Claude
 * @author Ali
 */
public class ShoeDriver {

    public static void main(String[] args) {
        
        //creating scanner input
        Scanner input = new Scanner(System.in);
        
        //creating shoe for game
        Shoe shoe = new Shoe();
        shoe.shoeInit(2);
        
        //creating player and dealer 
        Player playerOne = new Player("Claude", 5000);
        Dealer dealer = new Dealer("Eric");
        
        
        //first Card        
        playerOne.setGamblerHand(shoe.drawCard());
        dealer.setGamblerHand(shoe.drawCard());
        //second Card
        playerOne.setGamblerHand(shoe.drawCard());
        dealer.setGamblerHand(shoe.drawCard());
        
        
        
        //printing player cards
        System.out.println(playerOne.toString());
        
        //printing dealer hole card
        dealer.getHoleCard();
        
        System.out.println("Hit (H) / Stand (S)");
        String playerSelection = input.next().toUpperCase();
        
        
        
        while(true){
        if (playerSelection.equals("H")) {
            playerOne.setGamblerHand(shoe.drawCard());
            
        }
        else if(playerSelection.equals("S")){
            System.out.println(playerOne.getTotal());
            //System.out.println(evalGame(drivePlayer, driveDealer));
            break;
        }
        else{
            System.out.println("Invalid input");
        }
         System.out.println("player " + playerOne.toString());
         
         System.out.println("Hit (H) / Stand (S)");
         playerSelection = input.next().toUpperCase();
        
        
    }
    }
}
       
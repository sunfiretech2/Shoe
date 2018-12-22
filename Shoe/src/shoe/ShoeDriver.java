package shoe;

import java.util.Scanner;

/**
 * @author Claude
 * @author Ali
 */
public class ShoeDriver {

    public static void main(String[] args) {
        
        BlackJackGame game = new BlackJackGame();
        
        //creating scanner input
        Scanner input = new Scanner(System.in);
        
        //creating shoe for game
        Shoe shoe = new Shoe();
        shoe.shoeInit(2);
        
        //creating player and dealer 
        Player playerOne = new Player("Claude", 5000);
        Dealer dealer = new Dealer("Dealer");
        
        
        //first Card        
        playerOne.drawCard(shoe.drawCard());
        dealer.drawCard(shoe.drawCard());
        //second Card
        playerOne.drawCard(shoe.drawCard());
        dealer.drawCard(shoe.drawCard());
        
        
        
        //printing player cards
        System.out.println(playerOne.toString());
        
        //printing dealer hole card
        dealer.showHoleCard();
        
        System.out.println();
        System.out.println();
        
       
        
        System.out.println("Hit (H) / Stand (S)");
        String playerSelection = input.next().toUpperCase();
        
        while(true){
        if (playerSelection.equals("H")) {
            playerOne.drawCard(shoe.drawCard());
            
        }
        else if(playerSelection.equals("S")){
            System.out.println(playerOne.getTotal());
            break;
        }
        else{
            System.out.println("Invalid input");
        }
         System.out.println(playerOne.toString());
         dealer.showHoleCard();
         System.out.println();
         if(playerOne.hand.isBlackjack()){
             System.out.println(playerOne.getName() + " has BlackJack");
             break;
         }
         if(playerOne.hand.isBusted()){
             break;
         }
         
         System.out.println("Hit (H) / Stand (S)");
         playerSelection = input.next().toUpperCase();       
    }
        System.out.println(playerOne.toString());
        System.out.println(dealer.toString());
        
        if(!playerOne.hand.isBusted()){
            dealer.dealerAlgo(shoe);  
            System.out.println(playerOne.toString());
            System.out.println(dealer.toString());        
         }
        
        
        System.out.println(game.evalGame(playerOne, dealer));
        
        System.out.println(playerOne.getTotal() + " " + dealer.hand.getTotal());
        System.out.println(playerOne.hand.isBusted() +" " + dealer.hand.isBusted());
        
        
        
        //do the bust dealer & player
        //blackjacks as well
        
        
        
    }
}
       
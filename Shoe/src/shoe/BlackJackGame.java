//This class runs the game.  combines dealer, player and shoe classes
//to validate all aspects of a blackjack game
package shoe;


import java.util.Scanner;

/**
 * @author Ali
 * @author Claude
 */
public class BlackJackGame {
    //Creating a player, dealer, shoe...initialized in constructor
    protected Player player;
    protected Dealer dealer;
    protected Shoe shoe;
    //creating a scanner object
    Scanner input = new Scanner(System.in);
    
    //constructor will initialize the player and dealer fields
    public BlackJackGame(){
        player = new Player("Ali", 15000);
        dealer = new Dealer("Dealer");
        shoe = new Shoe();
        //may need  to ask for number of decks here.  for now setting it up as 2
        shoe.shoeInit(2);
    }
    
    //enum result of hand   
    public enum Result{
        WIN, LOSE, PUSH;
    }
    
   //Player and dealer are dealt two cards
    public void gameDealCards(){
        for(int i=0; i<2; i++){
            player.drawCard(shoe.drawCard());
            dealer.drawCard(shoe.drawCard());  
        }
    } 
        
    //will evaluate player and dealer hand for blackjack.  
    //if blackjack then will skip game Option
    public boolean gameEvalBlackJack(){
        boolean gameFlag = false;
        if(player.hand.isBlackjack()){
            gameFlag = true;
            System.out.println("Player has blackjack"); 
            if(dealer.hand.isBlackjack()){
                System.out.println("dealer also has blackjack");
            }else{
                System.out.println("Dealer DOES NOT have blackjack");
            }
        } else if(dealer.hand.isBlackjack()){
            gameFlag = true;
            System.out.println("only dealer has blackjack");            
        }else{
            System.out.println("no blackjack");
        }   
        return gameFlag;
    } 
       
    public void gameOption(){
        OUTER:
        while (!player.hand.isBusted()) {
            System.out.print("Hit (H) / Stand (S) / Double Down (D)\t");            
            String playerSelection = input.next().toUpperCase();
            System.out.println("\n");
            switch (playerSelection) {
                case "H":
                    player.drawCard(shoe.drawCard());
                    break;
                case "S":
                    //System.out.println(player.getTotal());
                    break OUTER;
                default:
                    System.out.println("Invalid input");
                    break;
            }
            gamePrintDealCardsHole();
        }
        
    }
    
    
    public void startGame(){
        gameDealCards();
        gamePrintDealCardsHole();
        
        //verifies if player or dealer has blackjack
        boolean gameFlagBlackJack = gameEvalBlackJack();
        //if neither has a blackjack
        if(!gameFlagBlackJack){
            gameOption();
            gamePrintDealCardsFinal();
        
            //if player did not bust
            if(!player.hand.isBusted()){
                dealer.dealerAlgo(shoe); 
            }
        }
        gamePrintDealCardsFinal();
        gameEvalWinner();        
    }
       
    public void gamePrintDealCardsHole(){
        //prints out the players cards
        System.out.println(player.toString());
        //prints dealer hole card
        dealer.showHoleCard();
        System.out.println("\n");
    }
    
    public void gamePrintDealCardsFinal(){
        //prints out the players cards
        System.out.println(player.toString());
        //prints dealer hole card
        System.out.println(dealer.toString());
        System.out.println("\n");
    }
        
    public Result gameEvalWinner(){
            
        Result r;
        
        if(player.hand.isBusted()){
            r = Result.LOSE;            
        }
        else if(dealer.hand.isBusted()){
            r = Result.WIN;
        }
        else{
            if(player.getTotal() == dealer.getTotal()){
                r = Result.PUSH;
            }
            else if(player.getTotal() > dealer.getTotal()){
                r = Result.WIN;
        }
            else{
                r = Result.LOSE;
        }            
        } 
        System.out.println(r);
        return r;
    }
    
    //may want to put a to string for win/loss and amount
    //a function for balance.
}

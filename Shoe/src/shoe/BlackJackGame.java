//This class runs the game.  combines dealer, player and shoe classes
//to validate all aspects of a blackjack game

package shoe;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Ali
 * @author Claude
 */
public class BlackJackGame {
    //Creating a player, dealer, shoe...initialized in constructor
    private Player player;
    private Dealer dealer;
    private Shoe shoe;
    private int gameNumber = 0;
    //private boolean dealerHit;
    private String fileName = "C:\\Users\\Public\\HandHistory.txt";
    private PrintWriter pw = null;
    //creating a scanner object
    private Scanner input = new Scanner(System.in);
    //format for date
    private String dateTimeNow = "yyyy.MM.dd hh:mm:ss";
    private SimpleDateFormat sdf = new SimpleDateFormat(dateTimeNow);
    //calendar
    private Calendar cal = Calendar.getInstance();
    //date using calendar
    private Date date = cal.getTime();    

    //constructor will initialize the player and dealer fields
    public BlackJackGame(int numDecks) {
        player = new Player("Player", 15000);
        dealer = new Dealer("Dealer");
        shoe = new Shoe();
        //may need  to ask for number of decks here.  for now setting it up as 2
        shoe.shoeInit(numDecks);
       
        try {        
            FileWriter fw = new FileWriter(fileName, true);
            pw = new PrintWriter(fw, true);
            pw.println("***************************" + " " + sdf.format(date));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BlackJackGame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(BlackJackGame.class.getName()).log(Level.SEVERE, null, ex);
        }     
    }

    //enum result of hand   
    public enum Result {
        WIN, LOSE, PUSH;
    }

    //Player and dealer are dealt two cards
    public void gameDealCards() {
        for (int i = 0; i < 2; i++) {
            player.drawCard(shoe.drawCard());
            dealer.drawCard(shoe.drawCard());
        }
    }

    //will evaluate player and dealer hand for blackjack.  
    //if blackjack then will skip game Option
    public boolean gameEvalBlackJack() {
        boolean gameFlag = false;
        
        if (player.hand.isBlackjack()) {
            gameFlag = true;
            System.out.println("Player has blackjack");
            
            if (dealer.hand.isBlackjack()) {
                System.out.println("Dealer has blackjack");
            }
        } else {
            if (dealer.hand.isBlackjack()) {
                gameFlag = true;
                System.out.println("Dealer has blackjack");
            }
        }
        
        return gameFlag;
    }

    public void gameOption() {
        boolean playerStand = false;
        while (!player.hand.isBusted() && !playerStand) {
            System.out.print("Hit (H) / Stand (S) / Double Down (D)\t");
            String playerSelection = input.next().toUpperCase();
            System.out.println();
            switch (playerSelection) {
                case "H":
                    player.drawCard(shoe.drawCard());
                    gamePrintDealCardsHole();
                    break;
                case "S":
                    //System.out.println(player.getTotal());
                    playerStand = true;
                    break;
                default:
                    System.out.println("Invalid input");
                    gamePrintDealCardsHole();
                    break;
            }
        }
    }
    
    public void shoeCardSize() {
        System.out.println(shoe.shoeCardSize());
    }
    
    public boolean playGame() {
        boolean endOfShoe = true;
        if (!shoe.hasCutCardBeenPulled()) {
            ++gameNumber;
            System.out.println("Game number: " + gameNumber);
            gameDealCards();
            gamePrintDealCardsHole();

            //verifies if player or dealer has blackjack
            boolean gameFlagBlackJack = gameEvalBlackJack();
            boolean dealerHit = false;
            //if neither has a blackjack
            if (!gameFlagBlackJack) {
                gameOption();
                gamePrintDealCardsFinal();

                //if player did not bust
                if (!player.hand.isBusted()) {
                    dealerHit = dealer.dealerAlgo(shoe);
                }
            }
            if (dealerHit || gameFlagBlackJack) {
                gamePrintDealCardsFinal();
            }
            Result r = gameEvalWinner();
            System.out.println("Player: " + r);
            System.out.println("------------");
            System.out.println();
            
            gamePrintToFile();
            clear();
            //shoeCardSize();

            endOfShoe = false;
        }

        return endOfShoe;
    }
    
    public void gamePrintToFile(){
        pw.println("Game Number: " + gameNumber);
        pw.println(player.toString());
        pw.println(dealer.toString());
        pw.println();
    }    

    public void gamePrintDealCardsHole() {
        //prints out the players cards
        System.out.println(player.toString());
        //prints dealer hole card
        dealer.showHoleCard();
        System.out.println();
    }

    public void gamePrintDealCardsFinal() {
        //prints out the players cards
        System.out.println(player.toString());
        //prints dealer hole card
        System.out.println(dealer.toString());
        System.out.println();
    }
    
    public void clear() {
        player.clear();
        dealer.clear();
    }
        
    public Result gameEvalWinner(){
            
        Result r;

        if (player.hand.isBusted()) {
            r = Result.LOSE;
        } else if (dealer.hand.isBusted()) {
            r = Result.WIN;
        } else {
            if (player.getTotal() == dealer.getTotal()) {
                r = Result.PUSH;
            } else if (player.getTotal() > dealer.getTotal()) {
                r = Result.WIN;
            } else {
                r = Result.LOSE;
            }
        }
        
        return r;
    }

    //may want to put a to string for win/loss and amount
    //a function for balance.
}

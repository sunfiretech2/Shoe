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
    
    private int index = 0;
    
    // Game statistics
    private Stats stats = new Stats();
    private boolean autoPlay = false;

    //constructor will initialize the player and dealer fields
    public BlackJackGame(int numDecks, boolean autoPlay) {
        player = new Player("Player", 15000);
        dealer = new Dealer("Dealer");
        shoe = new Shoe();
        //may need  to ask for number of decks here.  for now setting it up as 2
        shoe.shoeInit(numDecks);
        this.autoPlay = autoPlay;
       
        try {        
            FileWriter fw = new FileWriter(fileName, false);
            pw = new PrintWriter(fw, true);
            pw.println("***************************" + " " + sdf.format(date));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BlackJackGame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(BlackJackGame.class.getName()).log(Level.SEVERE, null, ex);
        }     
    }
    
    public void autoPlayGame(int numDecks){
        autoPlay = true;
        Calendar autoCal= Calendar.getInstance();
        date = autoCal.getTime();
        shoe = new Shoe();
        shoe.shoeInit(numDecks);
        pw.println("***************************" + " " + sdf.format(date));
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
        while (index < player.handsSize()) {
            boolean playerStand = false;
            while (!player.hand.isBusted() && !playerStand) {
                System.out.print("Hit (H) / Stand (S)");
                if (player.hand.canDoubleDown()) {
                    System.out.print(" / Double Down (D)");
                }
                //if (player.hand.canSplit()) {
                //    System.out.print(" / Split (P)");
                //}
                System.out.print(":\t");

                String playerSelection = input.next().toUpperCase();
                System.out.println();

                switch (playerSelection) {
                    case "H":
                        player.drawCard(shoe.drawCard());
                        gamePrintDealCardsHole();
                        break;
                    case "S":
                        playerStand = true;
                        break;
                    case "D":
                        if (!player.hand.hasHit()) {
                            player.doubleDown(shoe.drawCard());
                            playerStand = true;
                        } else {
                            System.out.println("Invalid input");
                            gamePrintDealCardsHole();
                        }
                        break;
                    case "P":
                        player.split();
                        player.drawCard(shoe.drawCard());
                        break;
                    default:
                        System.out.println("Invalid input");
                        gamePrintDealCardsHole();
                        break;
                }
            }
            ++index;
            //player.
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
            
            int dealerHoleCardValue = dealer.getHoleCardRank();
            
            //verifies if player or dealer has blackjack
            boolean gameFlagBlackJack = gameEvalBlackJack();
            boolean dealerHit = false;
            boolean playerHit = false;
            //if neither has a blackjack
            if (!gameFlagBlackJack) {
                if(autoPlay){
                    playerHit = player.playerAlgoBasic(dealerHoleCardValue, shoe);
                }
                else{
                    gameOption();
                }
                //gameOption();
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
            
            // Log game played to history.
            printToFile();
            
            // Log game played to statistics.
            stats.add(r, player.hand.isBlackjack(), dealer.hand.isBlackjack());
            
            // Clear last played game.
            clear();

            endOfShoe = false;
        }

        return endOfShoe;
    }
    
    public void printToFile(){
        pw.printf("Game Number: %4d %s%n", gameNumber, player.toString());
        pw.println("                  "  + dealer.toString());        
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
    
    public String getStats() {
        return stats.toString();
    }

    //may want to put a to string for win/loss and amount
    //a function for balance.
}

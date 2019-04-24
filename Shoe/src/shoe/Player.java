
package shoe;

/**
 *
 * @author Claude
 * @author Ali
 */

public class Player extends GameParticipant{
    
    //player members
    private String accountNumber;
    private static int numberOfPlayers = 0;

    //constructor for name and balance
    public Player(String name, int balance) {
        super(name, balance);
        numberOfPlayers++;
    }
    public boolean playerAlgo(Shoe shoe) {
        boolean playerHit = false;
        while (getTotal() < 17) {
            drawCard(shoe.drawCard());
            playerHit = true;
        }
        return playerHit;
    }
    
    //second algo
    public boolean playerAlgoBasic(int rankDealerHoleCard, Shoe shoe) {
        boolean playerHit = false;
        if(rankDealerHoleCard < 7){
            while (getTotal() < 12 || (getTotal() < 18 && hand.isSoft())) {
                drawCard(shoe.drawCard());
                playerHit = true;
            }
        }
        else{
            while (getTotal() < 17) {
                drawCard(shoe.drawCard());
                playerHit = true;
            }
        }
        return playerHit;
    }
    
    public void doubleDown(Card c) {
        hand.doubleDown(c);
    }
        
    @Override
    public String toString(){
        //return String.format("Name:\tWager:\tCards%n%s\t%d\t%s", super.getName(),super.getBalance(),super.getHand());
        return String.format("%s  %s",getName(), getHand());
    }   

}

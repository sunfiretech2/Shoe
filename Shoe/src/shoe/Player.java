
package shoe;

/**
 *
 * @author Wife
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
    
    public String autoPlayPrint(){
        return String.format("%s  %s",getName(), getHand());
    }
    
    @Override
    public String toString(){
        return String.format("Name:\tWager:\tCards%n%s\t%d\t%s", super.getName(),super.getBalance(),super.getHand());
    }
    

}

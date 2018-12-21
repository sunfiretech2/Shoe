
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
    
    @Override
    public String toString(){
        return String.format("Name:\tWager:\tCards%n%s\t%d\t%s", super.getName(),super.getBalance(),super.getHand());
    }
    

}

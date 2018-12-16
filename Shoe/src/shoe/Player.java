
package shoe;

/**
 *
 * @author Wife
 */

public class Player extends Gamblers{
    
    //player members
    private String accountNumber;
    private static int numberOfPlayers = 0;

    //constructor for name and balance
    public Player(String name, int balance) {
        super(name, balance);
        numberOfPlayers++;
    }
    
   /* 
    @Override
    public String getName(){
        return super.getName();
    }
    
    @Override
    public int getBalance(){
        return super.getBalance();
    }
*/
}


package shoe;

/**
 * @Ali
 * @author Claude
 */
public class BlackJackGame {
    
    public enum Result{
        WIN, LOSE, PUSH;
    }
    
    public Result evalGame(Player player, Dealer dealer){
        Result r;
    
        if(player.getTotal() == dealer.getTotal()){
            r = Result.PUSH;
        }
        else if(player.getTotal() > dealer.getTotal()){
            r = Result.WIN;
        }
        else{
            r = Result.LOSE;
        }
        return r;
    }
    
}

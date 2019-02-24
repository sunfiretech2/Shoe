/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoe;

/**
 *
 * @author Ali
 */
public class Stats {
    
    private int wins;
    private int losses;
    private int pushes;
    private int playerBlackjacks;
    private int dealerBlackjacks;
    
    public void add(BlackJackGame.Result r, boolean isPlayerBlackjack, boolean isDealerBlackjack) {
        switch (r) {
            case WIN:
            {
                ++wins;
                break;
            }
            case LOSE:
            {
                ++losses;
                break;
            }
            case PUSH:
            {
                ++pushes;
                break;
            }
            default:
            {
                break;
            }
        }
        
        if (isPlayerBlackjack) {
            ++playerBlackjacks;
        }
        
        if (isDealerBlackjack) {
            ++dealerBlackjacks;
        }
    }
    
        @Override
    public String toString() {
        return String.format("Wins: %d, Losses: %d, Pushes: %d, Player Blackjacks: %d, Dealer Blackjacks: %d", wins, losses, pushes, playerBlackjacks, dealerBlackjacks);
    }
}

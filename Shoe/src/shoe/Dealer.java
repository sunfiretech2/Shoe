/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoe;

/**
 *
 * @author Wife
 */
public class Dealer extends GameParticipant {

    public Dealer(String name) {
        super(name);
    }

    public void showHoleCard() {
        System.out.print(getName() + "\t\t[" + hand.getHoleCard() + "]");
    }

    public boolean dealerAlgo(Shoe shoe) {
        boolean dealerHit = false;
        while (getTotal() < 17) {
            drawCard(shoe.drawCard());
            dealerHit = true;
        }
        return dealerHit;
    }
    
    public String autoPlayPrint(){
        return String.format("%s  %s", getName(), getHand());
    }

    @Override
    public String toString() {
        return String.format("%s\t\t%s", getName(), getHand());
    }
}

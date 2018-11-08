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
public class Card {
    
    public enum Suit {
        C, // CLUB
        S, // SPADE
        D, // DIAMOND
        H  // HEART
    };

    private Suit suit;
    private int rank;
    
   
    public Card(Suit suit, int rank){
        this.suit = suit;
        this.rank = rank;
    }
    
    public Suit getSuit(){
        return suit;
    }
    
    public int getRank(){
        return rank;
    }
    
}

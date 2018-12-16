package shoe;

/**
 *
 * @author Claude
 * @author Ali
 */
public class Gamblers {

private String name;
private Hand hand;
int balance = 100000;

//Constructor that will only take nae
public Gamblers(String name){
    this.name = name;
    hand = new Hand();    
}
//constructor that takes name and balance
public Gamblers(String name, int balance){
    this.name = name;
    this.balance = balance;
    hand = new Hand();
}

public void setGamblerHand(Card dealtCard){
    hand.setHand(dealtCard);
}

public String getHand(){
    return hand.toString();
}
public int getTotal(){
    return hand.getTotal();
}

public void getHoleCard(){
    hand.showCard(1);
}

public String getName(){
    return name;
}

public void setBalance(int balance){
    this.balance =balance;
}

public int getBalance(){
    return balance;
}

@Override//to string method needs to be addressed
public String toString(){
    return String.format("%s", hand);
}


        
}

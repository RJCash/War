package com.theironyard;

/**
 * Created by rickiecashwell on 3/21/17.
 */
public class Card {

    boolean faceUp = true;
    private Suit suit;
    private Rank rank;

    public Card(Suit suit, Rank rank){
        this.rank = rank;
        this.suit = suit;
    }
    public String getImgName(){
        String name =  this.rank.toString().toLowerCase()+"_of_"+this.suit.toString().toLowerCase();
        return name;
    }
    public boolean flip(){
        return !faceUp;
    }
    public Suit getSuit()
    {
        return suit;
    }
    public Rank getRank() {
        return rank;
    }
    @Override
    public String toString() {
        return "Card{"
                + rank + " of "
                + suit +
                '}';
    }
}

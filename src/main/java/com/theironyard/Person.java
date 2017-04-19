package com.theironyard;

import java.util.ArrayList;

/**
 * Created by rickiecashwell on 3/22/17.
 */
public class Person {
    ArrayList<Card> hand = new ArrayList<Card>();
    Deck deckClass = new Deck();
    int handCount = 0;
    int deckCount = 0;

    public ArrayList<Card> getHand() {
        return hand;
    }
    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }
    public Deck getDeckClass() {
        return deckClass;
    }

    public void setDeckClass(Deck deckClass) {
        this.deckClass = deckClass;
    }

    public int getHandCount() {
        return handCount;
    }

    public void setHandCount(int handCount) {
        this.handCount = handCount;
    }

    public int getDeckCount() {
        return deckCount;
    }

    public void setDeckCount(int deckCount) {
        this.deckCount = deckCount;
    }

    public Person(){
    }
    public int getdeckCount(){
        return this.deckCount;
    }

    @Override
    public String toString() {
        return "Person{" +
                "hand=" + hand +
                ", deckClass=" + deckClass +
                ", handCount=" + handCount +
                ", deckCount=" + deckCount +
                '}';
    }
}

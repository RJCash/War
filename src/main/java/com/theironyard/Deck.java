package com.theironyard;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by rickiecashwell on 3/22/17.
 */
public class Deck {
    private ArrayList<Card> deck;
    Suit suit;
    Rank rank;

    public Deck(){
       int count = 0;
        deck = new ArrayList<>();
        for(int x = 0; x < 1; x++){
            for(Rank rank: Rank.values()) {
                for (Suit suit : Suit.values()) {
                    deck.add(new Card(suit, rank));
                    count++;
                }
                }
            }
        System.out.println("there are: "+count+" cards in deck");
        }
    public ArrayList<Card> getDeck(){
        return deck;
    }
    public void setDeck(ArrayList<Card> deck) {
        this.deck = deck;
    }
    public ArrayList<Card> getHand() {
        ArrayList<Card> hand = new ArrayList<>();
        Random genRandSeed = new Random();
        Random generator = new Random(genRandSeed.nextInt());
        for(int x = 0; x < 6; x++){
            if(deck.size() == 0){
                System.out.println("the deck is empty");
                break;
            }
            hand.add(deck.get(generator.nextInt(deck.size())));
            deck.remove(generator.nextInt(deck.size()));
        }
        return hand;
    }
    public Card deal(ArrayList<Card> hand, int choice){
            Card card = hand.get(choice);
            return card;
    }
    public String toString() {
        return "Deck{" +
                "deck=" + deck +"\n";
    }
}

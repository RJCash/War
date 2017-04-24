package com.theironyard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.Random;
/**
 * Created by rickiecashwell on 4/18/17.
 */
@Component
public class WarRepository {
    Random randWithSeed = new Random(50);
    Random rand = new Random();
    Deck deck = new Deck();

    @Autowired
    JdbcTemplate template;

    public Deck getDeck() {
        return this.deck;
    }
    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public void addHighScore(Integer score, String name){
        template.update("INSERT INTO highscore(highscore, personname) " +
                "VALUES(?,?) ",
                new Object[]{score,name});
    }
    public Card PlayerPlay(Integer choice,Person player1){
       // player1.setHand(deck.getHand());
            int dealtCardChoice = choice;
            // Reveal Card
            Card dealtCard = deck.deal(player1.getHand(), (dealtCardChoice-1));
            // Remove that card from the players hand
            player1.getHand().remove(dealtCard);
            // Draw a card
            player1.getHand().add(deck.getDeck().get(randWithSeed.nextInt(deck.getDeck().size())));
            // Remove that drawn card from the deck
            deck.getDeck().remove(randWithSeed.nextInt(deck.getDeck().size()));
            //System.out.println("You chose "+dealtCard);
            return dealtCard;
            }

    public Card CPUplays(Person CPU){
        //The CPU logic is the same as the player
        //CPU.setHand(deck.getHand());
        int dealtCardChoice2 = rand.nextInt(CPU.getHand().size());
        Card dealtCard2 = deck.deal(CPU.getHand(), (dealtCardChoice2));
        CPU.getHand().remove(dealtCard2);
        CPU.getHand().add(deck.getDeck().get(randWithSeed.nextInt(deck.getDeck().size())));
        deck.getDeck().remove(randWithSeed.nextInt(deck.getDeck().size()));
        return dealtCard2;
            }
}



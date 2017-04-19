package com.theironyard;

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



    public Card PlayerPlay(Integer choice,Person player1){
        player1.setHand(deck.getHand());
        //System.out.println("Will you reveal a card or quit? (press q to quit)");
            //if(scan.nextLine() == "q"){
                //break;
            //}else
                //Display current deck size and hand
            //System.out.println("The current deck size is: " + deck.getDeck().size());
            //System.out.println("You current hand: "+ player1.getCurrentHand());
            //System.out.println("Which card in hand will you reveal?");
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
        CPU.setHand(deck.getHand());
        int dealtCardChoice2 = rand.nextInt(CPU.getHand().size());
        Card dealtCard2 = deck.deal(CPU.getHand(), (dealtCardChoice2));
        CPU.getHand().remove(dealtCard2);
        CPU.getHand().add(deck.getDeck().get(randWithSeed.nextInt(deck.getDeck().size())));
        deck.getDeck().remove(randWithSeed.nextInt(deck.getDeck().size()));
        return dealtCard2;
        //System.out.println("CPU revealed: "+ dealtCard2);
        // Whichever has the highest card value wins a point
        //if(dealtCard.getRank().getValue() > dealtCard2.getRank().getValue()){
            //System.out.println("You got one point");
            //yourpoints++;
        //}else{
            //if(dealtCard.getRank().getValue() < dealtCard2.getRank().getValue()) {
                //System.out.println("CPU got one point");
                //CPUPoints++;
            //}else{
                // A draw value rewards nothing to both players.
                //if(dealtCard.getRank().getValue() == dealtCard2.getRank().getValue())
                //System.out.println("draw");
            //}

        }
}



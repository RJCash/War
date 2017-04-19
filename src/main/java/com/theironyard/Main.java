package com.theironyard;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by rickiecashwell on 3/21/17.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Random randWithSeed = new Random(50);
        Random rand = new Random();
        Deck deck = new Deck();
        Person player1 = new Person();
        Person CPU = new Person();
        player1.setHand(deck.getHand());
        System.out.println("player 1 has: " +player1.getHand());
        System.out.println("there are "+deck.getDeck().size()+" cards left in deck");
        CPU.setHand(deck.getHand());
        System.out.println("CPU drew 6 cards");
        System.out.println("there are "+deck.getDeck().size()+" cards left in deck");
        Scanner scan = new Scanner(System.in);
        int yourpoints=0;
        int CPUPoints=0;
        while(true){
            if(deck.getDeck().size() <= 0){
                System.out.println("The deck is empty");
                Thread.sleep(100);
                if(yourpoints > CPUPoints){
                    System.out.println("You win");
                }else{
                    System.out.println("You lose");
                }
            }
            //Whoever reaches 5 points first wins. Look below for more info.
            if(yourpoints > 5){
                System.out.println("You win!");
                break;
            }
            if(CPUPoints > 5){
                System.out.println("You lose");
                break;
            }
            System.out.println("Will you reveal a card or quit? (press q to quit)");
            if(scan.nextLine() == "q"){
                break;
            }else
                //Display current deck size and hand
                System.out.println("The current deck size is: " + deck.getDeck().size());
            System.out.println("You current hand: "+ player1.getHand());
            System.out.println("Which card in hand will you reveal?");
            int dealtCardChoice = scan.nextInt();
            // Reveal Card
            Card dealtCard = deck.deal(player1.getHand(), (dealtCardChoice-1));
            // Remove that card from the players hand
            player1.getHand().remove(dealtCard);
            // Draw a card
            player1.getHand().add(deck.getDeck().get(randWithSeed.nextInt(deck.getDeck().size())));
            // Remove that drawn card from the deck
            deck.getDeck().remove(randWithSeed.nextInt(deck.getDeck().size()));
            System.out.println("You chose "+dealtCard);
            //The CPU logic is the same as the player
            int dealtCardChoice2 = rand.nextInt(CPU.getHand().size());
            Card dealtCard2 = deck.deal(CPU.getHand(), (dealtCardChoice2));
            CPU.getHand().remove(dealtCard2);
            CPU.getHand().add(deck.getDeck().get(randWithSeed.nextInt(deck.getDeck().size())));
            deck.getDeck().remove(randWithSeed.nextInt(deck.getDeck().size()));
            System.out.println("CPU revealed: "+ dealtCard2);
            // Whichever has the highest card value wins a point
            if(dealtCard.getRank().getValue() > dealtCard2.getRank().getValue()){
                System.out.println("You got one point");
                yourpoints++;
            }else{
                if(dealtCard.getRank().getValue() < dealtCard2.getRank().getValue()) {
                    System.out.println("CPU got one point");
                    CPUPoints++;
                }else{
                    // A draw value rewards nothing to both players.
                    if(dealtCard.getRank().getValue() == dealtCard2.getRank().getValue())
                        System.out.println("draw");
                }


            }

        }
    }
}

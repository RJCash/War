package com.theironyard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
 * Created by rickiecashwell on 4/18/17.
 */

@Controller
public class MyController {
    Person player1 = new Person();
    Person CPU = new Person();
    Deck deck;
    List<Card> playerHand = new ArrayList<>();
    List<Card> cPUHand = new ArrayList<>();
    Integer playerPoint = 0;
    Integer cpuPoint = 0;
    Random rand = new Random();
    WarRepository repo;

    @Autowired
    public MyController(WarRepository repo){
        this.repo = repo;
        deck = repo.getDeck();
    }
    @GetMapping("/")
    public String home(Model model){
        if(deck.getDeck().size() < 40){
            deck = new Deck();
            repo.setDeck(deck);
        }
        player1.setHand(deck.getHand());
        CPU.setHand(deck.getHand());
        playerHand = player1.getHand();
        cPUHand = CPU.getHand();
        playerPoint = 0;
        cpuPoint = 0;
        this.playerHand = playerHand;
        this.cPUHand = cPUHand;
        model.addAttribute("deckSize",deck.getDeck().size());
        model.addAttribute("playerPoints",playerPoint);
        model.addAttribute("cpuPoints", cpuPoint);
        model.addAttribute("playerHand", playerHand);
        model.addAttribute("cpuHand", cPUHand);
        return "index";
    }
    @GetMapping("/display")
    public String game(Model model){
        System.out.println(playerHand);
        model.addAttribute("deckSize",deck.getDeck().size());
        model.addAttribute("playerPoints",playerPoint);
        model.addAttribute("cpuPoints", cpuPoint);
        model.addAttribute("playerHand", playerHand);
        model.addAttribute("cpuHand", cPUHand);
        return "index";
    }
    @GetMapping("/play")
    public String play(Model model, @RequestParam(defaultValue = "") Integer choice){
        Card playerDealtCard = repo.PlayerPlay(choice, player1);
        Card cpuDealtCard = repo.CPUplays(CPU);
        if(playerPoint >= 9){
            return "redirect:/winner";
        }
        if(cpuPoint >= 9){
            return "redirect:/loser";
        }
        if(playerDealtCard.getRank().getValue() > cpuDealtCard.getRank().getValue()){
            playerPoint++;
        }else
        if(playerDealtCard.getRank().getValue() < cpuDealtCard.getRank().getValue()){
            cpuPoint++;
        }
        if(playerDealtCard.getRank().getValue() == cpuDealtCard.getRank().getValue()){
            playerPoint += rand.nextInt(3);
            cpuPoint += rand.nextInt(3);
        }
        model.addAttribute("deckSize",deck.getDeck().size());
        model.addAttribute("playerPoints",playerPoint);
        model.addAttribute("cpuPoints", cpuPoint);
        model.addAttribute("playerCard", playerDealtCard);
        model.addAttribute("cpuCard", cpuDealtCard);
        model.addAttribute("choice", choice);
        return "index";
    }
    @GetMapping("/winner")
    public String winner(){
        deck = new Deck();
        repo.setDeck(deck);
        return "winner";
    }
    @GetMapping("/loser")
    public String loser(){
        deck = new Deck();
        repo.setDeck(deck);
        return "loser";
    }
}

package com.theironyard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rickiecashwell on 4/18/17.
 */
@Controller
public class MyController {
    Person player1 = new Person();
    Person CPU = new Person();
    int yourpoints=0;
    int CPUPoints=0;
    Deck deck = new Deck();
    List<Card> playerHand = new ArrayList<>();
    List<Card> cPUHand = new ArrayList<>();
    @Autowired
    WarRepository repo;

    @GetMapping("/")
    public String home(){

        return "index";
    }
   @GetMapping("/CreateHand")
    public String hand(Model model, ArrayList<Card> playerHand, ArrayList<Card> cPUHand){
        player1.setHand(deck.getHand());
        CPU.setHand(deck.getHand());
        playerHand = player1.getHand();
        cPUHand = CPU.getHand();
        System.out.println(playerHand);
        model.addAttribute("playerHand", playerHand);
        model.addAttribute("cpuHand", cPUHand);
        return "redirect:/";
    }
    @GetMapping("/play")
    public String play(Model model, Integer choice){
        model.addAttribute("playerCard",repo.PlayerPlay(choice, player1));
        model.addAttribute("CpuCard", repo.CPUplays(CPU));
        model.addAttribute("choice", choice);
        return "redirect:/";
    }
}

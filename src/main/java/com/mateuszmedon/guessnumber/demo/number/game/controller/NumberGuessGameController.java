package com.mateuszmedon.guessnumber.demo.number.game.controller;

import com.mateuszmedon.guessnumber.demo.number.game.entity.Game;
import com.mateuszmedon.guessnumber.demo.number.game.entity.Guess;
import com.mateuszmedon.guessnumber.demo.number.game.entity.Player;
import com.mateuszmedon.guessnumber.demo.number.game.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/GuessNumberGame")
public class NumberGuessGameController {

    @Autowired
    Game game;

    @Autowired
    GameService gameService;

    @GetMapping("/start/{nick}")
    public Player getPlayer(@PathVariable String nick){
        return gameService.getPlayer(nick);
    }

    @GetMapping("/start")
    public List<Player> getAllPlayers(){
        return gameService.getAllPlayers();
    }

    //GuessNumberGame/start
    @PostMapping("/start")
    public void addPlayer(@RequestBody Player player){
        gameService.addNewPlayer(player);
    }

//    @GetMapping("/guees")
//    public Guess guessTry(@RequestParam Integer number, @RequestBody Player player){
//        return null;
//    }





}

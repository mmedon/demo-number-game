package com.mateuszmedon.guessnumber.demo.number.game.controller;

import com.mateuszmedon.guessnumber.demo.number.game.entity.Game;
import com.mateuszmedon.guessnumber.demo.number.game.entity.Guess;
import com.mateuszmedon.guessnumber.demo.number.game.entity.Player;
import com.mateuszmedon.guessnumber.demo.number.game.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/GuessNumberGame")
public class NumberGuessGameController {

    @Autowired
    Game game;

    @Autowired
    GameService gameService;


    //GuessNumberGame/start
    @PostMapping("/start")
    public Player startGame(@RequestParam String nick){
        return gameService.addNewPlayer(nick);
    }

    @PostMapping("/guees")
    public Guess guessTry(){
        return null;
    }





}

package com.mateuszmedon.guessnumber.demo.number.game.controller;

import com.mateuszmedon.guessnumber.demo.number.game.entity.Game;
import com.mateuszmedon.guessnumber.demo.number.game.entity.Player;
import com.mateuszmedon.guessnumber.demo.number.game.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/GuessNumberGame")
public class NumberGuessGameController {


    @Autowired
    GameService gameService;

    @GetMapping("/start/{nick}")
    public ResponseEntity<Player> getPlayer(@PathVariable String nick) {
        return ResponseEntity.ok(gameService.getPlayer(nick));
    }

    @GetMapping("/start")
    public ResponseEntity<List<Player>> getAllPlayers() {
        return ResponseEntity.ok(gameService.getAllPlayers());
    }

    //GuessNumberGame/start
    @PostMapping("/start")
    public ResponseEntity<Player> addPlayer(@RequestBody Player player) {
        return ResponseEntity.created(URI.create("/" + gameService.addNewPlayer(player))).build();
    }

    @GetMapping("/guess/{nick}/{number}")
    public ResponseEntity<String> guessTry(@PathVariable String nick, @PathVariable Integer number) {
        return ResponseEntity.ok(gameService.guessTry(nick, number));
    }

    @GetMapping("/highscores")
    public ResponseEntity<List<Game>> get10HighScores() {

        return ResponseEntity.ok(gameService.returnHighScores());
    }


}

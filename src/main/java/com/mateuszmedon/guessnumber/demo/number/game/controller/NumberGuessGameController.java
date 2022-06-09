package com.mateuszmedon.guessnumber.demo.number.game.controller;

import com.mateuszmedon.guessnumber.demo.number.game.entity.Game;
import com.mateuszmedon.guessnumber.demo.number.game.entity.Player;
import com.mateuszmedon.guessnumber.demo.number.game.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;


/**
 * Main Spring RestController
 * Listen on http://localhost:8080/GuessNumberGame
 *
 * TODO: Braking the components tests by adding thymeleaf UI. When I try it ;(
 */
@RestController
@RequestMapping(path = "/GuessNumberGame")
public class NumberGuessGameController {


    @Autowired
    GameService gameService;

    /**
     * Method for getting player
     * listen on /start/{nick}
     *
     * @param nick taking String variable of player
     * @return current Player
     */
    @GetMapping("/start/{nick}")
    public ResponseEntity<Player> getPlayer(@PathVariable String nick) {
        return ResponseEntity.ok(gameService.getPlayer(nick));
    }

    /**
     * Method for getting all players
     * listen on /start
     *
     * @return all players
     */
    @GetMapping("/start")
    public ResponseEntity<List<Player>> getAllPlayers() {
        return ResponseEntity.ok(gameService.getAllPlayers());
    }

    /**
     * Method for creating player
     * listen on /start
     *
     * @param player Taking Json object of Player
     * @return player if created
     */
    //GuessNumberGame/start
    @PostMapping("/start")
    public ResponseEntity<Player> addPlayer(@RequestBody Player player) {
        return ResponseEntity.created(URI.create("/" + gameService.addNewPlayer(player))).build();
    }

    /**
     * Method for taking the player guess
     * listen on /start/{nick}
     *
     * @param nick   string value of the nick player
     * @param number int number of the user guess
     * @return message of the player ststus
     */
    @GetMapping("/guess/{nick}/{number}")
    public ResponseEntity<String> guessTry(@PathVariable String nick, @PathVariable Integer number) {
        return ResponseEntity.ok(gameService.guessTry(nick, number));
    }

    /**
     * Method for 10 highest scores of the current game for all players
     * listen on /start/{nick}
     *
     * @return 10 highest score of the all players
     */
    @GetMapping("/highscores")
    public ResponseEntity<List<Game>> get10HighScores() {

        return ResponseEntity.ok(gameService.returnHighScores());
    }


}

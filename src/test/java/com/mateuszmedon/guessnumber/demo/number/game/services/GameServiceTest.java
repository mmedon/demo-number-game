package com.mateuszmedon.guessnumber.demo.number.game.services;

import com.mateuszmedon.guessnumber.demo.number.game.entity.Game;
import com.mateuszmedon.guessnumber.demo.number.game.entity.Player;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureMockMvc
class GameServiceTest {

    @Autowired
    GameService gameService;

    @BeforeEach
    public void setUp() {
        Player player = new Player("matmed");
        Player player2 = new Player("joe");
        player.setGameNumber(54);

        gameService.addNewPlayer(player);
        gameService.addNewPlayer(player2);

        gameService.addGames(initGames());
    }

    @Test
    public void passWhen_AllPlayers_returnsAll() {

        List<Player> testPlayers = new ArrayList<>();
        Player player = new Player("matmed");
        Player player2 = new Player("joe");

        testPlayers.add(player);
        testPlayers.add(player2);

        assertThat(testPlayers.get(0).getNick()).isEqualTo(gameService.getAllPlayers().get(0).getNick());
    }

    @Test
    public void whenValidNick_thenPlayerShouldBeFound() {
        String name = "matmed";
        Player found = gameService.getPlayer(name);

        assertThat(found.getNick())
                .isEqualTo(name);
    }

    @Test
    public void testMethod_guessTry_message_numberToHigh() {


        String name = "matmed";
        Player found = gameService.getPlayer(name);

        String message = gameService.guessTry("matmed", 101);

        assertThat(found.getNick()).isEqualTo(name);
        assertThat(message).isEqualTo("Your number is to big");
    }

    @Test
    public void testMethod_guessTry_message_numberToLow() {


        String name = "matmed";
        Player found = gameService.getPlayer(name);

        String message = gameService.guessTry("matmed", -2);

        assertThat(found.getNick()).isEqualTo(name);
        assertThat(message).isEqualTo("Your number is to small");
    }


//    @Test
//    public void testMethod_guessTry_message_win() {
//
//
//        String name = "matmed";
//        Player found = gameService.getPlayer(name);
//
//        String message = gameService.guessTry("matmed", 54);
//
//        assertThat(found.getNick()).isEqualTo(name);
//        assertThat(message).isEqualTo("You win");
//    }

    @Test
    void passWhenReturn_10sortedHighScoresTest() {

        List<Game> testGame = new ArrayList<>();
        Game game1 = new Game(1);
        Game game2 = new Game(2);
        Game game3 = new Game(3);
        Game game4 = new Game(3);
        Game game5 = new Game(4);
        Game game6 = new Game(5);
        Game game7 = new Game(5);
        Game game8 = new Game(6);
        Game game9 = new Game(7);
        Game game10 = new Game(8);


        testGame.add(game1);
        testGame.add(game2);
        testGame.add(game3);
        testGame.add(game4);
        testGame.add(game5);
        testGame.add(game6);
        testGame.add(game7);
        testGame.add(game8);
        testGame.add(game9);
        testGame.add(game10);

        assertThat(testGame)
                .isEqualTo(gameService.returnHighScores());

        assertThat(gameService.returnHighScores()).hasSize(10);

    }


    public static List<Game> initGames() {

        List<Game> testGame = new ArrayList<>();
        Game game1 = new Game(1);
        Game game2 = new Game(2);
        Game game3 = new Game(3);
        Game game4 = new Game(3);
        Game game5 = new Game(4);
        Game game6 = new Game(5);
        Game game7 = new Game(5);
        Game game8 = new Game(6);
        Game game9 = new Game(7);
        Game game10 = new Game(8);
        Game game11 = new Game(31);
        Game game12 = new Game(324);

        testGame.add(game1);
        testGame.add(game10);
        testGame.add(game6);
        testGame.add(game2);
        testGame.add(game3);
        testGame.add(game5);
        testGame.add(game12);
        testGame.add(game7);
        testGame.add(game11);
        testGame.add(game4);
        testGame.add(game9);
        testGame.add(game8);

        return testGame;

    }
}
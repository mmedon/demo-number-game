package com.mateuszmedon.guessnumber.demo.number.game.services;


import com.mateuszmedon.guessnumber.demo.number.game.entity.Game;
import com.mateuszmedon.guessnumber.demo.number.game.entity.PlayerTable;
import com.mateuszmedon.guessnumber.demo.number.game.entity.Player;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class GameService {

    PlayerTable playerTable = new PlayerTable();
    List<Player> playerList = playerTable.getPlayerList();

    Game game = new Game();
    List<Game> gameList = new ArrayList<>();


    public Player addNewPlayer(Player player) {

        Player newPlayer = new Player();
        newPlayer.setNick(player.getNick());

        for (Player gamer : playerList) {
            if (newPlayer.getNick().equals(gamer.getNick())) {
                System.out.println("Player with nick " + player + " already existing in our game");
                return null;
            }
        }
        playerList.add(newPlayer);
        return newPlayer;
    }


    public Player getPlayer(String nick) {
        return Optional.of(playerTable.getPlayerList()
                        .stream()
                        .filter(player -> player.getNick().equals(nick))
                        .findFirst()
                        .get())
                .orElse(null);
    }

    public List<Player> getAllPlayers() {
        return playerList;
    }

    public String guessTry(String nick, Integer number) {


        Player player = getPlayer(nick);
        player.setMessage("playing");
        Random random = new Random();

        if (player.getGameNumber() == -1) {
            int newNumber = random.nextInt(100 - 1) + 1;
            player.setGameNumber(newNumber);
            player.setAttempt(0);
            System.out.println("game number: " + player.getGameNumber());

            game = new Game();
        }

        if (player.getGameNumber() > number) {
            player.setMessage("Your number is to small");
            player.incrementAttempt();
        }

        if (player.getGameNumber() < number) {
            player.setMessage("Your number is to big");
            player.incrementAttempt();
        }

        if (player.getGameNumber() == number) {
            player.setMessage("You win");

            game.setResultOfTheGame(player.getAttempt());
            game.setNick(player.getNick());
            player.setGameNumber(-1);

            gameList.add(game);
        }

        return player.getMessage();
    }

    public List<Game> addGames(List<Game> list) {
        gameList = list;
        return gameList;
    }

    public List<Game> returnHighScores() {

        return gameList.stream()
                .sorted(Comparator.comparingInt(Game::getResultOfTheGame))
                .limit(10)
                .collect(Collectors.toList());
    }
}

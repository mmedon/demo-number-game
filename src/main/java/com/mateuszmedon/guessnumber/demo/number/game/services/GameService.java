package com.mateuszmedon.guessnumber.demo.number.game.services;


import com.mateuszmedon.guessnumber.demo.number.game.entity.Game;
import com.mateuszmedon.guessnumber.demo.number.game.entity.Player;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameService {

    Game game = new Game();
    List<Player> playerList = game.getPlayerList();


    public Player addNewPlayer(Player player){

        Player newPlayer = new Player();
        newPlayer.setNick(player.getNick());

        for (Player gamer : playerList) {
            if (newPlayer.getNick().equals(gamer.getNick())){
                System.out.println("Player with nick " + player + " already existing in our game");
                return null;
            }
        }
        playerList.add(newPlayer);
        return newPlayer;
    }


    public Player getPlayer(String nick) {
        return Optional.of(game.getPlayerList()
                .stream()
                .filter(player -> player.getNick().equals(nick))
                .findFirst()
                .get())
                .orElse(null);
    }

    public List<Player> getAllPlayers() {
        return playerList;
    }
}

package com.mateuszmedon.guessnumber.demo.number.game.services;


import com.mateuszmedon.guessnumber.demo.number.game.entity.Game;
import com.mateuszmedon.guessnumber.demo.number.game.entity.Player;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    Game game = new Game();


    public Player addNewPlayer(String nick){

        Player player = new Player();
        player.setNick(nick);

        for (Player gamer : game.getPlayerList()) {
            if (player.getNick().equals(gamer.getNick())){
                System.out.println("Player with nick " + nick + " already existing in our game");
                return null;
            }
        }
        game.getPlayerList().add(player);
        return player;
    }




}

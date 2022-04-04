package com.mateuszmedon.guessnumber.demo.number.game.entity;


import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Game {

    private static final List<Player> playerList = new ArrayList<>();

    public List<Player> getPlayerList() {
        return playerList;
    }
}

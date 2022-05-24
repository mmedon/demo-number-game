package com.mateuszmedon.guessnumber.demo.number.game.entity;

import org.springframework.stereotype.Component;

@Component
public class Game {

    private String nick;
    private int resultOfTheGame;

    public Game() {
    }


    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public int getResultOfTheGame() {
        return resultOfTheGame;
    }

    public void setResultOfTheGame(int resultOfTheGame) {
        this.resultOfTheGame = resultOfTheGame;
    }
}

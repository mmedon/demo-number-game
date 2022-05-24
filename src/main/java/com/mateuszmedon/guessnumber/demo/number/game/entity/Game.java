package com.mateuszmedon.guessnumber.demo.number.game.entity;

import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class Game {

    private String nick;
    private int resultOfTheGame;

    public Game() {
    }

    public Game(int resultOfTheGame) {
        this.resultOfTheGame = resultOfTheGame;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return resultOfTheGame == game.resultOfTheGame && Objects.equals(nick, game.nick);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nick, resultOfTheGame);
    }
}

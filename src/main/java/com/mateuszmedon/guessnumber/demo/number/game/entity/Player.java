package com.mateuszmedon.guessnumber.demo.number.game.entity;

import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class Player {

    String nick;
    int gameNumber;

    public Player() {
    }

    public Player(String nick) {
        this.nick = nick;

    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public int getGameNumber() {
        return gameNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return gameNumber == player.gameNumber && Objects.equals(nick, player.nick);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nick, gameNumber);
    }

    @Override
    public String toString() {
        return "Player{" +
                "nick='" + nick + '\'' +
                ", gameNumber=" + gameNumber +
                '}';
    }
}

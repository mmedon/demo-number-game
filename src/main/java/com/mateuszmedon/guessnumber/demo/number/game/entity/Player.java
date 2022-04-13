package com.mateuszmedon.guessnumber.demo.number.game.entity;

import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class Player {

    private String nick;
    private String results;
    private boolean win;

    public Player() {
    }

    public Player(String results, boolean win) {
        this.results = results;
        this.win = win;
    }

    public Player(String nick, String results, boolean win) {
        this.nick = nick;
        this.results = results;
        this.win = win;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getResults() {
        return results;
    }

    public void setResults(String results) {
        this.results = results;
    }

    public boolean isWin() {
        return win;
    }

    public void setWin(boolean win) {
        this.win = win;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return win == player.win && Objects.equals(nick, player.nick) && Objects.equals(results, player.results);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nick, results, win);
    }

    @Override
    public String toString() {
        return "Player{" +
                "nick='" + nick + '\'' +
                ", results='" + results + '\'' +
                ", win=" + win +
                '}';
    }
}

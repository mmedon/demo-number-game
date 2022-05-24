package com.mateuszmedon.guessnumber.demo.number.game.entity;

import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class Player {

    private String nick;
    private String results;
    private int gameNumber;
    private String message;
    private int attempt;

    public Player() {
        gameNumber = -1;
    }

    public void incrementAttempt() {
        attempt++;
    }

    public int getAttempt() {
        return attempt;
    }

    public void setAttempt(int attempt) {
        this.attempt = attempt;
    }

    public int getGameNumber() {
        return gameNumber;
    }

    public void setGameNumber(int gameNumber) {
        this.gameNumber = gameNumber;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return gameNumber == player.gameNumber && Objects.equals(nick, player.nick) && Objects.equals(results, player.results);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nick, results, gameNumber);
    }
}

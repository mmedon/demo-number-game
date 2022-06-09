package com.mateuszmedon.guessnumber.demo.number.game.entity;

import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * Game is the main entity we'll be using to create a game for the selected player
 *
 * Please see the {@link com.mateuszmedon.guessnumber.demo.number.game.entity.Player} class for true identity
 * @author Mateusz Medon
 *
 **/
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

    public Player(String nick) {
        this.nick = nick;
    }

    public Player(String nick, String results, int gameNumber, String message, int attempt) {
        this.nick = nick;
        this.results = results;
        this.gameNumber = gameNumber;
        this.message = message;
        this.attempt = attempt;
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

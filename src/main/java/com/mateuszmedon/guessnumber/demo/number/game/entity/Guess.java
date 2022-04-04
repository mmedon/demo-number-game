package com.mateuszmedon.guessnumber.demo.number.game.entity;

import org.springframework.stereotype.Component;

@Component
public class Guess {

    int guessNumber;
    Player player;
    boolean win;


    public Guess() {
    }

    public Guess(int number, Player player) {
        this.guessNumber = number;
        this.player = player;
    }

    public int getGuessNumber() {
        return guessNumber;
    }

    public void setGuessNumber(int guessNumber) {
        this.guessNumber = guessNumber;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}

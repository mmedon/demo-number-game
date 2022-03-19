package com.mateuszmedon.guessnumber.demo.number.game.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/GuessNumberGame")
public class NumberGuessGameController {


    @GetMapping()
    public String getGenerateNumber(){
        System.out.println("3");
        return "3";
    }




}

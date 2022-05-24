package com.mateuszmedon.guessnumber.demo.number.game.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mateuszmedon.guessnumber.demo.number.game.entity.Player;
import com.mateuszmedon.guessnumber.demo.number.game.services.GameService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class NumberGuessGameControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    GameService gameService;

    @BeforeEach
    public void setUp() {
        Player player = new Player("matmed");
        Player player2 = new Player("joe");

        gameService.addNewPlayer(player);
        gameService.addNewPlayer(player2);
    }

    @Test
    void getPlayerTest() throws Exception {

        this.mockMvc
                .perform(get("/GuessNumberGame/start/matmed"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.nick").value("matmed"))
                .andExpect(jsonPath("$.attempt").value(1));
    }


    @Test
    void getAllPlayerTest() throws Exception {

        this.mockMvc
                .perform(get("/GuessNumberGame/start"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    void postNewPlayerCreateTest() throws Exception {

        this.mockMvc
                .perform(post("/GuessNumberGame/start")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(gameService.getPlayer("matmed"))))
                .andExpect(status().isCreated());
//                .andExpect(jsonPath("$.player[0]").exists());

        assertThat(gameService.getPlayer("matmed").getNick()).isEqualTo("matmed");
    }


    @Test
    void passWhenGuessTryTest() throws Exception {

        this.mockMvc
                .perform(get("/GuessNumberGame/guess/matmed/89"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/plain;charset=UTF-8"));


    }


    @Test
    void passWhenReturnHighScores() throws Exception {

        this.mockMvc
                .perform(get("/GuessNumberGame/highscores"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));

    }


    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
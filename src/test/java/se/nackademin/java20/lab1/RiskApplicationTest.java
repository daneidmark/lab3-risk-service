package se.nackademin.java20.lab1;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class RiskApplicationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void shouldFailRiskAssessmentForDan() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/risk/Dan"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.pass").value(false));
    }

    @Test
    void shouldReturn404IfUrlIsWrong() throws Exception {
        // /hej
    }

    @Test
    void shouldReturnTrueIfRiskAssessmentForDbn() throws Exception {
        // /risk/Dbn
    }

}
package com.cursor.teben.controller;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class LaptopControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getAllLaptops() throws Exception {
        this.mockMvc.perform(get("/laptops/"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void getUsedLaptops() throws Exception {
        this.mockMvc.perform(get("/laptops/used"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void getLaptopsByRam() throws Exception {
        this.mockMvc.perform(get("/laptops/ram"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void getAllLaptopsOrderedByProducerDesc() throws Exception {
        this.mockMvc.perform(get("/laptops/ordered"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
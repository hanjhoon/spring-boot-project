package com.playdata.springbootproject.web;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = HellloController.class)
class HellloControllarTest {
    @Autowired
    private MockMvc mvc;
    @Test
    void hello() throws Exception {
        mvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string("hello"));
    }

    @Test
    public void helloDto() throws Exception {
        String name ="홍길동";
        int amount=1000;

        //when
        //then
        mvc.perform(get("/hello/dto")
                .param("name",name)
                .param("amount",String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(name))
                .andExpect(jsonPath("$.amount").value(amount));
    }
}
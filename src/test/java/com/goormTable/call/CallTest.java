package com.goormTable.call;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CallTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void callReservationTest() throws Exception {
        String tel = "010-9466-0811";
        int sequence = 1;
        String status = "wait";

        mockMvc.perform(post("/admin/call")
                        .param("tel", tel)
                        .param("sequence", String.valueOf(sequence))
                        .param("status", status)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
    }
}

package com.goormTable.confirm;

import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import com.goormTable.confirm.controller.ConfirmController;
import com.goormTable.confirm.service.ConfirmService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ConfirmController.class)
@ActiveProfiles("test")
public class ConfirmTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ConfirmService confirmService;

    @Test
    public void testConfirmSuccess() throws Exception {
        // 서비스 메소드가 성공적으로 처리됐다고 가정
        given(confirmService.confirmUserStatus(anyString(), anyInt())).willReturn(true);

        // 테스트 실행
        mockMvc.perform(post("/admin/confirm")
                        .param("tel", "010-1234-5678")
                        .param("sequence", "1")
                        .param("status", "wait")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        // ConfirmService의 confirmUserStatus 메소드 호출 확인
        then(confirmService).should().confirmUserStatus(anyString(), anyInt());
    }

    @Test
    public void testConfirmFailure() throws Exception {
        // 서비스 메소드가 실패했다고 가정
        given(confirmService.confirmUserStatus(anyString(), anyInt())).willReturn(false);

        // 테스트 실행
        mockMvc.perform(post("/admin/confirm")
                        .param("tel", "nonexistent")
                        .param("sequence", "999")
                        .param("status", "pending")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

        // ConfirmService의 confirmUserStatus 메소드 호출 확인
        then(confirmService).should().confirmUserStatus(anyString(), anyInt());
    }
}

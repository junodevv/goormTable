package com.goormTable.confirm.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ConfirmRequest {
    @NotNull
    private String tel;
    @NotNull
    private int sequence;
    @NotNull
    private String status;
}

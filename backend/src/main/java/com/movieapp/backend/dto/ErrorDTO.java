package com.movieapp.backend.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
public class ErrorDTO {

    private final LocalDateTime timestamp;
    private final int status;
    private final String error;
    private final List<String> details;

}

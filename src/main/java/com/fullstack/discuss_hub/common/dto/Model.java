package com.fullstack.discuss_hub.common.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
public class Model {
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdDate;
}

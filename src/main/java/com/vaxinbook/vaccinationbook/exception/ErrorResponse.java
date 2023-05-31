package com.vaxinbook.vaccinationbook.exception;

import lombok.*;

@Data
@AllArgsConstructor
public class ErrorResponse {
    Integer errorCode;
    String message;
    String localizedMessage;
}

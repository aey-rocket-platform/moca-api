package org.aey.shared.errors;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ErrorResponse {
    private Integer statusCode;
    private String errorCode;
    private String message;
}

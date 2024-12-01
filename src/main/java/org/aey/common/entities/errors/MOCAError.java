package org.aey.common.entities.errors;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class MOCAError {
    private String mocaErrorCode;
    private Integer statusCode;
    private String errorCode;
    private String message;
}

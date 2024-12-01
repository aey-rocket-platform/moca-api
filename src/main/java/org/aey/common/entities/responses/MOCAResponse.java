package org.aey.common.entities.responses;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class MOCAResponse<T> {
    private Integer statusCode;
    private String action;
    private String message;
    private T data;
}

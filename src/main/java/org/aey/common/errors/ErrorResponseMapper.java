package org.aey.common.errors;

import jakarta.ws.rs.core.Response;

public class ErrorResponseMapper {

    public static ErrorResponse toErrorResponse(ErrorCode errorCode) {
        return ErrorResponse.builder()
                .statusCode(errorCode.getStatusCode())
                .errorCode(errorCode.getErrorCode())
                .message(errorCode.getMessage())
                .build();
    }

    public static Response toResponse(ErrorCode errorCode) {
        ErrorResponse error = toErrorResponse(errorCode);
        return Response
                .status(errorCode.getStatusCode())
                .entity(error)
                .build();
    }
}

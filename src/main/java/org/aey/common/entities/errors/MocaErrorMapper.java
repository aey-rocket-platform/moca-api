package org.aey.common.entities.errors;

import jakarta.ws.rs.core.Response;

public class MocaErrorMapper {

    public static MocaError toErrorResponse(MocaErrorCode mocaErrorCode) {
        return MocaError.builder()
                .statusCode(mocaErrorCode.getStatusCode())
                .errorCode(mocaErrorCode.getErrorCode())
                .message(mocaErrorCode.getMessage())
                .build();
    }

    public static Response toResponse(MocaErrorCode mocaErrorCode) {
        MocaError error = toErrorResponse(mocaErrorCode);
        return Response
                .status(mocaErrorCode.getStatusCode())
                .entity(error)
                .build();
    }
}

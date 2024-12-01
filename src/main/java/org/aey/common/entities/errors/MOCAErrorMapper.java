package org.aey.common.entities.errors;

import jakarta.ws.rs.core.Response;

public class MOCAErrorMapper {

    public static MOCAError toErrorResponse(MOCAErrorCodes mocaErrorCodes) {
        return MOCAError.builder()
                .mocaErrorCode(mocaErrorCodes.getMocaErrorCode())
                .statusCode(mocaErrorCodes.getHttpStatusCode())
                .errorCode(mocaErrorCodes.getHttpErrorCode())
                .message(mocaErrorCodes.getMessage())
                .build();
    }

    public static Response toResponse(MOCAErrorCodes mocaErrorCodes) {
        MOCAError error = toErrorResponse(mocaErrorCodes);
        return Response
                .status(mocaErrorCodes.getHttpStatusCode())
                .entity(error)
                .build();
    }
}

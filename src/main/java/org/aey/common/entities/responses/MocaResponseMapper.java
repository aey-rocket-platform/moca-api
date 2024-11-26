package org.aey.common.entities.responses;

import jakarta.ws.rs.core.Response;

public class MocaResponseMapper {

    public static <T> MocaResponse<T> toEntity(MocaResponseCode mocaResponseCode, T data) {
        return MocaResponse.<T>builder()
                .statusCode(mocaResponseCode.getStatusCode())
                .action(mocaResponseCode.getAction())
                .message(mocaResponseCode.getMessage())
                .data(data)
                .build();
    }

    public static <T> Response toResponse(MocaResponse<T> mocaResponse) {
        return Response.status(mocaResponse.getStatusCode())
                .entity(mocaResponse)
                .build();
    }
}

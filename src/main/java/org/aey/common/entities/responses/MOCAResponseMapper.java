package org.aey.common.entities.responses;

import jakarta.ws.rs.core.Response;

public class MOCAResponseMapper {

    public static <T> Response toResponse(MOCAResponseCode mocaResponseCode, T data) {
        MOCAResponse<T> mocaResponse = build(mocaResponseCode, data);
        return toResponse(mocaResponse);
    }

    public static <T> MOCAResponse<T> build(MOCAResponseCode mocaResponseCode, T data) {
        return MOCAResponse.<T>builder()
                .statusCode(mocaResponseCode.getStatusCode())
                .action(mocaResponseCode.getAction())
                .message(mocaResponseCode.getMessage())
                .data(data)
                .build();
    }

    public static <T> Response toResponse(MOCAResponse<T> mocaResponse) {
        return Response.status(mocaResponse.getStatusCode())
                .entity(mocaResponse)
                .build();
    }
}

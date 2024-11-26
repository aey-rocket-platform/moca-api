package org.aey.common.entities.errors;

import lombok.Getter;

@Getter
public enum MocaErrorCode {

    BAD_REQUEST(400, "Bad Request", "Invalid request format. Please check the request body"),
    UNIQUENESS_RULE(400, "Bad Request", "Insertion error. This element already exists"),
    NOT_NULL_VALUE(400, "Bad Request", "Value cannot be null. Please provide a valid value for the required field"),
    NOT_BLANK_VALUE(400, "Bad Request", "Value cannot be black. Please provide a valid value for the required field"),
    UNAUTHORIZED(401, "Unauthorized", "Not valid credentials, check email or password"),
    NOT_FOUND(404, "Not Found", "Resource not found"),
    RESOURCE_NOT_AVAILABLE(404, "Not Found", "Resource not available"),

    ERROR(500, "Internal Server Error", "Oops... Something went wrong, check server logs"),
    ERROR_TO_CREATE(500, "Internal Server Error", "Oops... Something went wrong, resource could not be created"),
    INTERNAL_SERVER_ERROR(500, "Internal Server Error", "An unexpected error occurred while processing the request. Please try again later or contact support"),
    ;

    private final Integer statusCode;
    private final String errorCode;
    private final String message;

    MocaErrorCode(Integer statusCode, String errorCode, String message) {
        this.statusCode = statusCode;
        this.errorCode = errorCode;
        this.message = message;
    }
}

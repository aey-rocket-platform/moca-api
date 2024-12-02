package org.aey.common.entities.errors;

import lombok.Getter;

@Getter
public enum MOCAErrorCodes {

    BAD_REQUEST("MOCA-SYS-ERR001", 400, "Bad Request", "Invalid request format. Please check the request body"),
    UNIQUENESS_RULE("MOCA-SYSERR002", 400, "Bad Request", "Insertion error. This element already exists"),
    NOT_NULL_VALUE("MOCA-SYS-ERR003", 400, "Bad Request", "Value cannot be null. Please provide a valid value for the required field"),
    NOT_BLANK_VALUE("MOCA-SYS-ERR004", 400, "Bad Request", "Value cannot be black. Please provide a valid value for the required field"),
    UNAUTHORIZED("MOCA-SYS-ERR005", 401, "Unauthorized", "Not valid credentials, check email or password"),
    NOT_FOUND("MOCA-SYS-ERR006", 404, "Not Found", "Resource not found"),
    RESOURCE_NOT_AVAILABLE("MOCA-SYS-ERR007", 404, "Not Found", "Resource not available"),

    ERROR("MOCA-SYS-ERR008", 500, "Internal Server Error", "Oops... Something went wrong, check server logs"),
    ERROR_TO_CREATE("MOCA-SYS-ERR009", 500, "Internal Server Error", "Oops... Something went wrong, resource could not be created"),
    INTERNAL_SERVER_ERROR("MOCA-SYS-ERR010", 500, "Internal Server Error", "An unexpected error occurred while processing the request. Please try again later or contact support"),

    //Role Error Codes
    ROLE_NOT_FOUND("MOCA-ROL-ERR001", 404, "Not Found", "User not found"),
    ROLE_NOT_AVAILABLE("MOCA-ROL-ERR002", 400, "Bad Request", "User not available"),
    ROLE_ERROR_TO_CREATE("MOCA-ROL-ERR003", 500, "Internal Server Error", "Oops... Something went wrong, user could not be created"),


    //User Error Codes
    USER_NOT_FOUND("MOCA-USR-ERR001", 404, "Not Found", "User not found"),
    USER_NOT_AVAILABLE("MOCA-USR-ERR002", 400, "Bad Request", "User not available"),
    USER_ERROR_TO_CREATE("MOCA-USR-ERR003", 500, "Internal Server Error", "Oops... Something went wrong, user could not be created"),

    ;

    private final String mocaErrorCode;
    private final Integer httpStatusCode;
    private final String httpErrorCode;
    private final String message;

    MOCAErrorCodes(String mocaErrorCode, Integer httpStatusCode, String httpErrorCode, String message) {
        this.mocaErrorCode = mocaErrorCode;
        this.httpStatusCode = httpStatusCode;
        this.httpErrorCode = httpErrorCode;
        this.message = message;
    }
}

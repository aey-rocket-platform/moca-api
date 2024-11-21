package org.aey.user.domain.enums;

import lombok.Getter;

@Getter
public enum AccountStatus {
    ACTIVE("ACTIVE"),
    INACTIVE("INACTIVE"),
    DELETED("DELETED"),
    BLOCKED("BLOCKED"),
    RESTRICTED("RESTRICTED")
    ;

    private final String status;
    AccountStatus(String status) {
        this.status = status;
    }
}

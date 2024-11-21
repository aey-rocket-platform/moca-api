package org.aey.user.domain.enums;

import lombok.Getter;

@Getter
public enum RoleTypes {
    ADMIN_ROLE("ADMIN_ROLE", "The Admin role oversees system operations, manages user accounts and permissions, ensures data integrity, and maintains overall application functionality."),
    MANAGER_ROLE("MANAGER_ROLE", "Supervises teams and workflows, monitors performance, manages resources, and ensures tasks are completed efficiently to achieve organizational goals."),
    EMPLOYEE_ROLE("EMPLOYEE_ROLE", "Executes assigned tasks and responsibilities, collaborates with the team, and contributes to achieving the company's objectives."),
    CUSTOMER_ROLE("CUSTOMER_ROLE", "Accesses products or services, places orders, provides feedback, and interacts with the application to fulfill their needs."),
    GUEST_ROLE("GUEST_ROLE", "Temporarily interacts with the application, typically with limited access and without needing an account, often to explore or preview features."),
    ;

    private final String roleName;
    private final String description;
    RoleTypes(String roleName, String description) {
        this.roleName = roleName;
        this.description = description;
    }
}

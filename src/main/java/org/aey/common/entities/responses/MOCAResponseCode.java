package org.aey.common.entities.responses;

import lombok.Getter;

@Getter
public enum MOCAResponseCode {

    //Roles
    GET_ROLE_BY_ID(200, "Get role", "Role retrieved successfully"),
    CREATE_ROLE(201, "Create role", "Role created successfully"),

    //Users
    GET_ACCOUNT(200, "Get account", "Account retrieved successfully"),
    CREATE_ACCOUNT(201, "Create account", "Account created successfully"),

    //Users
    GET_USER(200, "Get user", "User retrieved successfully"),
    CREATE_USER(201, "Create user", "User created successfully"),

    //Products
    DISABLE_PRODUCT(200, "Product disabled", "Product was disabled successfully"),
    ENABLE_PRODUCT(200, "Product enabled", "Product was enable successfully"),
    PRODUCT_CATEGORY_ASSOCIATION(200, "Category associated", "Categories have been correctly associated with the product"),
    PRODUCT_CATEGORY_REMOVE(200, "Category removed", "Categories have been correctly removed with the product"),
    CREATE_PRODUCT(201, "Product created", "Product was successfully created"),
    UPDATE_PRODUCT(200, "Product updated", "Product was successfully updated"),

    //Product image
    PRODUCT_IMAGE_UPLOADED(201, "Product image uploaded", "Product image was successfully uploaded"),
    PRODUCT_IMAGE_DELETED(200, "Product image deleted", "Product image was successfully uploaded"),

    //Categories
    UPDATE_CATEGORY(200, "Update category", "Category was successfully updated"),
    DISABLE_CATEGORY(200, "Disable category", "Category was disabled successfully"),
    CREATE_CATEGORY(201, "Create category", "Category was successfully created"),
    ;

    private final Integer statusCode;
    private final String action;
    private final String message;
    MOCAResponseCode(Integer statusCode, String action, String message) {
        this.statusCode = statusCode;
        this.action = action;
        this.message = message;
    }
}

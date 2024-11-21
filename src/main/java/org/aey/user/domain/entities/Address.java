package org.aey.user.domain.entities;

import lombok.*;

import java.util.Date;

@Builder
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private String addressId;
    private String country;
    private String city;
    private String street;
    private String number;
    private String zipCode;
    private Date createdAt;
    private Date updatedAt;
    private Boolean isActive;
}

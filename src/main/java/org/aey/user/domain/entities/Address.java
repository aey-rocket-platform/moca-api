package org.aey.user.domain.entities;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

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

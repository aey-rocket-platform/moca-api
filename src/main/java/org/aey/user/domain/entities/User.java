package org.aey.user.domain.entities;

import lombok.*;

import java.util.Date;

@Builder
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String userId;
    private String name;
    private String firstSurname;
    private String secondSurname;
    private Date birthDate;
    private Date createdAt;
    private Date updatedAt;
    private Boolean isActive;
}

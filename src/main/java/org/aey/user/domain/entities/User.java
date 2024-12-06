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
public class User {
    private String userId;
    private String name;
    private String firstSurname;
    private String secondSurname;
    private Date birthDate;
    private Date createdAt;
    private Date updatedAt;
    private Boolean isActive;
    private Long genderId;
}

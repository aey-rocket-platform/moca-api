package org.aey.user.infrastructure.persistence.jpa;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.aey.user.domain.entities.User;
import org.aey.user.infrastructure.persistence.queries.UserQueryManager;

import java.util.Date;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = UserQueryManager.USER_TABLE_NAME)
public class UserJpa {

    @Id
    @Column(
            name = UserQueryManager.USER_ID,
            unique = true,
            nullable = false,
            length = 21
    )
    private String userId;

    @Column(name = UserQueryManager.USER_NAME)
    private String name;

    @Column(name = UserQueryManager.USER_FIRST_NAME)
    private String firstSurname;

    @Column(name = UserQueryManager.USER_SECOND_SURNAME)
    private String secondSurname;

    @Column(name = UserQueryManager.USER_BIRTHDATE)
    private Date birthDate;

    @Column(name = UserQueryManager.USER_CREATED_AT)
    private Date createdAt;

    @Column(name = UserQueryManager.USER_UPDATED_AT)
    private Date updatedAt;

    @Column(name = UserQueryManager.USER_IS_ACTIVE)
    private Boolean isActive;

    @Column(name = UserQueryManager.USER_GENDER_ID)
    private Long genderId;

    @Column(name = UserQueryManager.USER_ROLE_ID)
    private Long roleId;

    public static UserJpa fromEntity(User entity) {
        return UserJpa.builder()
                .userId(entity.getUserId())
                .name(entity.getName())
                .firstSurname(entity.getFirstSurname())
                .secondSurname(entity.getSecondSurname())
                .birthDate(entity.getBirthDate())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .isActive(entity.getIsActive())
                .genderId(entity.getGenderId())
                .build();
    }

    public User toEntity() {
        return User.builder()
                .userId(userId)
                .name(name)
                .firstSurname(firstSurname)
                .secondSurname(secondSurname)
                .birthDate(birthDate)
                .createdAt(createdAt)
                .updatedAt(updatedAt)
                .isActive(isActive)
                .genderId(genderId)
                .build();
    }
}

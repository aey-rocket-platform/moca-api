package org.aey.user.infrastructure.persistence.jpa;

import jakarta.persistence.*;
import lombok.*;
import org.aey.user.domain.entities.User;
import org.aey.user.infrastructure.persistence.queries.UserQueryManager;
import org.hibernate.annotations.GenericGenerator;

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
    @GeneratedValue(generator = "nano-id")
    @GenericGenerator(
            name = "nano-id",
            strategy = "org.aey.common.utils.nanoid.strategies.NanoIdGenerator"
    )
    @Column(
            name = UserQueryManager.USER_ID,
            unique = true,
            nullable = false,
            length = 21
    )
    private Long userId;

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
                .build();
    }
}

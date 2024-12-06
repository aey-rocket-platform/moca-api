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
public class UserAccount {
    private String userId;
    private String name;
    private String firstSurname;
    private String secondSurname;
    private Date birthDate;
    private Date createdAt;
    private Date updatedAt;
    private Boolean isActive;
    private Long genderId;
    private Account account;

    public static UserAccount fromEntity(User user, Account account) {
        return UserAccount.builder()
                .userId(user.getUserId())
                .name(user.getName())
                .firstSurname(user.getFirstSurname())
                .secondSurname(user.getSecondSurname())
                .birthDate(user.getBirthDate())
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                .isActive(user.getIsActive())
                .genderId(user.getGenderId())
                .account(account)
                .build();
    }
}

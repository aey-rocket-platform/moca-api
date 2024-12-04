package org.aey.user.infrastructure.rest.dto.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.aey.user.domain.entities.UserAccount;
import org.aey.user.infrastructure.rest.dto.account.AccountDto;

import java.util.Date;

@Builder
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAccountDto {

    @JsonProperty
    private String userId;

    @JsonProperty
    private String name;

    @JsonProperty
    private String firstSurname;

    @JsonProperty
    private String secondSurname;

    @JsonProperty
    private Date birthDate;

    @JsonProperty
    private Date createdAt;

    @JsonProperty
    private Date updatedAt;

    @JsonProperty
    private Boolean isActive;

    @JsonProperty
    private AccountDto account;

    public static UserAccountDto fromEntity(UserAccount entity) {
        return UserAccountDto.builder()
                .userId(entity.getUser().getUserId())
                .name(entity.getUser().getName())
                .firstSurname(entity.getUser().getFirstSurname())
                .secondSurname(entity.getUser().getSecondSurname())
                .birthDate(entity.getUser().getBirthDate())
                .createdAt(entity.getUser().getCreatedAt())
                .updatedAt(entity.getUser().getUpdatedAt())
                .isActive(entity.getUser().getIsActive())
                .account(AccountDto.fromEntity(entity.getAccount()))
                .build();
    }
}

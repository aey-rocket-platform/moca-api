package org.aey.user.infrastructure.rest.dto.account;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.aey.user.domain.entities.Account;
import org.aey.user.domain.entities.UserImage;

import java.util.Date;
import java.util.List;

@Builder
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {
    @JsonProperty
    private String accountId;
    @JsonProperty
    private String nickname;
    @JsonProperty
    private String email;
    @JsonProperty
    private String backupEmail;
    @JsonProperty
    private String password;
    @JsonProperty
    private String mobilePhone;
    @JsonProperty
    private String phoneNumber;
    @JsonProperty
    private String status;
    @JsonProperty
    private List<UserImage> images;
    @JsonProperty
    private Date createdAt;
    @JsonProperty
    private Date updatedAt;
    @JsonProperty
    private Boolean isActive;

    public static AccountDto fromEntity(Account account) {
        return AccountDto.builder()
                .accountId(account.getAccountId())
                .nickname(account.getNickname())
                .email(account.getEmail())
                .backupEmail(account.getBackupEmail())
                .password(account.getPassword())
                .mobilePhone(account.getMobilePhone())
                .phoneNumber(account.getPhoneNumber())
                .status(account.getStatus())
                .createdAt(account.getCreatedAt())
                .updatedAt(account.getUpdatedAt())
                .isActive(account.getIsActive())
                .build();
    }
}

package org.aey.user.infrastructure.rest.dto.account;


import lombok.*;
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
    private String accountId;
    private String email;
    private String backupEmail;
    private String password;
    private String mobilePhone;
    private String phoneNumber;
    private String status;
    private List<UserImage> images;
    private Date createdAt;
    private Date updatedAt;
    private Boolean isActive;

    public static AccountDto fromEntity(Account account) {
        return AccountDto.builder()
                .accountId(account.getAccountId())
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

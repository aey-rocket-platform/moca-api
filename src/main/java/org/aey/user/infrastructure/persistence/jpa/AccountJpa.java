package org.aey.user.infrastructure.persistence.jpa;

import jakarta.persistence.*;
import lombok.*;
import org.aey.user.domain.entities.Account;
import org.aey.user.domain.entities.UserImage;
import org.aey.user.infrastructure.persistence.queries.AccountQueryManager;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = AccountQueryManager.ACCOUNT_TABLE_NAME)
public class AccountJpa {

    @Id
    @Column(name = AccountQueryManager.ACCOUNT_ID)
    private String accountId;

    @Column(name = AccountQueryManager.ACCOUNT_NICKNAME)
    private String nickname;

    @Column(name = AccountQueryManager.ACCOUNT_EMAIL)
    private String email;

    @Column(name = AccountQueryManager.ACCOUNT_BACKUP_EMAIL)
    private String backupEmail;

    @Column(name = AccountQueryManager.ACCOUNT_PASSWORD)
    private String password;

    @Column(name = AccountQueryManager.ACCOUNT_MOBILE_PHONE)
    private String mobilePhone;

    @Column(name = AccountQueryManager.ACCOUNT_PHONE_NUMBER)
    private String phoneNumber;

    @Column(name = AccountQueryManager.ACCOUNT_STATUS)
    private String status;

    //TODO: Add list user images
    //@Column(name = AccountQueryManager.ACCOUNT_IMAGES)
    //private List<UserImage> images;

    @Column(name = AccountQueryManager.ACCOUNT_CREATED_AT)
    private Date createdAt;

    @Column(name = AccountQueryManager.ACCOUNT_UPDATED_AT)
    private Date updatedAt;

    @Column(name = AccountQueryManager.ACCOUNT_IS_ACTIVE)
    private Boolean isActive;

    public static AccountJpa fromEntity(Account account) {
        return AccountJpa.builder()
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

    public Account toEntity() {
        return Account.builder()
                .accountId(accountId)
                .nickname(nickname)
                .email(email)
                .backupEmail(backupEmail)
                .password(password)
                .mobilePhone(mobilePhone)
                .phoneNumber(phoneNumber)
                .status(status)
                .createdAt(createdAt)
                .updatedAt(updatedAt)
                .isActive(isActive)
                .build();
    }
}

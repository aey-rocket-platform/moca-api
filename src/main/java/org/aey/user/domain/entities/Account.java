package org.aey.user.domain.entities;

import lombok.*;

import java.util.Date;
import java.util.List;

@Builder
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
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
}

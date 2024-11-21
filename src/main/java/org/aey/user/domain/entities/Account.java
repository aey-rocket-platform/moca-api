package org.aey.user.domain.entities;

import lombok.*;

import java.util.ArrayList;
import java.util.Date;

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
    private ArrayList<UserImage> images;
    private Date createdAt;
    private Date updatedAt;
    private Boolean isActive;
}

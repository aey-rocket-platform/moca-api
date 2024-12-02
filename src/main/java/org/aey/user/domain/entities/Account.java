package org.aey.user.domain.entities;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

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

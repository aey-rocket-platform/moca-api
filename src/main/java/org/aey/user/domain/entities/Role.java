package org.aey.user.domain.entities;

import lombok.*;

import java.util.Date;

@Builder
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    private String roleId;
    private String roleName;
    private String description;
    private Date createdAt;
    private Date updatedAt;
    private Boolean isActive;
}

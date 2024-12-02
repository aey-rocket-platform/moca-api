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
public class Role {
    private Long roleId;
    private String roleType;
    private Date createdAt;
    private Date updatedAt;
    private Boolean isActive;
}

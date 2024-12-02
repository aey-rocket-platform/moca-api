package org.aey.user.infrastructure.persistence.jpa;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.aey.user.domain.entities.Role;
import org.aey.user.infrastructure.persistence.queries.RoleQueryManager;

import java.util.Date;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = RoleQueryManager.ROLE_TABLE_NAME)
public class RoleJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = RoleQueryManager.ROLE_ID)
    private Long roleId;

    @Column(name = RoleQueryManager.ROLE_TYPE)
    private String roleType;

    @Column(name = RoleQueryManager.ROLE_CREATED_AT)
    private Date createdAt;

    @Column(name = RoleQueryManager.ROLE_UPDATED_AT)
    private Date updatedAt;

    @Column(name = RoleQueryManager.ROLE_IS_ACTIVE)
    private Boolean isActive;

    public static RoleJpa fromEntity(Role entity) {
        return RoleJpa.builder()
                .roleId(entity.getRoleId())
                .roleType(entity.getRoleType())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .isActive(entity.getIsActive())
                .build();
    }

    public Role toEntity() {
        return Role.builder()
                .roleId(roleId)
                .roleType(roleType)
                .createdAt(createdAt)
                .updatedAt(updatedAt)
                .isActive(isActive)
                .build();
    }
}

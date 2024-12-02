package org.aey.user.infrastructure.rest.dto.role;



import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.aey.user.domain.entities.Role;

import java.util.Date;

@Builder
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleDto {

    @JsonProperty
    private Long roleId;

    @JsonProperty
    private String roleType;

    @JsonProperty
    private Date createdAt;

    @JsonProperty
    private Date updatedAt;

    @JsonProperty
    private Boolean isActive;

    public static RoleDto fromEntity(Role role) {
        return RoleDto.builder()
                .roleId(role.getRoleId())
                .roleType(role.getRoleType())
                .createdAt(role.getCreatedAt())
                .updatedAt(role.getUpdatedAt())
                .isActive(role.getIsActive())
                .build();
    }
}

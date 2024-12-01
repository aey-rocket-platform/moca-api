package org.aey.user.infrastructure.rest.dto.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.aey.user.domain.entities.User;

import java.util.Date;

@Builder
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    @JsonProperty
    private String userId;

    @JsonProperty
    private String name;

    @JsonProperty
    private String firstSurname;

    @JsonProperty
    private String secondSurname;

    @JsonProperty
    private Date birthDate;

    @JsonProperty
    private Date createdAt;

    @JsonProperty
    private Date updatedAt;

    @JsonProperty
    private Boolean isActive;

    public static UserDto fromEntity(User entity) {
        return UserDto.builder()
                .userId(entity.getUserId())
                .name(entity.getName())
                .firstSurname(entity.getFirstSurname())
                .secondSurname(entity.getSecondSurname())
                .birthDate(entity.getBirthDate())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .isActive(entity.getIsActive())
                .build();
    }
}

package org.aey.user.infrastructure.rest.dto.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.Date;

@Builder
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserDto {
    //TODO: Add missing account, role and gender fields
    @JsonProperty
    private String name;

    @JsonProperty
    private String firstSurname;

    @JsonProperty
    private String secondSurname;

    @JsonProperty
    private Date birthDate;
}

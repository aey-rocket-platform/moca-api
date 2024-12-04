package org.aey.user.infrastructure.rest.dto.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.aey.user.infrastructure.rest.dto.account.CreateAccountDto;

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

    @JsonProperty
    private Long gender;

    @JsonProperty
    private CreateAccountDto account;
}

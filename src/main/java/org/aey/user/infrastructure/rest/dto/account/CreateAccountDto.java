package org.aey.user.infrastructure.rest.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.aey.user.domain.entities.UserImage;

import java.util.Date;
import java.util.List;

@Builder
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateAccountDto {
    @JsonProperty
    private String nickname;
    @JsonProperty
    private String email;
    @JsonProperty
    private String backupEmail;
    @JsonProperty
    private String password;
    @JsonProperty
    private String mobilePhone;
    @JsonProperty
    private String phoneNumber;
    //private List<UserImage> images;
}

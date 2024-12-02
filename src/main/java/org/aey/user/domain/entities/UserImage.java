package org.aey.user.domain.entities;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Builder
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserImage {
    private String url;
    private String description;
}

package org.aey.user.domain.entities;

import lombok.*;

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

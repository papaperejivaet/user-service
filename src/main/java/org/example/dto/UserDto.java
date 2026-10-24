package org.example.dto;



import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.lang.NonNull;

import java.util.UUID;


@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Accessors(chain = true)
public class UserDto extends BaseDto
{
    private String username;
    private String firstName;
    private String avatarUrl;
}

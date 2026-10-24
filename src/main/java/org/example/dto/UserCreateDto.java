package org.example.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.example.common.constant.Constraint;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class UserCreateDto
{


    @NotBlank(message = Constraint.Field.EMAIL_FIELD + Constraint.DEFAULT_NOT_BLANK_MESSAGE)
    @Email(message = "Некорректный формат email")
    @Size(max = Constraint.MAX_EMAIL_FIELD_LENGTH,
            message = Constraint.Field.EMAIL_FIELD + Constraint.EMAIL_OVERFLOW_MESSAGE)
    private String email;

    @NotBlank(message = Constraint.Field.USERNAME_FIELD + Constraint.DEFAULT_NOT_BLANK_MESSAGE)
    @Size(max = Constraint.MAX_FIELD_LENGTH,
            message = Constraint.Field.USERNAME_FIELD + Constraint.DEFAULT_OVERFLOW_MESSAGE)
    private String username;

    @NotBlank(message = Constraint.Field.NAME_FIELD + Constraint.DEFAULT_NOT_BLANK_MESSAGE)
    @Size(max = Constraint.MAX_EMAIL_FIELD_LENGTH,
            message = Constraint.Field.NAME_FIELD + Constraint.DEFAULT_OVERFLOW_MESSAGE)
    private String firstName;

    @NotBlank(message = Constraint.Field.LAST_NAME_FIELD + Constraint.DEFAULT_NOT_BLANK_MESSAGE)
    @Size(max = Constraint.MAX_EMAIL_FIELD_LENGTH,
            message = Constraint.Field.LAST_NAME_FIELD + Constraint.DEFAULT_OVERFLOW_MESSAGE)
    private String lastName;

}

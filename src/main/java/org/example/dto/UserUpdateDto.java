package org.example.dto;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.example.common.constant.Constraint;

@Data
@NoArgsConstructor
@Accessors(chain = true)
/*
ToDo
    Добавить логику для того,
    чтобы отличать «не менять поле» от «очистить поле»
    в случае частичного апдейта юзера
 */
public class UserUpdateDto
{
    @Size(max = Constraint.MAX_FIELD_LENGTH,
            message = Constraint.Field.USERNAME_FIELD + Constraint.DEFAULT_OVERFLOW_MESSAGE)
    private String username;

    @Size(max = Constraint.MAX_EMAIL_FIELD_LENGTH,
            message = Constraint.Field.NAME_FIELD + Constraint.DEFAULT_OVERFLOW_MESSAGE)
    private String firstName;

    @Size(max = Constraint.MAX_EMAIL_FIELD_LENGTH,
            message = Constraint.Field.LAST_NAME_FIELD + Constraint.DEFAULT_OVERFLOW_MESSAGE)
    private String lastName;

    @Pattern(
            regexp = "^(?:\\+7|8)[\\s-]?\\(?\\d{3}\\)?[\\s-]?\\d{3}(?:[\\s-]?\\d{2}){2}$",
            message = "Некорректный номер телефона"
    )
    private String phoneNumber;

    @Size(max = 2048, message = "Размер фотографии не должен превышать 2048 символов")
    private String avatarUrl;

}

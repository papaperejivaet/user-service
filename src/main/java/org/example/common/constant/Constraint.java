package org.example.common.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Constraint
{
    public static final int MAX_FIELD_LENGTH = 30;
    public static final int MAX_EMAIL_FIELD_LENGTH = 255;

    public static final String DEFAULT_NOT_BLANK_MESSAGE = " не должно быть пустым";
    public static final String DEFAULT_OVERFLOW_MESSAGE =
            " не должно превышать " + MAX_FIELD_LENGTH + " символов";
    public static final String EMAIL_OVERFLOW_MESSAGE =
            " не должно превышать " + MAX_EMAIL_FIELD_LENGTH + " символов";

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class Field
    {
        public static final String EMAIL_FIELD = "Поле Email";
        public static final String USERNAME_FIELD = "Поле Username";
        public static final String NAME_FIELD = "Поле Имя";
        public static final String LAST_NAME_FIELD = "Поле Фамилия";
    }
}

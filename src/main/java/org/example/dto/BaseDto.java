package org.example.dto;

import lombok.*;

import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor
public class BaseDto
{
    private UUID id;

    @Override
    public String toString()
    {
        return getClass().getSimpleName() + ":" + id;
    }

    @Override
    public boolean equals(Object o)
    {
        if (o == null || getClass() != o.getClass())
            return false;

        BaseDto baseDto = (BaseDto) o;
        return Objects.equals(id, baseDto.id);
    }

    @Override
    public int hashCode()
    {
        return Objects.hashCode(id);
    }
}

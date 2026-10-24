package org.example.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Accessors(chain = true)
public class UserResponseDto extends BaseDto
{
    private String email;
    private String username;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String avatarUrl;
    private String position;
    private String department;
    private boolean isActive;
    private boolean isEmailVerified;
    private LocalDateTime lastLoginAt;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

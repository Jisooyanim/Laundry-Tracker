package project.LaundryTracker.dto;

import lombok.*;

import project.LaundryTracker.enums.Role;
import project.LaundryTracker.enums.UserStatus;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponseDTO extends BaseModelDTO{
    private Long id;
    private String username;
    private String fullName;
    private String email;
    private Role role;
    private UserStatus status;
}
package project.LaundryTracker.model;

import jakarta.persistence.*;
import lombok.*;

import project.LaundryTracker.enums.Role;
import project.LaundryTracker.enums.UserStatus;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
//@Table(name="users")
public class User {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(nullable=false, name="user_id")
    private Long id;
    
    @Column(nullable=false, unique=true, name="username")
    private String username;

    @Column(nullable=false, name="password")
    private String password; // Stored as hashed string (e.g., BCrypt)

    @Column(name="email")
    private String email;

    @Column(name="full_name")
    private String fullName;

    @Enumerated(EnumType.STRING)
    @Column(nullable=false, name="role")
    private Role role;

    @Enumerated(EnumType.STRING)
    @Column(name="user_status")
    private UserStatus status;
}
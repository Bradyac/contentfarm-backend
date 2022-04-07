package ca.bradyac.contentfarm.model.entity;

import ca.bradyac.contentfarm.model.Role;
import lombok.*;

import javax.persistence.*;
import java.time.Instant;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Builder
@AllArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String username;

    private String password;

    private String email;

    @Enumerated(EnumType.STRING)
    private Role role;

    private boolean verified;

    private Instant created;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User u = (User) o;
        return id == u.id && verified == u.verified && Objects.equals(username, u.username) && Objects.equals(password, u.password) && Objects.equals(email, u.email) && role == u.role && Objects.equals(created, u.created);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, email, role, verified, created);
    }
}

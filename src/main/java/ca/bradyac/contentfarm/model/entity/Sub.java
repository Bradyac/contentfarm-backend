package ca.bradyac.contentfarm.model.entity;

import lombok.*;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;
import java.util.Objects;

import static javax.persistence.FetchType.LAZY;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Builder
@AllArgsConstructor
@Entity
public class Sub {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ToString.Exclude
    private User user;

    @OneToMany(fetch = LAZY)
    @ToString.Exclude
    private List<Post> posts;

    private Instant created;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sub s = (Sub) o;
        return Objects.equals(id, s.id) && Objects.equals(name, s.name) && Objects.equals(description, s.description) && Objects.equals(user, s.user) && Objects.equals(posts, s.posts) && Objects.equals(created, s.created);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, user, posts, created);
    }
}

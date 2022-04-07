package ca.bradyac.contentfarm.model.entity;

import lombok.*;

import javax.persistence.*;
import java.time.Instant;
import java.util.Objects;

import static javax.persistence.FetchType.LAZY;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Builder
@AllArgsConstructor
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String text;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "post_id", referencedColumnName = "id")
    @ToString.Exclude
    private Post post;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ToString.Exclude
    private User user;

    private Instant created;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment c = (Comment) o;
        return id == c.id && Objects.equals(text, c.text) && Objects.equals(post, c.post) && Objects.equals(user, c.user) && Objects.equals(created, c.created);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, text, post, user, created);
    }
}

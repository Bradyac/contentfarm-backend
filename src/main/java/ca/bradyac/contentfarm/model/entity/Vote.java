package ca.bradyac.contentfarm.model.entity;

import ca.bradyac.contentfarm.model.VoteType;
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
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    private VoteType voteType;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "post_id", referencedColumnName = "id")
    @ToString.Exclude
    private Post post;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "comment_id", referencedColumnName = "id")
    @ToString.Exclude
    private Comment comment;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ToString.Exclude
    private User user;

    private Instant created;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vote v = (Vote) o;
        return id == v.id && voteType == v.voteType && Objects.equals(post, v.post) && Objects.equals(comment, v.comment) && Objects.equals(user, v.user) && Objects.equals(created, v.created);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, voteType, post, comment, user, created);
    }
}

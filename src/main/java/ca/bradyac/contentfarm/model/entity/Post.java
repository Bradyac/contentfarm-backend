package ca.bradyac.contentfarm.model.entity;

import ca.bradyac.contentfarm.model.ContentType;
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
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @Lob
    private String content;

    @Enumerated(EnumType.STRING)
    private ContentType contentType;

    private String url;

    private long voteCount = 0;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "sub_id", referencedColumnName = "id")
    @ToString.Exclude
    private Sub sub;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    private Instant created;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post p = (Post) o;
        return id == p.id && voteCount == p.voteCount && Objects.equals(name, p.name) && Objects.equals(content, p.content) && contentType == p.contentType && Objects.equals(url, p.url) && Objects.equals(sub, p.sub) && Objects.equals(user, p.user) && Objects.equals(created, p.created);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, content, contentType, url, voteCount, sub, user, created);
    }
}

package ca.bradyac.contentfarm.model.entity;

import ca.bradyac.contentfarm.model.ContentType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.time.Instant;

import static javax.persistence.FetchType.LAZY;

@Data
@Builder
@NoArgsConstructor
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
    private Sub sub;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    private Instant created;
}

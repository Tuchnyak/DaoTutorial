package ru.levelup.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "POST")
public class Post implements Serializable {

    @Id
    @Column(name = "POST_ID")
    @SequenceGenerator (name = "post_seq", sequenceName = "post_id_seq")
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "post_seq")
    private long postId;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "TEXT")
    private String text;

    @Column(name = "POSTED_AT", nullable = false)
    private Date postedAt;

    /********************************/
    @ManyToOne
    @JoinColumn (name = "USER_ID", referencedColumnName = "USER_ID")
    private User author;

    @OneToMany (mappedBy = "commentedPost")
    private Set<Comment> comments;

    @ManyToMany (mappedBy = "posts")
    private Set<Category> categories;

}

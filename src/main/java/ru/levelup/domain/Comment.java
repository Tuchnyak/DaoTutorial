package ru.levelup.domain;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "COMMENT")
public class Comment implements Serializable {

    @Id
    @Column(name = "COMMENT_ID")
    @SequenceGenerator(name = "comment_seq", sequenceName = "comment_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comment_seq")
    private long commentId;

    @Column(name = "TEXT", nullable = false, length = 300)
    private String text;

    @Column(name = "COMMENTED_AT", nullable = false)
    private Date commentedAt;

    /********************************/

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User author;

    @ManyToOne
    @JoinColumn(name = "POST_ID")
    private Post commentedPost;
}

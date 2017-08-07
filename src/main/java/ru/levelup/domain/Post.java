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

    /********************************/
    public long getPostId() {
        return postId;
    }

    public void setPostId(long postId) {
        this.postId = postId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getPostedAt() {
        return postedAt;
    }

    public void setPostedAt(Date postedAt) {
        this.postedAt = postedAt;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }
}

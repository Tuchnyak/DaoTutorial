package ru.levelup.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "CATEGORY")
public class Category implements Serializable {

    @Id
    @Column(name = "CATEGORY_ID")
    @SequenceGenerator(name = "category_seq", sequenceName = "category_id_seq")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "category_seq")
    private int categoryId;

    @Column (name = "NAME", nullable = false, unique = true)
    private String name;

    //*********************************//

    @ManyToMany
    @JoinTable(name = "POST_CATEGORY",
            joinColumns = @JoinColumn(name = "CATEGORY_ID"),
            inverseJoinColumns = @JoinColumn(name = "POST_ID")
    )
    private Set<Post> posts;

}

package ru.levelup.dao;

import ru.levelup.domain.Post;

import java.util.Date;

public interface PostDao {

    Post createPost (String title, String text, Date postedAt);

}

package ru.levelup.dao;

import ru.levelup.domain.Comment;

import java.util.Date;

public interface CommentDao {

    Comment createComment (String text, Date commentedAt);

}

package bsuir.course.project.Interfaces;

import bsuir.course.project.Entity.Car;
import bsuir.course.project.Entity.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentService
{
    void createComment(Comment comment);
    void deleteComment(Comment comment);
    void deleteCommentById(Integer id);
    void updateComment(Comment comment);
    List<Comment> getAllComments();
    Optional<Comment> getCommentById(Integer id);
}

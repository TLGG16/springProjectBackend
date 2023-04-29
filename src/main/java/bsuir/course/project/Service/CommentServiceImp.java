package bsuir.course.project.Service;

import bsuir.course.project.Entity.Comment;
import bsuir.course.project.Interfaces.CommentService;
import bsuir.course.project.Repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImp implements CommentService
{
    @Autowired
    private CommentRepository commentRepository;

    @Override
    public void createComment(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public void deleteComment(Comment comment) {
        commentRepository.delete(comment);
    }

    @Override
    public void deleteCommentById(Integer id) {
        commentRepository.deleteById(id);
    }

    @Override
    public void updateComment(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    @Override
    public Optional<Comment> getCommentById(Integer id) {
        return commentRepository.findById(id);
    }
}

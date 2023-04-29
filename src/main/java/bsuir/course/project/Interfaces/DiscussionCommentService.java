package bsuir.course.project.Interfaces;

import bsuir.course.project.Entity.Advert;
import bsuir.course.project.Entity.DiscussionComment;
import bsuir.course.project.Entity.User;

import java.util.List;
import java.util.Optional;

public interface DiscussionCommentService {
    void createDiscussionComment(DiscussionComment discussionComment);
    void deleteDiscussionComment(DiscussionComment discussionComment);
    void deleteDiscussionCommentById(Integer id);
    void updateDiscussionComment(DiscussionComment discussionComment);
    List<DiscussionComment> getAllDiscussionComments();
    Optional<DiscussionComment> getDiscussionCommentById(Integer id);
}

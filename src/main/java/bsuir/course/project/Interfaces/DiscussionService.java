package bsuir.course.project.Interfaces;

import bsuir.course.project.Entity.Comment;
import bsuir.course.project.Entity.Discussion;

import java.util.List;
import java.util.Optional;

public interface DiscussionService {
    void createDiscussion(Discussion discussion);
    void deleteDiscussion(Discussion discussion);
    void deleteDiscussionById(Integer id);
    void updateDiscussion(Discussion discussion);
    List<Discussion> getAllDiscussions();
    Optional<Discussion> getDiscussionById(Integer id);
}

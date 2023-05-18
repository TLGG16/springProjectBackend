package bsuir.course.project.Service;

import bsuir.course.project.Entity.DiscussionComment;
import bsuir.course.project.Entity.User;
import bsuir.course.project.Interfaces.DiscussionCommentService;
import bsuir.course.project.Repository.DiscussionCommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class DiscussionCommentServiceImp implements DiscussionCommentService {
    @Autowired
    private DiscussionCommentRepository discussionCommentRepository;

    @Override
    public List<DiscussionComment> getDiscussionCommentsByDiscussionId(Integer id) {
       List<DiscussionComment> discussionCommentList = discussionCommentRepository.findAll();
       List<DiscussionComment> answ = new ArrayList<>();
        for (DiscussionComment com: discussionCommentList
             ) {
            if (com.getDiscussion().getDiscussion_id().equals(id)){
                answ.add(com);
            }
        }
        return answ;
    }

    @Override
    public void createDiscussionComment(DiscussionComment discussionComment) {
        discussionCommentRepository.save(discussionComment);
    }

    @Override
    public void deleteDiscussionComment(DiscussionComment discussionComment) {
        discussionCommentRepository.delete(discussionComment);
    }

    @Override
    public void deleteDiscussionCommentById(Integer id) {
        discussionCommentRepository.deleteById(id);
    }

    @Override
    public void updateDiscussionComment(DiscussionComment discussionComment) {
        discussionCommentRepository.save(discussionComment);
    }

    @Override
    public List<DiscussionComment> getAllDiscussionComments() {
        return discussionCommentRepository.findAll();
    }

    @Override
    public Optional<DiscussionComment> getDiscussionCommentById(Integer id) {
        return discussionCommentRepository.findById(id);
    }

}

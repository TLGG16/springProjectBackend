package bsuir.course.project.Service;

import bsuir.course.project.Entity.Discussion;
import bsuir.course.project.Interfaces.DiscussionService;
import bsuir.course.project.Repository.DiscussionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DiscussionServiceImp implements DiscussionService {
    @Autowired
    private DiscussionRepository discussionRepository;

    @Override
    public void createDiscussion(Discussion discussion) {
        discussionRepository.save(discussion);
    }

    @Override
    public void deleteDiscussion(Discussion discussion) {
        discussionRepository.delete(discussion);
    }

    @Override
    public void deleteDiscussionById(Integer id) {
        discussionRepository.deleteById(id);
    }

    @Override
    public void updateDiscussion(Discussion discussion) {
        discussionRepository.save(discussion);
    }

    @Override
    public List<Discussion> getAllDiscussions() {
        return discussionRepository.findAll();
    }

    @Override
    public Optional<Discussion> getDiscussionById(Integer id) {
        return discussionRepository.findById(id);
    }
}

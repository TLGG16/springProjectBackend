package bsuir.course.project.Repository;

import bsuir.course.project.Entity.DiscussionComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscussionCommentRepository extends JpaRepository<DiscussionComment, Integer> {
}

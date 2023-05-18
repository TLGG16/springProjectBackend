package bsuir.course.project.Repository;

import bsuir.course.project.Entity.DiscussionComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface DiscussionCommentRepository extends JpaRepository<DiscussionComment, Integer> {
}

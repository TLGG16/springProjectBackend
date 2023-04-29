package bsuir.course.project.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "discussion_comment")
@Data
public class DiscussionComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer discussion_comment_id;
    private String comment;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "discussion_id")
    private Discussion discussion;

    public Integer getDiscussion_comment_id() {
        return discussion_comment_id;
    }

    public void setDiscussion_comment_id(Integer discussion_comment_id) {
        this.discussion_comment_id = discussion_comment_id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Discussion getDiscussion() {
        return discussion;
    }

    public void setDiscussion(Discussion discussion) {
        this.discussion = discussion;
    }
}

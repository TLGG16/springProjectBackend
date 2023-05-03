package bsuir.course.project.Entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name = "discussion")
@Data
public class Discussion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer discussion_id;
    private String theme;
    @ManyToOne
    @JoinColumn(name = "car_id")
    @Nullable
    private Car car;

    @OneToMany(mappedBy = "discussion",cascade = CascadeType.ALL)
    private Set<DiscussionComment> discussion_comment_list;


    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public Integer getDiscussion_id() {
        return discussion_id;
    }

    public void setDiscussion_id(Integer discussion_id) {
        this.discussion_id = discussion_id;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}

package bsuir.course.project.Entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name = "user")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer user_id;
    private String login;
    private String password;
    private String role;
    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private Set<Advert> advert_list;
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private Set<Comment> comment_list;
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private Set<Favourite> favourite_list;
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private Set<DiscussionComment> discussion_comment_set;

    

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}

package bsuir.course.project.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "favourite")
@Data
public class Favourite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer favourite_id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "advert_id")
    private Advert advert;



    public Integer getFavourite_id() {
        return favourite_id;
    }

    public void setFavourite_id(Integer favourite_id) {
        this.favourite_id = favourite_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Advert getAdvert() {
        return advert;
    }

    public void setAdvert(Advert advert) {
        this.advert = advert;
    }
}

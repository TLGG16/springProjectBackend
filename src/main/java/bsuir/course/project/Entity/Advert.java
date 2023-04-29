package bsuir.course.project.Entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name = "advert")
@Data
public class Advert {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer advert_id;
    private Double price;
    private String photo_url;
    private String description;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;
    @OneToMany(mappedBy = "advert",cascade = CascadeType.ALL)
    private Set<Comment> comment_list;




    public Integer getAdvert_id() {
        return advert_id;
    }

    public void setAdvert_id(Integer advert_id) {
        this.advert_id = advert_id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getPhoto_url() {
        return photo_url;
    }

    public void setPhoto_url(String photo_url) {
        this.photo_url = photo_url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}

package bsuir.course.project.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name = "car")
@Data
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer car_id;
    private String name;
    private String model;
    private String brand;
    private String release_year;
    private String technical_info;
    private String photo_url;

    @OneToMany(mappedBy = "car",cascade = CascadeType.ALL)
    private Set<Favourite> favourite_list;
    @OneToMany(mappedBy = "car",cascade = CascadeType.ALL)
    private Set<Advert> advert_list;

    @OneToMany(mappedBy = "car",cascade = CascadeType.ALL)
    private Set<Discussion> discussion_list;



    public Integer getCar_id() {
        return car_id;
    }

    public void setCar_id(Integer car_id) {
        this.car_id = car_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getRelease_year() {
        return release_year;
    }

    public void setRelease_year(String release_year) {
        this.release_year = release_year;
    }

    public String getTechnical_info() {
        return technical_info;
    }

    public void setTechnical_info(String technical_info) {
        this.technical_info = technical_info;
    }

    public String getPhoto_url() {
        return photo_url;
    }

    public void setPhoto_url(String photo_url) {
        this.photo_url = photo_url;
    }

}

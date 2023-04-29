package bsuir.course.project.Interfaces;

import bsuir.course.project.Entity.Advert;
import bsuir.course.project.Entity.User;

import java.util.List;
import java.util.Optional;

public interface AdvertService {
    void createAdvert(Advert advert);
    void deleteAdvert(Advert advert);
    void deleteAdvertById(Integer id);
    void updateAdvert(Advert advert);
    List<Advert> getAllAdverts();
    Optional<Advert> getAdvertById(Integer id);
}

package bsuir.course.project.Interfaces;

import bsuir.course.project.Entity.Discussion;
import bsuir.course.project.Entity.Favourite;

import java.util.List;
import java.util.Optional;

public interface FavouriteService {
    void createFavourite(Favourite favourite);
    void deleteFavourite(Favourite favourite);
    void deleteFavouriteById(Integer id);
    void updateFavourite(Favourite favourite);
    List<Favourite> getAllFavourites();
    Optional<Favourite> getFavouriteById(Integer id);
}
